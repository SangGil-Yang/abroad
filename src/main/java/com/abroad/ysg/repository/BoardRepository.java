package com.abroad.ysg.repository;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.domain.FileBoard;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

@Repository
public class BoardRepository {
	
	@PersistenceContext
	private EntityManager em;
	
	public void save(Board board)
	{
		if(board.getId() == null)
		{
			System.out.println("persist");
			System.out.println(board.getId());
			em.persist(board);
		}
		else
		{
			System.out.println("merge");
			em.merge(board);
		}
	}
	
	public Board fineOne(Long id)
	{
		return em.find(Board.class, id);
	}
	
	public List<Board> findAll()
	{
		return em.createQuery("select b from Board b", Board.class).getResultList();
	}
	
	public void remove(Board board)
	{
		Board b = em.getReference(Board.class, board.getId());
		em.remove(b);
	}
	
	public void insertFile(FileBoard fileBoard) throws Exception
	{
		em.persist(fileBoard);
	}

	public List<FileBoard> findfileAll(Long boardId) 
	{
		String filequery = "select fb from FileBoard fb join fetch fb.board b where b.id = " + boardId.toString();
		return em.createQuery(filequery, FileBoard.class).getResultList();
		
	}

	public FileBoard findfileone(Long fileBoardId) 
	{
		return em.find(FileBoard.class, fileBoardId);
	}

	public void deleteFile(Long boardId) 
	{
		String deletefile = "select fb from FileBoard fb join fetch fb.board b where b.id = " + boardId.toString();
		List<FileBoard> fileboards = em.createQuery(deletefile, FileBoard.class).getResultList();
		
		for(int i=0;i<fileboards.size();i++)
		{
			FileBoard fileboard = em.getReference(FileBoard.class, fileboards.get(i).getId());
			em.remove(fileboard);
		}
	}
	
}