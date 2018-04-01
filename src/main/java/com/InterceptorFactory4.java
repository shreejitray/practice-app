package com;

import Annotation.TargetClass;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.AopUtils;
import org.springframework.aop.support.DefaultBeanFactoryPointcutAdvisor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class InterceptorFactory4 implements BeanPostProcessor {

    @Autowired
    ApplicationContext context;

    @Autowired
    List<MethodInterceptor> interceptors;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(interceptors!=null && interceptors.size()>0) {
            for(MethodInterceptor interceptor: interceptors) {
                TargetClass targetClass = interceptor.getClass().getAnnotation(TargetClass.class);
                if(targetClass!=null){
                    String name = targetClass.name();
                    if(name.equals(beanName)){
                        Advisor advisor = new DefaultPointcutAdvisor(interceptor);
                        if(bean instanceof Advised){
                            ((Advised)bean).addAdvisor(advisor);
                        }
                        ProxyFactory proxyFactory = new ProxyFactory(bean);
                        proxyFactory.addAdvisor(advisor);
                        proxyFactory.setProxyTargetClass(true);
                        bean= proxyFactory.getProxy();
                    }
                }
            }
        }
        return bean;
    }

}
