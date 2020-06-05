package com.withackathon.springApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withackathon.springApi.entites.Login;
import com.withackathon.springApi.entites.Member;
import com.withackathon.springApi.exception.HandleException;
import com.withackathon.springApi.repository.MemberRepository;
import com.withackathon.springApi.response.Response;
import com.withackathon.springApi.service.LoginService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LoginRestController {

	@Autowired
	LoginService loginService;

	@Autowired
	Response response;

	// add mapping for POST /Member - login

	@PostMapping("/login")
	public ResponseEntity<Response> memberLogin(@RequestBody Login login) {
		try {
			if (loginService.isValidLogin(login)) {
				response.setMessage("Successfully Login");
				return new ResponseEntity<Response>(response, HttpStatus.OK);
			} else {
				response.setMessage("Wrong Credentials.Please try Again!!");
				return new ResponseEntity<Response>(response, HttpStatus.UNAUTHORIZED);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new HandleException(HttpStatus.BAD_REQUEST.value(), "Upstream Not Responding");

		}

	}

}
