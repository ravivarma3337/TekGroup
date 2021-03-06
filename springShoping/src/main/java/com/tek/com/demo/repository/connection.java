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

import com.tek.com.demo.model.finalorder;

@Component
public class connection {
	@Autowired
	private DataSource ds;
	@Autowired
	private JdbcTemplate jt;
	private int idCount = 0;

	public DataSource getDs() {
		return ds;
	}

	public void setDs(DataSource ds) {
		this.ds = ds;
		System.out.println("this set");
	}

	public int save(finalorder r) {
		String sql = "INSERT INTO newshoping " + "(orderId,UserOredred) VALUES (?, ?)";
		r.setOrderId(idCount + 1);
		jt.update(sql, new Object[] { r.getOrderId(), r.getUserOredred() });
		idCount++;
		return idCount;
	}

}
