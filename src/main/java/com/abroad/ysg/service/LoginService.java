package com.abroad.ysg.service;

import com.abroad.ysg.domain.Login;
import com.abroad.ysg.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	public void save(Login login) 
	{
		loginRepository.save(login);	
	}

}
