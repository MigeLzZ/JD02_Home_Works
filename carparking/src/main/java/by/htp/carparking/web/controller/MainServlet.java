package by.htp.carparking.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.carparking.service.CarParkingEntityService;
import by.htp.carparking.service.impl.CarParkingEntityImpl;
import by.htp.carparking.web.command.ActionType;
import by.htp.carparking.web.command.BasicAction;
import by.htp.carparking.web.command.CommandChooser;

public class MainServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int requestCount = 0;
	
	private CarParkingEntityService service;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("service method: " + requestCount);
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy method: " + requestCount);
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init method: " + requestCount);
		service = new CarParkingEntityImpl();
	}
	
    public MainServlet() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		requestCount++;
		
		String command = request.getParameter("command");
		System.out.println(command);
		
		ActionType action = ActionType.valueOf(command.toUpperCase());
		BasicAction basicAction = CommandChooser.performAction(action);  // Мы определяем объект какого класса реализует данный интерфейс.
		basicAction.executeAction(request, response);	
	}


//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
