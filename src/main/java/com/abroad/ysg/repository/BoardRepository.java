package com.abroad.ysg.repository;

import com.abroad.ysg.domain.Board;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class BoardRepository {
	
	@PersistenceContext
	EntityManager em;
	
	public void save(Board board)
	{
		em.persist(board);
	}
	
	public Board fineOne(Long id)
	{
		return em.find(Board.class, id);
	}
	
	public List<Board> findAll()
	{
		return em.createQuery("select b from Board b", Board.class).getResultList();
	}
	
}