package com.demo.esports;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demo.esports.entity.Player;
import com.demo.esports.entity.Team;

public class Sports{
	
	public static void main(String args[]) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Sports_details");  
        EntityManager em=emf.createEntityManager();  
          
        em.getTransaction().begin();  
        
        Team team = new Team();
        Player p1=new Player();
        Player p2=new Player();
        Player p3=new Player();
        
        em.persist(team);
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        
        team.setName("set names of players ");
        p1.setP_name("scout");
        p1.setTeam(team);
        p2.setP_name("virat");
        p2.setTeam(team);
        p3.setP_name("rohit");
        p3.setTeam(team);
        em.getTransaction().commit();
  
        emf.close();  
        em.close(); 
	}
	
}