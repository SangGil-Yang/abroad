package com.abroad.ysg.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.abroad.ysg.domain.Login;

@Repository
public class LoginRepository {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Login login) 
	{	
		System.out.println(login.getId());
		if(login.getId() != null)
		{
			em.persist(login);
		}
		else
		{
			em.merge(login);
		}
	}

}
