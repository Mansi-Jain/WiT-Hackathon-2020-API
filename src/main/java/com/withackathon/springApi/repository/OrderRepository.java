package com.withackathon.springApi.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.withackathon.springApi.entites.Order;

@Repository
public class OrderRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void insert(Order order) {

		jdbcTemplate.update(
				"insert into order_information ( order_id,unique_id , order_placed_date , created_by , created_at,"
						+ "  delivery_date , packets_required ) " + "values(?,?,?,?,?,?,?)",
				new Object[] { order.getOrderId(), order.getUniqueId(), order.getOrderDate(), order.getCreatedBy(),
						order.getCreatedAt(), order.getDeliveryDate(), Integer.parseInt(order.getPacketsRequired()) });

	}

	public Date getLatestOrder(String uniqueId) {
		System.out.println("inside repo for getLatestOrder");

		String sql = "select max(order_placed_date) from order_information where unique_id=? ";

		Date latestOrderDate = (Date) jdbcTemplate.queryForObject(sql, new Object[] { uniqueId }, Date.class);
		System.out.println("inside repo for getLatestOrder" + latestOrderDate);

		return latestOrderDate;
	}

	public Integer checkOrderExists(String uniqueId) {
		String sql = "SELECT COUNT(*) FROM order_information where unique_id=? ";

		Integer orderCount = (Integer) jdbcTemplate.queryForObject(sql, new Object[] { uniqueId }, Integer.class);

		return orderCount;
	}

	public List<Order> getOrderEntities(String userName) throws Exception {
		// TODO Auto-generated method stub

		String sql = "select * from order_information  where unique_id= '" + userName + "'";

		try {

			List<Order> result = jdbcTemplate.query(sql, new RowMapper<Order>() {
				@Override
				public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
					System.out.println("rs is given as" + rs);
					Order order = new Order();
					order.setOrderId(rs.getInt("order_id"));
					order.setUniqueId(rs.getString("unique_id"));
					order.setPacketsRequired(String.valueOf(rs.getInt("packets_required")));
					order.setCreatedAt(rs.getDate("created_at"));
					order.setOrderDate(rs.getDate("order_placed_date"));
					order.setDeliveryDate(rs.getDate("delivery_date"));
					order.setCreatedBy(rs.getString("created_by"));

					return order;
				}
			});

			return result;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Unable to fetch order data from database");
		}

	}

}
