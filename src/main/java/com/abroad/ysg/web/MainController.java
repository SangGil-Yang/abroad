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
public class MainController {

	@RequestMapping(value="/main.do")
	public String main(Model model)
	{
		return "main";
	}
	
}
