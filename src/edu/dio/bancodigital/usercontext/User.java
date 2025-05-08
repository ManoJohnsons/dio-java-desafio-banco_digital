package edu.dio.bancodigital.usercontext;

public class User {
    private String name;
    private int age;
    private boolean isMinor;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.isMinor = this.age < 18 ? true : false;
    }

    public String getName() {
        return name;
    }

    public boolean isMinor() {
        return isMinor;
    }
}
