package com.abroad.ysg.service;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
	public void removeBoard(Board board)
	{
		boardRepository.remove(board);
	}
	public void saveBoard(Board board)
	{
		boardRepository.save(board);
	}
	
	public List<Board> findBoard()
	{
		return boardRepository.findAll();
	}
	
	public Board findOne(Long BoardId)
	{
		return boardRepository.fineOne(BoardId);
	}
}
