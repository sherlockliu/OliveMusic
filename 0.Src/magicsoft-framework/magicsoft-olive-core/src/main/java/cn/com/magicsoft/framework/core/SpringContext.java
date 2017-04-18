package cn.com.magicsoft.framework.core;

import java.lang.reflect.Field;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware {

	protected static ApplicationContext context;

	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		context = applicationContext;
	}

	public static ApplicationContext getContext() {
		return context;
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) getContext().getBean(name);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<?> cls) {
		return (T) getContext().getBean(cls);
	}
	
	public static void buildUp(Object obj){
		AutowireCapableBeanFactory factory = getContext().getAutowireCapableBeanFactory();
		factory.autowireBeanProperties(obj, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T create(Class<?> cls){
		AutowireCapableBeanFactory factory = getContext().getAutowireCapableBeanFactory();
		return (T)factory.createBean(cls, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
	}

	public static boolean containsBean(String name) {
		return getContext().containsBean(name);
	}

	public static Object getTarget(Object proxy) throws Exception {

		if (!AopUtils.isAopProxy(proxy)) {
			return proxy;// 不是代理对象
		}
		if (AopUtils.isJdkDynamicProxy(proxy)) {
			return getJdkDynamicProxyTargetObject(proxy);
		} else {
			return getCglibProxyTargetObject(proxy);
		}
	}

	private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
		Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
		h.setAccessible(true);
		Object dynamicAdvisedInterceptor = h.get(proxy);

		Field advised = dynamicAdvisedInterceptor.getClass().getDeclaredField("advised");
		advised.setAccessible(true);

		Object target = ((AdvisedSupport) advised.get(dynamicAdvisedInterceptor)).getTargetSource().getTarget();

		return target;
	}

	private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
		Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
		h.setAccessible(true);
		AopProxy aopProxy = (AopProxy) h.get(proxy);

		Field advised = aopProxy.getClass().getDeclaredField("advised");
		advised.setAccessible(true);

		Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();

		return target;
	}
}
