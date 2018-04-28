package by.htp.carparking.web.action.impl;

import static by.htp.carparking.web.util.WebConstantDeclaration.*;

import java.sql.Date;

import static by.htp.carparking.web.util.HttpRequestParamValidator.*;
import static by.htp.carparking.web.util.HttpRequestParamFormatter.*;

import javax.servlet.http.HttpServletRequest;

import by.htp.carparking.dao.DAO;
import by.htp.carparking.domain.Car;
import by.htp.carparking.service.OrderService;
import by.htp.carparking.web.action.BaseAction;

public class OrderCarAction implements BaseAction{

	// TODO to IoC
//	private OrderService orderService = ServiceFactory.getOrderService();
	String orderedCarMessage = "Car was ordered successfully!";
	private OrderService orderService;
	
	
	public OrderCarAction() {

	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}


	@Override
	public String executeAction(HttpServletRequest request) {
		
		String carId = request.getParameter(REQUEST_PARAM_CAR_ID);
		String userId = request.getParameter(REQUEST_PARAM_USER_ID);
		String dateStart = request.getParameter(REQUEST_PARAM_START_DATE);
		String dateEnd = request.getParameter(REQUEST_PARAM_END_DATE);
		
		validateRequestParamNotNull(carId, userId);
//		orderService.orderCar(formatString(userId), formatString(carId));
		
		Car orderCar = DAO.getDAO().carDAO.read(formatString(carId));
		if (orderCar != null) {
			request.setAttribute(REQUEST_PARAM_ORDERED_CAR, orderCar);
			if (dateStart != null && dateEnd != null) {
				orderService.orderCar(formatString(userId), formatString(carId),
						Date.valueOf(request.getParameter("start")), Date.valueOf(request.getParameter("end")));
				request.setAttribute(REQUEST_PARAM_MSG_ORDER_CAR_SUCCESS, orderedCarMessage);
			}
		}
		return PAGE_USER_CAR_ORDER;
	}

}
