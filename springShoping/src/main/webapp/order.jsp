<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tek.com.demo.model.Items,com.tek.com.demo.service.shopservice"%>
           <%@ page session="false"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Shopping App</title>
<body>

<h1>Order Has been placed</h1>

 <table>
     <tr>
     <td> OrderID:<td>
					<td><%=request.getSession().getAttribute("id")%><td>
      </tr>
      <tr>
     <td> User:<td>
					<td><%=request.getParameter("user") %><td>
      </tr>
      </table>
  <table border="1" >
     <tr><th>Item Name</th><th>Price</th><th>Quantity</th> </tr>
     <%
     List<Items> mp=(List<Items>) request.getSession().getAttribute("itemsAdded");
     if(mp!=null)
     {     
 
     for(Items i:mp)
     {
    	%> 
    	 <tr> 
    	 <td><%=i.getName()%> </td>
    	 <td><%=i.getPrice()%> </td>
    	 <td><%=i.getQuantity()%> </td>  
    	   </tr>
    	      
    <% }}
     request.getSession().invalidate();
     %>
       </table>
       
       
       </body>
       </html>