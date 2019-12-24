package com.liws.reflect;

public class TestReflect {

    private Integer id;
    private String proName;
    public boolean isTest;

    public TestReflect() {
    }

    public TestReflect(Integer id, String proName) {
        this.id = id;
        this.proName = proName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }
}
