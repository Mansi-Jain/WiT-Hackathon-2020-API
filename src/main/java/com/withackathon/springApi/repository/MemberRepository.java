package com.withackathon.springApi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.withackathon.springApi.entites.Member;

@Repository
public class MemberRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Member member) {
		 jdbcTemplate.update(
				"insert into member_information ( unique_id , first_name , last_name , contact_number,"
						+ "  address , number_of_dependants,password ) " + "values(?,?,?,?,?,?,?)",
				new Object[] { member.getUniqueId(), member.getFirstName(), member.getLastName(),
						member.getContactNumber(), member.getAddress(), Integer.parseInt(member.getNumberOfDependants())
								,member.getPassword()
						 });
	}
	
	public String getNoOfDependent(String uniqueId) {
	    String sql = "SELECT number_of_dependants FROM member_information WHERE unique_id=?";

	    String noOfDependent = (String) jdbcTemplate.queryForObject(
	            sql, new Object[] { uniqueId }, String.class);

	    return noOfDependent;
	}
	
	public String getCredential(String uniqueId)
	{
		 String sql = "SELECT password FROM member_information WHERE unique_id=?";

		    String key = (String) jdbcTemplate.queryForObject(
		            sql, new Object[] { uniqueId }, String.class);

		    return key;
	}

}
