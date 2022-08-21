package com.demo.jpql;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.demo.jpql.entity.Student;


public class Student_jpql {

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
Query query = em.createNamedQuery("find name");
@SuppressWarnings("unchecked")  
	        List<Student> list =query.getResultList();  
	          System.out.println("Student Name :");  
	          for(Student s:list) {  
	                
	             System.out.println(s.getName()+" "+s.getAge()+" "+s.getId());  
	          
	               
}  
	          
	          /*****WHERE******/
	          Query query2=em.createQuery("select s from Student s where id=2 ");
	          @SuppressWarnings("unchecked")
	  		List<Student> list2=query2.getResultList();
	          System.out.println("Student Details");
	          for (Student s : list2) {
	  			System.out.println(s.getName());
	  		}
	          
	          /*****UPDATE*******/
	          em.getTransaction().begin();
	      	Query query3=em.createQuery("update Student SET age=23 where id=1");
	          query3.executeUpdate();
	        
	          em.getTransaction().commit();
	          
	          
	          
	          
	          
	          
	          
	          
	          
          
        emf.close();  
        em.close();  
    }   
}
