package com.abroad.ysg.web;

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

import com.abroad.ysg.domain.Login;
import com.abroad.ysg.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login/register.do")
	private String LoginRegister(Model model)
	{
		return "/login/register";
	}
	
	@RequestMapping(value = "/login/insertLogin.do")
	private String insertLogin(@ModelAttribute("login") Login login, Model model) throws Exception
	{
		loginService.save(login);
		return "main";
	}
}
