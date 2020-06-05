package com.withackathon.springApi.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "order_information")
public class Order {
	
	public Order()
	{
		
	}

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "order_id", nullable = false, unique = true)
	private int orderId;
	
		
	@Column(name = "unique_id", nullable = false)
	@JsonView(Views.Create.class)
	private String uniqueId;

	@Column(name = "order_placed_date", nullable = false)
	@JsonFormat(pattern="dd/MM/YYYY")
	private Date orderDate;

	@Column(name = "created_by", nullable = false)
	private String createdBy;

	@Column(name = "created_at")
	@JsonFormat(pattern="dd/MM/YYYY")
	private Date createdAt;

	@Column(name = "delivery_date")
	@JsonFormat(pattern="dd/MM/YYYY")
	private Date deliveryDate;

	@Column(name = "packets_required")
	private String packetsRequired;
	
	
	public Order(String uniqueId, Date orderDate,String createdBy, Date createdAt,Date deliveryDate, String packetsRequired)
	{

		this.uniqueId=uniqueId;
		this.orderDate=orderDate;
		this.createdBy=createdBy;
		this.createdAt=createdAt;
		this.deliveryDate=deliveryDate;
		this.packetsRequired=packetsRequired;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getPacketsRequired() {
		return packetsRequired;
	}

	public void setPacketsRequired(String packetsRequired) {
		this.packetsRequired = packetsRequired;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
