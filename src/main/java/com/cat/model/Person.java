package com.cat.model;

public class Person {
    private String login;
    private String password;

    public Person() {
    }

    public Person(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
