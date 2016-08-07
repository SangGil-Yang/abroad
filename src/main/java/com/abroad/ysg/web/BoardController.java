
package com.abroad.ysg.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.*;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abroad.ysg.domain.Board;
import com.abroad.ysg.domain.FileBoard;
import com.abroad.ysg.service.BoardService;
import com.abroad.ysg.util.FileUtil;

@Controller
public class BoardController {

	@Autowired 
	BoardService boardService;	

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
	public String insertBoard(@ModelAttribute("board") Board board, Model model, HttpServletRequest request) throws Exception
	{
		boardService.saveBoard(board, request);
		return "redirect:/boards/boardList.do";
	}
	
	@RequestMapping(value = "/boards/boardDetail.do")
	public String boardDetail(@ModelAttribute("board") Board board, Model model)
	{
		Long BoardId = board.getId();
		Board boards = boardService.findOne(BoardId);
		List<FileBoard> fileboard = boardService.findfileAll(BoardId);
		model.addAttribute("boardlist", boards);
		model.addAttribute("filelist", fileboard);
		return "/boards/boardDetail";
	}
	
	@RequestMapping(value = "/boards/openboardUpdate.do")
	public String openboardUpdate(@ModelAttribute("board") Board board, Model model)
	{
		Long BoardId = board.getId();
		Board boards = boardService.findOne(BoardId);
		List<FileBoard> fileboard = boardService.findfileAll(BoardId);
		model.addAttribute("boardlist", boards);
		model.addAttribute("filelist", fileboard);
		return "/boards/boardUpdate";
	}
	
	@RequestMapping(value = "/boards/boardUpdate.do")
	public String boardUpdate(@ModelAttribute("board") Board board, Model model, HttpServletRequest request) throws Exception
	{
		boardService.saveBoard(board, request);
		return "redirect:/boards/boardList.do";
	}
	
	@RequestMapping(value = "/boards/fileDelete.do")
	public String fileDelete(@ModelAttribute("board") Board board, Model model)
	{
		boardService.removeFile(board);
		Long BoardId = board.getId();
		Board boards = boardService.findOne(BoardId);
		List<FileBoard> fileboard = boardService.findfileAll(BoardId);
		model.addAttribute("boardlist", boards);
		model.addAttribute("filelist", fileboard);
		return "/boards/boardUpdate";
	}
	
	@RequestMapping(value = "/boards/boardDelete.do")
	public String boardDelete(@ModelAttribute("board") Board board, Model model)
	{
		Long BoardId = board.getId();
		Board boards = boardService.findOne(BoardId);
		boardService.removeBoard(boards);
		return "redirect:/boards/boardList.do";
	}
	
	@RequestMapping(value = "/boards/downloadFile.do")
	public void downloadFile(@ModelAttribute("fileboard") FileBoard fileboard, HttpServletResponse response) throws Exception
	{
		Long FileBoardId = fileboard.getId();
		FileBoard fileboards = boardService.findfileone(FileBoardId);
		String storedFileName = fileboards.getStored_file();
		String originalFileName = fileboards.getOrigin_file();
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("C:\\dev\\file\\"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	     
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
	}
}
