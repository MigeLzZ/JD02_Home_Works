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

public class ViewCarList implements BasicAction{
	
	private CarParkingEntityService service = new CarParkingEntityImpl();

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		Entity entity = service.getEntity();
		out.println("<html><head></head><body>");
		for (Car car: entity.getCars()) {
			out.println("<a href='MainServlet?command=view_car_action&car_id=" + car.getId() + "'>" + car.getBrand() + " " + car.getModel()
					+ "</a><br>");
		}
		out.println("</body></html>");
		return null;
	}

}
