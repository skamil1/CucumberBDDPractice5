package com.bddCompany.steps;

public class ConstructorPractice {
    String name;
    int age;
    boolean isBoy;

    public ConstructorPractice(){

    }

    public ConstructorPractice(boolean isBoy,String name) {
        this.isBoy = isBoy;
        this.name = name;

    }
    public ConstructorPractice(String name, int age, boolean isBoy) {
        this(isBoy, name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "ConstructorPractice{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isBoy=" + isBoy +
                '}';
    }
}
