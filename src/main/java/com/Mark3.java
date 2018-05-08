package com;

import Annotation.TargetClass;

@TargetClass(name = "something")
public class Mark3 {
    @TargetClass(name = "something")
    public void dummy(){
        System.out.println("this is a dummy method");
    }
}
