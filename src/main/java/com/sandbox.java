package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class sandbox {
    public static void main(String[] args) {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                new String[] { "classpath:/config.xml" });
        QueryService service = (QueryService)appContext.getBean("queryService");
        service.getName();
    }
}
