package com.tek.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet(urlPatterns= {"/options"})
/**
 * Servlet implementation class Shopping
 */
public class Shopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shopping() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   items it1=new items("Honda","30000","1");
		    items it2=new items("Audi","50000","2");
		    items it3=new items("Toyota","40000","3");
		    items it4=new items("Kia","20000","4");
		HttpSession s = request.getSession();
		if(s.isNew()) {
			List<items> item = new ArrayList<items>();
			s.setAttribute("list", item);
		}
	
		String str = request.getParameter("option");
		if(str != null) {
			
		if(str.equals("1")) {
			request.getRequestDispatcher("showitems.jsp").forward(request, response);
			
		}
		else if(str.equals("2")) {
			request.getRequestDispatcher("checkout.jsp").forward(request, response);
			
		}
		else if(str.equals("3")) {
			request.getRequestDispatcher("vieworder.jsp").forward(request, response);
			
		}
		}
		String button = request.getParameter("cart");
			if(button.equals("AddToCart")) {
				String it = request.getParameter("EnterItemnumber");
				String iq = request.getParameter("EnterQuantity");
				List<items> l=(List<items>) request.getSession().getAttribute("list");
				if(it.equals("1"))
				{
				l.add(it1);
				}
				if(it.equals("2"))
				{
				l.add(it2);
				}
				if(it.equals("3"))
				{
				l.add(it3);
				}
				request.getSession().setAttribute("list", l);
				request.getRequestDispatcher("showitems.jsp").forward(request, response);
			}
		
	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
