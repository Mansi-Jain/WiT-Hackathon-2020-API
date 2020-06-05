package com.withackathon.springApi.service;

import com.withackathon.springApi.entites.Order;
import com.withackathon.springApi.repository.MemberRepository;
import com.withackathon.springApi.repository.OrderRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetOrderService {
	
	@Autowired
	MemberRepository memberRepo;
	
	@Autowired
	OrderRepository orderRepo;
	
	public Order setOrder(Order theOrder)
	{
		String userName=theOrder.getUniqueId();
		Date date = new Date();	
		Order order= new Order(userName,date,theOrder.getUniqueId(),date,getDeliveryDate(),getNumberOfPackets(userName));
		return order;
	}
	
	public Date getDeliveryDate()
	{

		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 2);
		dt = c.getTime();
		return dt;
	}
	
	public String getNumberOfPackets(String uniqueId)
	{
		return memberRepo.getNoOfDependent(uniqueId);
	}
	
	public boolean isFirstOrder(String uniqueId) {
		Integer orderCount =orderRepo.checkOrderExists(uniqueId);
		if (orderCount == 0)
		return true;
		return false;
	}
	
	public Date getLatestOrderDate(String uniqueId) throws ParseException
	{
		Date latestOrderDate= orderRepo.getLatestOrder(uniqueId);
		return latestOrderDate;
	}
	
	public boolean isCorrectOrder(String uniqueId) throws ParseException
	{

		Date latestDate=getLatestOrderDate(uniqueId);
		Date currentOrderDate=new Date();
		long diff = currentOrderDate.getTime() - latestDate.getTime();
		int diffhours = (int) (diff / (60 * 60 * 1000));

		if (diffhours > 240)
		return true;
		return false;
	}


}
