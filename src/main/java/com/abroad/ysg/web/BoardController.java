
package com.abroad.ysg.web;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.service.BoardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BoardController {

	@Autowired 
	BoardService boardService;	
	
	@RequestMapping(value = "/boards/boardList", method = RequestMethod.GET)
	public String boardList(Model model)
	{
		List<Board> boads = boardService.findBoard();
		model.addAttribute("boardlist", boads);
		return "boards/boardList";
	}
	
	@RequestMapping(value = "/boards/boardWrite")
	public String boardWrite(Model model)
	{
		return "boards/boardWrite";
	}
}
