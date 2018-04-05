package by.htp.carparking.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.domain.Car;
import by.htp.carparking.service.CarParkingEntityService;
import by.htp.carparking.service.impl.CarParkingEntityImpl;
import by.htp.carparking.web.command.BasicAction;

public class ViewCarAction implements BasicAction{
	
	private CarParkingEntityService service = new CarParkingEntityImpl();

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		String carId = request.getParameter("car_id");
		Car car = service.getCar(Integer.parseInt(carId));
		out.print("<html><head></head><body>"
				+ "<h1><a href='index.jsp'>Back to menu</a></h1>"
				+ "</body></html>");
		out.println(car);
		return null;
	}

}
