package com.example;

//import org.apache.poi.ss.formula.functions.Columns;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name="Student")
public class Student {
    @Id
    private int id;
    @Id
    @Column(name="name")
    private String name;
    private int age;
    private int mark;

    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public int getMark() {
        return mark;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Id=" + id +
                "name='" + name + '\'' +
                ", age=" + age + ",mark="+mark+
                '}';
    }
    
}
