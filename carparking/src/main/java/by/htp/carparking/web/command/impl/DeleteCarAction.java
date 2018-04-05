package by.htp.carparking.web.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.service.CarParkingEntityService;
import by.htp.carparking.service.impl.CarParkingEntityImpl;
import by.htp.carparking.web.command.BasicAction;

public class DeleteCarAction implements BasicAction{
	
	private CarParkingEntityService service = new CarParkingEntityImpl();

	@Override
	public String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		//String bookId = request.getParameter("book_id");
		String[] arrId = request.getParameterValues("id");
		out.println("<html><head></head><body>"
				+ "<h1><a href='index.jsp'>Back to menu</a></h1><br>"
				+ "</body></html>");
		for (String strId: arrId) {
			service.deleteCar(Integer.parseInt(strId));
			out.println("the car " + strId + " is deleted");
		}
		return null;
	}
	
}
