<%@page import="adapter.BuildAuto"%>
<%@page import="model.Automobile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Total price</title>
</head>
<body>
	<%
		String name = request.getParameter("model");
		BuildAuto auto = new BuildAuto();
		Automobile model = auto.getAutoMobile(name);
		float basePrice = model.getPrice();
	%>
	<P>Here is what you selected</P>
	<form>
		<table border="1">
			<!-- 1th row, showing the base price -->
			<tr>
				<%
					out.println("<td><input type= \"text\" value= \"" + name + "\" readonly></td>");
					out.println("<td><input type=\"text\" value=\"base price\"readonly></td>");
					out.println("<td><input type=\"text\" value=\"" + basePrice + "\"readonly></td>");
				%>
			</tr>

			<!-- 2th row, showing the color price -->
			<tr>
				<td><input type="text" value=Transmission readonly></td>
				<%
					String param1 = request.getParameter("Transmission");
					out.println("<td><input type=\"text\" value=\"" + param1 + "\"readonly></td>");
					float price1 = model.getOptionPrice("Transmission", param1);
					out.println("<td><input type=\"text\" value=\"" + price1 + "\"readonly></td>");
				%>
			</tr>

			<!-- 3th row, showing the transmission price -->
			<tr>
				<td><input type="text" value="Brakes" readonly></td>
				<%
					String param2 = request.getParameter("Brakes");
					out.println("<td><input type=\"text\" value=\"" + param2 + "\"readonly></td>");
					float price2 = model.getOptionPrice("Brakes", param2);
					out.println("<td><input type=\"text\" value=\"" + price2 + "\"readonly></td>");
				%>
			</tr>

			<!-- 4th row, showing the Brakes/Traction Control price -->
			<tr>
				<td><input type="text" value="Color" readonly></td>
				<%
					String param3 = request.getParameter("Color");
					out.println("<td><input type=\"text\" value=\"" + param3 + "\"readonly></td>");
					float price3 = model.getOptionPrice("Color", param3);
					out.println("<td><input type=\"text\" value=\"" + price3 + "\"readonly></td>");
				%>
			</tr>

			<!-- 5th row, showing the Side Impact Air Bags price -->
			<tr>
				<td><input type="text" value="SideImpactAirBags" readonly></td>
				<%
					String param4 = request.getParameter("SideImpactAirBags");
					out.println("<td><input type=\"text\" value=\"" + param4 + "\"readonly></td>");
					float price4 = model.getOptionPrice("SideImpactAirBags", param4);
					out.println("<td><input type=\"text\" value=\"" + price4 + "\"readonly></td>");
				%>
			</tr>

			<!-- 6th row, showing the Power Moonroof price -->
			<tr>
				<td><input type="text" value="PowerMoonroof" readonly></td>
				<%
					String param5 = request.getParameter("PowerMoonroof");
					out.println("<td><input type=\"text\" value=\"" + param5 + "\"readonly></td>");
					float price5 = model.getOptionPrice("PowerMoonroof",param5);
					out.println("<td><input type=\"text\" value=\"" + price5 + "\"readonly></td>");
				%>
			</tr>
			
			<tr>
				<td><input type="text" value="ABS" readonly></td>
				<%
					String param6 = request.getParameter("ABS");
					out.println("<td><input type=\"text\" value=\"" + param6 + "\"readonly></td>");
					float price6 = model.getOptionPrice("ABS",param6);
					out.println("<td><input type=\"text\" value=\"" + price6 + "\"readonly></td>");
				%>
			</tr>

			<!-- 7th row, showing the Total Price -->
			<tr>
				<td><input type="text" value="Total Price" readonly></td>
				<%
					out.println("<td></td>");
					float totalPrice = basePrice + price1 + price2 + price3 + price4 + price5 + price6;
					out.println("<td><input type=\"text\" value=\"" + totalPrice + "\"readonly></td>");
				%>
			</tr>
		</table>
	</form>
</body>
</html>

