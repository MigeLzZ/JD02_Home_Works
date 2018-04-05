<%@page import="java.io.PrintWriter"%>
<%@page import="by.htp.carparking.service.impl.CarParkingEntityImpl"%>
<%@page import="by.htp.carparking.service.CarParkingEntityService"%>
<%@page import="by.htp.carparking.domain.Car"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	CarParkingEntityService service = new CarParkingEntityImpl();
	Car car = service.getCar(Integer.parseInt(request.getParameter("car_id")));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=car.getBrand() + " " + car.getModel()%></title>
</head>
<body>

	<form method='get' action='/carparking/MainServlet'>
		<input type='hidden' name='command' value='delete_car_action' /> <input
			type='hidden' name='car_id'
			value='"<%=request.getParameter("car_id")%>"' />
		<%=car%>
		<p></p>
		<input type='submit' formmethod='get' value='Delete' />
	</form>
</body>
</html>