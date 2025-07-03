package com.Parth;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class LearningHibernate {

    public static void main(String[] args) {
        
        //saveStudent(rollNumber, "name", "programme");
        
        //getStudent(rollNumber);
        
        //deleteStudent(rollNumber);
        
        //updateStudent(rollNumber, "name", "programme");
        
    }
    
    public static void saveStudent(int rollNumber, String name, String programme){
        
        Students s1 = new Students();
        s1.setrollNumber(rollNumber);
        s1.setname(name);
        s1.setprogramme(programme);
        
        /*Configuration config = new Configuration();
        config.addAnnotatedClass(com.Parth.Students.class);
        config.configure();---------(You can use like this or the line below this comment)*/
        
        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.Parth.Students.class)
                            .configure()
                            .buildSessionFactory();
        
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(s1);
        transaction.commit();
        session.close();
        sf.close();
        System.out.println("Student saved successfully.");
    }
    
    public static void getStudent(int rollNumber){
        
        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.Parth.Students.class)
                            .configure()
                            .buildSessionFactory();
        
        Session session = sf.openSession();
        Students student = session.find(Students.class, rollNumber);
        if (student != null) {
            System.out.println("Fetched Student: " + student.getname() + ", " + student.getprogramme());
        } else {
            System.out.println("No student found with ID: " + rollNumber);
        }
        session.close();
        sf.close();
    }
    
    public static void deleteStudent(int rollNumber){
    
        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.Parth.Students.class)
                            .configure()
                            .buildSessionFactory();
        
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        Students student = session.get(Students.class, rollNumber);
        if (student != null) {
            session.remove(student);
            System.out.println("Student deleted.");
        } else {
            System.out.println("No student found with ID: " + rollNumber);
        }
        tx.commit();

        session.close();
        sf.close();
    }
    
    public static void updateStudent(int rollNumber, String name, String programme){
    
        Students s1 = new Students();
        s1.setrollNumber(rollNumber);
        s1.setname(name);
        s1.setprogramme(programme);
        
        SessionFactory sf = new Configuration()
                            .addAnnotatedClass(com.Parth.Students.class)
                            .configure()
                            .buildSessionFactory();
        
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        Students student = session.get(Students.class, rollNumber);
        if (student != null) {
            student.setname(name);
            student.setprogramme(programme);
            session.merge(student); 
            System.out.println("Student updated: " + name + " (" + programme + ")");
        } else {
            System.out.println("No student found with ID: " + rollNumber);
        }

        transaction.commit();
        session.close();
        sf.close();
    }
}
