
package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Emp_Servelet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "root");

			if (req.getParameter("method").equals("submit")) {

				String email= req.getParameter("email");
				System.out.println(req.getParameter("name"));
				
				String sql = "insert into new_table" + "(name,email,phone)" + "values(?,?,?)";
				PreparedStatement myst1 = mycon.prepareStatement(sql);
				myst1.setString(1, req.getParameter("name"));
				myst1.setString(2, req.getParameter("email"));
				myst1.setString(3, req.getParameter("phone"));
				

				myst1.executeUpdate();

				PrintWriter out = resp.getWriter();
				out.println("saved");

			}

			if (req.getParameter("method").equals("Delete")) {

				String sql2 = "delete from new_table where name= ?";
				PreparedStatement myst = mycon.prepareStatement(sql2);
				myst.setString(1, req.getParameter("name"));
				myst.execute();
				PrintWriter p = resp.getWriter();

				p = resp.getWriter();
				p.println("Data deleted sucessfully");
			}

		} catch (SQLException e) {
			System.out.println("something error happened");
			e.printStackTrace();
		}
	}

}