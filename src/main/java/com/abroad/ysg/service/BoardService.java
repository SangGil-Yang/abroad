package com.abroad.ysg.service;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.domain.FileBoard;
import com.abroad.ysg.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.abroad.ysg.util.FileUtil;

@Service
@Transactional
public class BoardService {
	
	@Autowired
	BoardRepository boardRepository;
	
//	@Resource(name = "fileUtils")
	private FileUtil fileUtil = new FileUtil();
	
	public void removeBoard(Board board)
	{
		boardRepository.remove(board);
	}
	
	public void saveBoard(Board board, HttpServletRequest request) throws Exception
	{
		boardRepository.save(board);
		
		List<FileBoard> fileBoards = fileUtil.parseInsertFileInfo(board, request);
		for(int i=0, size=fileBoards.size(); i<size; i++)
		{
			boardRepository.insertFile(fileBoards.get(i));
		}
	}
	
	public List<Board> findBoard()
	{
		return boardRepository.findAll();
	}
	
	public Board findOne(Long BoardId)
	{
		return boardRepository.fineOne(BoardId);
	}

	public List<FileBoard> findfileAll(Long BoardId) 
	{
		return boardRepository.findfileAll(BoardId);
	}

	public FileBoard findfileone(Long fileBoardId) 
	{
		return boardRepository.findfileone(fileBoardId);
	}

	public void removeFile(Board board) 
	{
		boardRepository.deleteFile(board.getId());
	}
}
