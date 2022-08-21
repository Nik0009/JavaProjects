package com.demojpaupdate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demojpaupdate.entity.StudentEntity;

public class UpdateStudent {  
      
    public static void main(String args[])  	    {  
		        EntityManagerFactory emf=Persistence.createEntityManagerFactory("Student_details");  
		        EntityManager em=emf.createEntityManager();  
		          
		      
		          
		        StudentEntity s=em.find(StudentEntity.class,102);  
		        System.out.println("Before Updation");  
	       System.out.println("Student id = "+s.getId());  
		        System.out.println("Student Name = "+s.getName());  
		        System.out.println("Student Age = "+s.getAge());  
	          
		        s.setName("rohit");
		        s.setAge(30);  
          
	        System.out.println("After Updation");  
	        System.out.println("Student id = "+s.getId());  
		        System.out.println("Student Name = "+s.getName());  
	        System.out.println("Student Age = "+s.getAge());  
		          
		          
	    }  
	  
		}