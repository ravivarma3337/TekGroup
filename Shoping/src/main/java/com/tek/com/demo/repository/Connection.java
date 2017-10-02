package com.tek.com.demo.repository;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tek.com.demo.model.Order;

@Component
public class Connection {
	@Autowired
	private DataSource data;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private int idCount = 0;

	public DataSource getDs() {
		return data;
	}

	public void setDs(DataSource dataSource) {
		this.data = dataSource;
		System.out.println("this set");
	}

	public int save(Order r) {
		String sql = "INSERT INTO newshoping " + "(orderId,UserOredred) VALUES (?, ?)";
		r.setOrderId(idCount + 1);
		jdbcTemplate.update(sql, new Object[] { r.getOrderId(), r.getUserOredred() });
		idCount++;
		return idCount;
	}

}
