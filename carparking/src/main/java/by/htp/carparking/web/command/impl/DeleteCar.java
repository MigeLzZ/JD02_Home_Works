package by.htp.carparking.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.domain.Car;
import by.htp.carparking.domain.Entity;
import by.htp.carparking.service.CarParkingEntityService;
import by.htp.carparking.service.impl.CarParkingEntityImpl;
import by.htp.carparking.web.command.BasicAction;

public class DeleteCar implements BasicAction{
	
	private CarParkingEntityService service = new CarParkingEntityImpl();

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Entity entity = service.getEntity();
		out.println("<html><head><meta charset='utf-8'> <title>View Car</title> </head><body>"
			    + "<form method='get' action='/carparking/MainServlet' >");
			  
		out.println("<input type=\"hidden\" name=\"command\" value=\"delete_car_action\" />");
		for(Car car : entity.getCars()) {
			out.println("<input type='checkbox' value='" + car.getId() + "' name='id' />"
					+ "<a href='MainServlet?command=view_car_action&id=" + car.getId() + "'>" + car.getBrand() + " " + car.getModel() + "</a><br>");					
		}
		out.println("<input type='submit' formmethod='get'  value='Delete' />");
		out.println("</form></body></html>");
		return null;
	}

}
