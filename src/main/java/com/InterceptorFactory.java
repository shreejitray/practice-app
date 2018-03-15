package com;

import Annotation.TargetClass;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Configuration
public class InterceptorFactory {

    @Autowired
    ApplicationContext context;

    @Autowired
    List<MethodInterceptor> interceptors;

    @Bean(name = "wrappedQueryService")
    public ProxyFactoryBean registerInterceptor(){
        System.out.println("interceptor registers");
        ProxyFactoryBean factoryBean = new ProxyFactoryBean();
        for(MethodInterceptor interceptor:interceptors) {
            TargetClass targetClass = AnnotationUtils.findAnnotation(interceptor.getClass(),TargetClass.class);
            String target = targetClass.name();
            factoryBean.setProxyTargetClass(true);
            factoryBean.setTarget(context.getBean(target));
            factoryBean.setInterceptorNames("custom-interceptor");
        }
        context.
        return factoryBean;
    }
}
