package com.demo.dynamicjpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.dynamicjpql.entity.Student;

public class DynamicJpql {

	public static void main(String args[])  
    {  
          
    EntityManagerFactory emf=Persistence.createEntityManagerFactory("Student_details");  
        EntityManager em=emf.createEntityManager();  
          
em.getTransaction().begin();  
          
        Student s1=new Student();  
        //s1.setId(101);  
        s1.setName("Gaurav");  
        s1.setAge(25);  
          
        Student s2=new Student();  
        //s2.setId(102);  
        s2.setName("Ronit");  
        s2.setAge(22);  
          
        Student s3=new Student();  
        //s3.setId(103);  
        s3.setName("Rahul");  
        s3.setAge(26);  
          
        em.persist(s1);  
        em.persist(s2);  
        em.persist(s3);       
  
em.getTransaction().commit();  
Query query = em.createQuery("select s from Student s");
@SuppressWarnings("unchecked")
List<Student> list=query.getResultList();
for(Student s:list) {
	System.out.println(s.getName());
}
          
        emf.close();  
        em.close();  
    }   
}

