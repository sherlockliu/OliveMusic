package cn.com.magicsoft.framework.core;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.slf4j.ext.XLogger;
import org.slf4j.ext.XLoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
/**
 * log4j工具类
 * 
 * @author sun.wr
 * @date 2015-4-15 下午5:14:39
 * @version 0.1.0
 * @copyright yougou.com
 */
@Component
public class Log4jUtil implements InitializingBean {
	private static final XLogger log = XLoggerFactory
			.getXLogger(Log4jUtil.class);

	private  void inti() {
		String env = System.getProperty("env");
		if ("online".equals(env)) {
			Log4jUtil.removeConsoleAppender();
			Log4jUtil.setBufferIoTrue();
			Log4jUtil.addShutdownHookFlushLog();
			log.info("★★★★★★★★★★★★★★★★正式环境日志初始化完成★★★★★★★★★★★★★★★★");
		} else if ("train".equals(env)) {
			Log4jUtil.removeConsoleAppender();
			Log4jUtil.setBufferIoTrue();
			Log4jUtil.addShutdownHookFlushLog();
			log.info("★★★★★★★★★★★★★★★★培训环境日志初始化完成★★★★★★★★★★★★★★★★");
		} else {
			log.info("★★★★★★★★★★★★★★★★开发环境日志初始化完成★★★★★★★★★★★★★★★★");
		}
		
	}

	/**
	 * 马上打印缓冲区
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static void flushImmediately() {
		org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger
				.getRootLogger();
		flushImmediately(rootLogger);
		// 获取所有的package log configuration
		Enumeration currentLoggers = org.apache.log4j.LogManager
				.getCurrentLoggers();
		while (currentLoggers.hasMoreElements()) {
			org.apache.log4j.Logger logger = (org.apache.log4j.Logger) currentLoggers
					.nextElement();
			flushImmediately(logger);
		}
	}

	/**
	 * 关闭程序时打印缓冲区日志
	 * 
	 * @param log
	 */
	public static void addShutdownHookFlushLog() {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			@Override
			public void run() {
				flushImmediately();
			}
		}));
	}

	/**
	 * 把日志缓存区打开
	 */
	@SuppressWarnings("rawtypes")
	public static void setBufferIoTrue() {
		org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger
				.getRootLogger();
		setBufferIoTrue(rootLogger);
		// 获取所有的package log configuration
		Enumeration currentLoggers = org.apache.log4j.LogManager
				.getCurrentLoggers();
		while (currentLoggers.hasMoreElements()) {
			org.apache.log4j.Logger logger = (org.apache.log4j.Logger) currentLoggers
					.nextElement();
			setBufferIoTrue(logger);
		}
	}

	@SuppressWarnings("rawtypes")
	private static void flushImmediately(org.apache.log4j.Logger logger) {
		Enumeration allAppenders = logger.getAllAppenders();
		while (allAppenders.hasMoreElements()) {
			Appender appender = (Appender) allAppenders.nextElement();
			if (appender instanceof FileAppender) {
				FileAppender rollingFileAppender = (FileAppender) appender;
				if (!rollingFileAppender.getImmediateFlush()) {
					rollingFileAppender.setImmediateFlush(true);
					logger.info("flush Immediate ");
					rollingFileAppender.setImmediateFlush(false);
				}
			}
		}
	}

	@SuppressWarnings("rawtypes")
	private static void setBufferIoTrue(org.apache.log4j.Logger logger) {
		Enumeration allAppenders = logger.getAllAppenders();
		while (allAppenders.hasMoreElements()) {
			Appender appender = (Appender) allAppenders.nextElement();
			if (appender instanceof FileAppender) {
				FileAppender rollingFileAppender = (FileAppender) appender;
				rollingFileAppender.setBufferedIO(true);
				// rollingFileAppender.setBufferSize();
			}
		}
	}

	/**
	 * 去掉控制台打印
	 */
	@SuppressWarnings("rawtypes")
	public static void removeConsoleAppender() {
		org.apache.log4j.Logger rootLogger = org.apache.log4j.Logger
				.getRootLogger();
		removeConsoleAppender(rootLogger);
		Enumeration currentLoggers = org.apache.log4j.LogManager
				.getCurrentLoggers();
		while (currentLoggers.hasMoreElements()) {
			org.apache.log4j.Logger logger = (org.apache.log4j.Logger) currentLoggers
					.nextElement();
			removeConsoleAppender(logger);
		}
	}

	@SuppressWarnings("rawtypes")
	private static void removeConsoleAppender(org.apache.log4j.Logger logger) {
		Enumeration allAppenders = logger.getAllAppenders();
		List<Appender> consoleAppender = new ArrayList<>();
		while (allAppenders.hasMoreElements()) {
			Appender appender = (Appender) allAppenders.nextElement();
			if (appender instanceof ConsoleAppender) {
				consoleAppender.add(appender);
			}
		}
		// 不打印在控制台
		for (Appender appender : consoleAppender) {
			System.out.println("remove consoleAppender");
			logger.removeAppender(appender);
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		 this.inti();
	}

}
