package com.withackathon.springApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.withackathon.springApi.entites.Member;
import com.withackathon.springApi.exception.HandleException;
import com.withackathon.springApi.repository.MemberRepository;
import com.withackathon.springApi.response.Response;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	@Autowired
	MemberRepository memberRepo;

	@Autowired
	Response response;

	// add mapping for POST /Member - add new member

	@PostMapping("/add")
	public ResponseEntity<Response> addMember(@RequestBody Member theMember) {
		try {
			memberRepo.insert(theMember);
			response.setMessage("Successfully created member");
			response.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<Response>(response, HttpStatus.CREATED);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new HandleException(HttpStatus.BAD_REQUEST.value(), "Member Not created");

		}

	}

}
