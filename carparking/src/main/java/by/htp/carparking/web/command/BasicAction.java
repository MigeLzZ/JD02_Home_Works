package by.htp.carparking.web.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BasicAction {
	
	String executeAction(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
