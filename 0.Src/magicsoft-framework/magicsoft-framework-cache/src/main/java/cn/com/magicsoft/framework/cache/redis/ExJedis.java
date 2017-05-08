/**
 * TODO: 增加描述
 * 
 * @author user
 * @date 2015-4-7 上午11:44:11
 * @version 0.1.0
 * @copyright www.wonhigh.cn 
 */
package cn.com.magicsoft.framework.cache.redis;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.ReflectionUtils;

import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;
import redis.clients.jedis.Protocol.Command;
import redis.clients.util.RedisOutputStream;
import redis.clients.util.SafeEncoder;

/**
 * jedis扩展类，因为暂时不好升级jedis客户端，以后最好升级客户端
 * @author user
 * @date 2015-4-7 上午11:44:11
 * @version 0.1.0 
 * @copyright www.wonhigh.cn 
 */
class ExJedis {

	private final double score = 1;

	private Client client;

	private static Map<String, Method> methodCache = new HashMap<String, Method>();

	private static Map<String, Field> fieldCache = new HashMap<String, Field>();

	private static final String SENDCOMMAND_METHOD = "sendCommand";

	private static final String ZRANGEBYLEX_CMD = "ZRANGEBYLEX";

	/**
	 * @param host
	 * @param jedis
	 */
	public ExJedis(Jedis jedis) {
		this.client = jedis.getClient();
	}

	private final byte[] default_score = SafeEncoder.encode(String.valueOf(score));

	public Long mzadd(String key, Map<String, Double> scoreMembers) {
		ArrayList<byte[]> args = new ArrayList<byte[]>(scoreMembers.size() * 2 + 1);
		args.add(SafeEncoder.encode(key));
		for (Map.Entry<String, Double> entry : scoreMembers.entrySet()) {
			args.add(SafeEncoder.encode(String.valueOf(entry.getValue())));
			args.add(SafeEncoder.encode(entry.getKey()));
		}
		byte[][] argsArray = new byte[args.size()][];
		args.toArray(argsArray);
		sendCommand(Command.ZADD, argsArray);
		return client.getIntegerReply();
	}

	private void sendCommand(Command command, byte[][] argsArray) {
		Method method = methodCache.get(SENDCOMMAND_METHOD);
		if (method == null) {
			method = ReflectionUtils.findMethod(Client.class, SENDCOMMAND_METHOD, Command.class, argsArray.getClass());
			method.setAccessible(true);
			methodCache.put(SENDCOMMAND_METHOD, method);
		}
		try {
			method.invoke(client, command, argsArray);
		} catch (Exception e) {
			throw new RuntimeException("执行命令出错", e);
		}
	}

	private void _sendExtCommand(byte[] command, List<byte[]> args) throws IOException {
		client.connect();
		Field field = fieldCache.get("outputStream");
		if (field == null) {
			field = ReflectionUtils.findField(Client.class, "outputStream");
			field.setAccessible(true);
			fieldCache.put("outputStream", field);
		}
		RedisOutputStream os = (RedisOutputStream) ReflectionUtils.getField(field, client);
		os.write(Protocol.ASTERISK_BYTE);
		os.writeIntCrLf(args.size() + 1);
		os.write(Protocol.DOLLAR_BYTE);
		os.writeIntCrLf(command.length);
		os.write(command);
		os.writeCrLf();
		for (final byte[] arg : args) {
			os.write(Protocol.DOLLAR_BYTE);
			os.writeIntCrLf(arg.length);
			os.write(arg);
			os.writeCrLf();
		}
		Field pipeline = fieldCache.get("pipelinedCommands");
		if (pipeline == null) {
			pipeline = ReflectionUtils.findField(Client.class, "pipelinedCommands");
			pipeline.setAccessible(true);
			fieldCache.put("pipelinedCommands", pipeline);
		}
		int pipCount = Integer.valueOf(ReflectionUtils.getField(pipeline, client) + "");
		ReflectionUtils.setField(pipeline, client, pipCount + 1);
	}

	public Long mzadd(String key, Set<String> scoreMembers) {
		ArrayList<byte[]> args = new ArrayList<byte[]>(scoreMembers.size() * 2 + 1);
		args.add(SafeEncoder.encode(key));
		for (String member : scoreMembers) {
			args.add(default_score);
			args.add(SafeEncoder.encode(member));
		}
		byte[][] argsArray = new byte[args.size()][];
		args.toArray(argsArray);
		sendCommand(Command.ZADD, argsArray);
		return client.getIntegerReply();
	}

	public Collection<String> zrangebylex(String key, String min, String max, int start, int take) {
		ArrayList<byte[]> args = new ArrayList<byte[]>();
		args.add(SafeEncoder.encode(key));
		args.add(SafeEncoder.encode(min));
		args.add(SafeEncoder.encode(max));
		args.add(Protocol.Keyword.LIMIT.raw);
		args.add(SafeEncoder.encode(String.valueOf(start)));
		args.add(SafeEncoder.encode(String.valueOf(take)));
		try {
			_sendExtCommand(SafeEncoder.encode(ZRANGEBYLEX_CMD), args);
		} catch (IOException e) {
			throw new RuntimeException("sendcmd error", e);
		}
		return client.getMultiBulkReply();
	}
}
