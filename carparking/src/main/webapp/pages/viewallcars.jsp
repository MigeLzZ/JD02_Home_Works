<%@page import="by.htp.carparking.domain.Car"%>
<%@page import="by.htp.carparking.service.impl.CarParkingEntityImpl"%>
<%@page import="by.htp.carparking.service.CarParkingEntityService"%>
<%@page import="by.htp.carparking.domain.Entity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Cars</title>
</head>
<body>
	<h2>View Cars</h2>
	<hr>
	<form name='carid' method='post'
		action='/carparking/pages/viewcar.jsp'>
		<%
			CarParkingEntityService service = new CarParkingEntityImpl();
			Entity entity = service.getEntity();
			for (Car car : entity.getCars()) {
				out.println("<p><input type='checkbox' value='" + car.getId() + "' name='car_id' />"
						+ "<a href=\"/carparking/pages/viewcar.jsp?car_id=" + car.getId() + "\"> " + car.getBrand() + " " + car.getModel()
						+ " </a></p>");
			}
		%>
		<p></p>
		<input type='hidden' name='car_id' value='1' /> <input type='submit'
			value='Delete marked' />
	</form>
</body>
</html>