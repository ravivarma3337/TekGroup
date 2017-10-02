<%@ page language="java" import="java.util.*"  contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.tek.servlet.items"%>
       <%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>S.No</th>
		<th>Cars</th>
		<th>Price</th>
	</tr>
	<tr>
		<th>1</th>
		<th>Honda</th>
		<th>30000</th>
	</tr>
	<tr>
		<th>2</th>
		<th>Audi</th>
		<th>50000</th>
	</tr>
	<tr>
		<th>3</th>
		<th>Toyota</th>
		<th>40000</th>
	</tr>
	<tr>
		<th>4</th>
		<th>Kia</th>
		<th>20000</th>
	</tr>	
</table>
<br>

<form action=options>
  Item number:<br>
  <input type="text" name="EnterItemnumber">
  <br>
  Quantity:<br>
  <input type="text" name="EnterQuantity">
  <br><br>
  <input type="submit" value="AddToCart" name="cart">
</form>

 <h4>Cart</h4>
      <table border="1" >
     <tr><th>Item Name</th><th>Price</th><th>Quantity</th> </tr>
     <%
     List<items> mp=(List<items>) request.getSession().getAttribute("itemsAdded");
     if(mp!=null)
     {     
 
     for(items i:mp)
     {
    	%> 
    	 <tr> 
    	 <td><%=i.getName()%> </td>
    	 <td><%=i.getPrice()%> </td> 
    	   </tr>
    	      
    <% }}
     
     %>
       </table>
     <form action="select" >
     <input type="submit" value="Checkout" name="method" />
     </form>

</body>
</html>