package org.example.Person;

public class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int changeAge (int newAge) {
        if (newAge <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative!");
        }
        return this.age + newAge;
    }
}
