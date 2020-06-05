package com.withackathon.springApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.withackathon.springApi.entites.Order;
import com.withackathon.springApi.entites.Views;
import com.withackathon.springApi.exception.HandleException;
import com.withackathon.springApi.repository.OrderRepository;
import com.withackathon.springApi.response.Response;
import com.withackathon.springApi.service.SetOrderService;

@RestController
@RequestMapping("/api/order")
@CrossOrigin
public class OrderRestController {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	SetOrderService orderService;

	@Autowired
	Response response;

	// add mapping for POST /Member - add new member

	@PostMapping("/add")
	public ResponseEntity<Response> addOrder(@RequestBody @JsonView(Views.Create.class) Order theorder) {
		try {
			String uniqueId = theorder.getUniqueId();
			boolean isFirstOrder = orderService.isFirstOrder(uniqueId);
			if (isFirstOrder) {
				System.out.println("Inside first record");
				Order order = orderService.setOrder(theorder);
				orderRepo.insert(order);
				response.setMessage("Successfully created order");
				return new ResponseEntity<Response>(response, HttpStatus.CREATED);
			} else {
				boolean isCorrectOrder = orderService.isCorrectOrder(uniqueId);
				if (isCorrectOrder) {
					Order order = orderService.setOrder(theorder);
					orderRepo.insert(order);
					response.setMessage("Successfully created order");
					return new ResponseEntity<Response>(response, HttpStatus.CREATED);
				} else {
					response.setMessage("Cannot create new order.Order is already inline");
					return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);

				}
			}
		} catch (Exception ex) {

			throw new HandleException(HttpStatus.BAD_REQUEST.value(), "Upstream not Responding");

		}

	}

	// add mapping for GET /order/{userName}

	@GetMapping("/{uniqueId}")
	public ResponseEntity<List<Order>> getOrders(@PathVariable String uniqueId) throws Exception {

		List<Order> orders = orderRepo.getOrderEntities(uniqueId);

		if (orders == null) {
			throw new HandleException(HttpStatus.NOT_FOUND.value(), "No order found for this user - " + uniqueId);
		}

		return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
	}

}
