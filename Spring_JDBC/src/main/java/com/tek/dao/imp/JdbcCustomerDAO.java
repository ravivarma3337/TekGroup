package com.tek.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.tek.dao.CustomerDAO;
import com.tek.model.Customer;

public class JdbcCustomerDAO implements CustomerDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void insert(Customer customer) {
		String sql = "INSERT INTO CUSTOMER" + "(CUST_ID,NAME, AGE) VALUES(?,?,?)";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pd = conn.prepareStatement(sql);
			pd.setInt(1, customer.getCustId());
			pd.setString(2, customer.getName());
			pd.setInt(3, customer.getAge());
			pd.executeUpdate();
			pd.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {

				}
			}
		}

	}

	public Customer findByCustomerId(int custId) {
		String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement pd = conn.prepareStatement(sql);
			pd.setInt(1, custId);
			Customer customer = null;
			ResultSet rs = pd.executeQuery();
			if (rs.next()) {
				Customer cus = new Customer(rs.getInt("CUST_ID"), rs.getString("NAME"), rs.getInt("Age"));
			}
			rs.close();
			pd.close();
			return customer;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}