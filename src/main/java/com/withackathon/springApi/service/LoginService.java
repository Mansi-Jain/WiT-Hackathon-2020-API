package com.withackathon.springApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.withackathon.springApi.entites.Login;
import com.withackathon.springApi.repository.MemberRepository;

@Component
public class LoginService {

	
	@Autowired
	MemberRepository memberRepo;
	
	public String getstoredCredential(String userName)
	{
		String password =memberRepo.getCredential(userName);
		return password ;
		
	}
	
	public boolean isValidLogin(Login login)
	{
		String requestPwd = login.getPassword();
		String storedPwd = getstoredCredential(login.getUniqueId());
		if(requestPwd.equals(storedPwd))
		return true;
		return false;
	}
}
