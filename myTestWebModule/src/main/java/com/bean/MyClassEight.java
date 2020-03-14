package com.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyClassEight {
    private MyClassNine myClassNine;

    public MyClassEight() {
        System.out.println("MyClassEightOne");
    }

    @Autowired
    public MyClassEight(MyClassNine myClassNine) {
        System.out.println("MyClassEightTwo");
        this.myClassNine = myClassNine;
    }
}
