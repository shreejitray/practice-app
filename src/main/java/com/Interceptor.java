package com;

import Annotation.TargetClass;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component("custom-interceptor")
@TargetClass(name = "queryService")
public class Interceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Method invoked"+invocation.getMethod());
        Object value = invocation.proceed();
        System.out.println("Method invocation complete");
        return value;
    }
}
