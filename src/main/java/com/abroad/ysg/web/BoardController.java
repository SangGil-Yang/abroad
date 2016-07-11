
package com.abroad.ysg.web;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {

	@Autowired 
	BoardService boardService;	
	//, method = RequestMethod.GET
	@RequestMapping(value = "/boards/boardList.do")
	public String boardList(Model model)
	{
		List<Board> boads = boardService.findBoard();
		model.addAttribute("boardlist", boads);
		return "/boards/boardList";
	}
	
	@RequestMapping(value = "/boards/boardWrite.do")
	public String boardWrite(Model model)
	{
		return "/boards/boardWrite";
	}
	
	@RequestMapping(value = "/boards/insertBoard.do")
	public String insertBoard(@ModelAttribute("board") Board board, Model model)
	{
		boardService.saveBoard(board);
		return "redirect:/boards/boardList.do";
	}
	
	@RequestMapping(value = "/boards/boardDetail.do")
	public String boardDetail(@ModelAttribute("board") Board board, Model model)
	{
		Long BoardId = board.getId();
		Board boards = boardService.findOne(BoardId);
		model.addAttribute("boardlist", boards);
		return "/boards/boardDetail";
	}
	
	@RequestMapping(value = "/boards/openboardUpdate.do")
	public String openboardUpdate(@ModelAttribute("board") Board board, Model model)
	{
		Long BoardId = board.getId();
		Board boards = boardService.findOne(BoardId);
		model.addAttribute("boardlist", boards);
		return "/boards/boardUpdate";
	}
	
	@RequestMapping(value = "/boards/boardUpdate.do")
	public String boardUpdate(@ModelAttribute("board") Board board, Model model)
	{
		boardService.saveBoard(board);
		return "redirect:/boards/boardList.do";
	}
	
	@RequestMapping(value = "/boards/boardDelete.do")
	public String boardDelete(@ModelAttribute("board") Board board, Model model)
	{
		Long BoardId = board.getId();
		System.out.println(BoardId);
		Board boards = boardService.findOne(BoardId);
		boardService.removeBoard(boards);
		return "redirect:/boards/boardList.do";
	}
}
