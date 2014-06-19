package net.fanzhiwei.design_pattern.proxy.java_dynamic_proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeingInvocationHandler implements InvocationHandler {
	// 被代理的对象
	private Object proxied;

	public TimeingInvocationHandler(Object proxied) {
		this.proxied = proxied;
	}

	// 参数 proxy 表示代理类的对象
	// 参数 method 表示被代理类 和 代理类 都实现的接口 的方法对象
	// 参数 args 表示方法 method 的参数数组
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(method.getDeclaringClass().getName());
		long currentTimeMillis = System.currentTimeMillis();
		Object ret = method.invoke(proxied, args);
		System.out.println(this.getClass().getSimpleName()
				+ " >> wastes time : "
				+ (System.currentTimeMillis() - currentTimeMillis) + "ms");
		return ret;
	}
}
