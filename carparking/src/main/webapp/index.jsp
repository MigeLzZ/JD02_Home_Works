<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Parking</title>
<style>
	body {
	background-image: url(images/2.jpg);
	color: white;
	background-size: 100%;
	font-size: 20pt;
	}
</style>
</head>
	<body link="white" vlink="white" alink="white">
		<ol>
			<li><a href="/carparking/MainServlet?command=view_car_list">View catalog</a></li>
			<li><a href="/carparking/MainServlet?command=view_car">View car</a></li>
			<li><a href="/carparking/MainServlet?command=add_car">Add car</a></li>
			<li><a href="/carparking/MainServlet?command=delete_car">Delete car</a></li>
			<li><a href="/carparking/pages/viewallcars.jsp">View catalog</a></li>
			<li><a href="/carparking/MainServlet?command=update_car">Update car</a></li>
		</ol>
	</body>
</html>