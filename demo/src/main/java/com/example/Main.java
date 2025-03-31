package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student o1=new Student();
        o1.setId(1);
        o1.setName("raj");
        o1.setAge(23);
        o1.setMark(90); 

        SessionFactory factory = new Configuration().addAnnotatedClass(com.example.Student.class).configure().buildSessionFactory();
        Session session = factory.openSession(); 

        session.persist(o1);
        Transaction s1 = session.beginTransaction() ; 
        s1.commit(); 
        session.close();
        factory.close();
    }
}