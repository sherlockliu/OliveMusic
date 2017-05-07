package cn.com.magicsoft.framework.web.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.com.magicsoft.framework.core.constants.PublicKeys;
import cn.com.magicsoft.framework.core.monitor.PerformanceCounter;
import cn.com.magicsoft.framework.core.monitor.PerformanceLogger;
import cn.com.magicsoft.framework.core.monitor.PerformanceManager;
import cn.com.magicsoft.framework.core.security.SecurityUser;
import cn.com.magicsoft.framework.web.filter.HttpSessionExtendWrapper;

/**
 * 用于打印日志
 * 
 * @author sun.wr
 * @date 2014-7-29 上午10:48:51
 * @version 0.1.0
 * @copyright yougou.com
 */
public class LogInterceptor implements HandlerInterceptor {

	private PerformanceCounter counter;

	private PerformanceCounter getCounter() {
		if (counter == null)
			counter = PerformanceManager.getInstance().getCounter("web.query");
		return counter;
	}

	private PerformanceCounter getErrorCounter() {
		if (counter == null)
			counter = PerformanceManager.getInstance().getCounter("web.query.error");
		return counter;
	}

	private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("LogInterceptor");

	private NamedThreadLocal<String> viewNameThreadLocal = new NamedThreadLocal<String>("viewName");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long beginTime = System.currentTimeMillis();// 1、开始时间
		request.setAttribute("env", System.getProperty("env", "dev"));
		startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
		return true;// 继续流程
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			String viewName = modelAndView.getViewName();
			viewNameThreadLocal.set(viewName);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if (ex != null)
			getErrorCounter().increment(0);
		String url = request.getRequestURI();

		long take;
		Long startTime = startTimeThreadLocal.get();
		if (request.getRequestURI().indexOf("sys/") > 0 || request.getRequestURI().indexOf("common/") > 0
				|| request.getRequestURI().indexOf(".ig") > 0)
			return;
		try {

			take = System.currentTimeMillis() - startTime;
			response.addHeader("_takes", take + "");
			// 计数
			getCounter().increment(take);
			HttpSessionExtendWrapper session = (HttpSessionExtendWrapper) request.getSession();
			// 用户
			SecurityUser user = (SecurityUser) session.getAttribute(PublicKeys.SESSION_USER, false);
			String uname = "";
			if (user != null) {
				uname = user.getLoginName();
			}
			PerformanceLogger.log("web", url, ex == null ? "ok" : "error", take, uname);
			logForDev(request, handler);
		} catch (Exception e) {
			log.error("afterCompletion", e);
		} finally {
			viewNameThreadLocal.remove();
			startTimeThreadLocal.remove();
		}

		Thread thread = Thread.currentThread();
		String threadName = thread.getName();
		thread.setName(threadName.split("\\$")[0]);
	}

	/**
	 * 开发者使用 方便查找ftl,conrol
	 * 
	 * @param request
	 * @param handler
	 */
	private void logForDev(HttpServletRequest request, Object handler) {
		String env = System.getProperty("env");
		if ("online".equals(env) || "train".equals(env)) {
			return;
		}

		String spiltStr = ",";
		StringBuilder sb = new StringBuilder();
		// 类及方法
		if (handler instanceof HandlerMethod) {
			HandlerMethod hm = (HandlerMethod) handler;
			Method method = hm.getMethod();
			Class<?> parentCl = hm.getMethod().getDeclaringClass();
			Class<?> controlCl = hm.getBean().getClass();
			// 暂时取不到方法的行数 使用70替代下 TODO
			sb.append("(").append(parentCl.getSimpleName()).append(".java:70).").append(method.getName());

			if (!parentCl.getSimpleName().equals(controlCl.getSimpleName())) {
				sb.append("(").append(controlCl.getSimpleName()).append(")");
			}
		} else {
			sb.append(handler.getClass().getSimpleName());
		}
		sb.append(spiltStr);
		// 请求URL+queryString
		sb.append(request.getRequestURI());
		if (request.getQueryString() != null) {
			sb.append("?").append(request.getQueryString());
		}
		// 跳转到哪个页面
		String viewName = viewNameThreadLocal.get();
		if (viewName != null) {
			sb.append(spiltStr).append("jump to:");
			// sb.append("WEB-INF/ftl/pages/");
			sb.append(viewName).append(".ftl");
		}
		// 消耗时间
		Long startTime = startTimeThreadLocal.get();
		if (startTime != null) {
			sb.append(spiltStr).append("takes time:").append((System.currentTimeMillis() - startTime)).append("ms");
		}
		// //用户
		// SystemUser
		// user=(SystemUser)request.getSession(false).getAttribute(PublicContains.SESSION_USER);
		// if(user!=null)
		// {
		// sb.append(",user:").append(user.getLoginName()).append(spiltStr);
		// }
		log.info(sb.toString());

	}

}