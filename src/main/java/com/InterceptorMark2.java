package com;

import Annotation.TargetClass;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
@TargetClass(name = "queryService")
public class InterceptorMark2 implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("mark2 interceptor");
       return invocation.proceed();
    }
}
