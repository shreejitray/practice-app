package com;

import Annotation.TargetClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class sandbox {
    public static void main(String[] args) {
        if(Mark3.class.isAnnotationPresent(TargetClass.class)){
            System.out.println("this works");
        } else {
            System.out.println("this doesnt work");
        }
    }
}
