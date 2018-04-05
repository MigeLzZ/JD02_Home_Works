package by.htp.carparking.web.command;

import by.htp.carparking.web.command.impl.AddCar;
import by.htp.carparking.web.command.impl.AddCarAction;
import by.htp.carparking.web.command.impl.DeleteCar;
import by.htp.carparking.web.command.impl.DeleteCarAction;
import by.htp.carparking.web.command.impl.UpdateCar;
import by.htp.carparking.web.command.impl.UpdateCarAction;
import by.htp.carparking.web.command.impl.UpdateCarActionOnAction;
import by.htp.carparking.web.command.impl.ViewCar;
import by.htp.carparking.web.command.impl.ViewCarAction;
import by.htp.carparking.web.command.impl.ViewCarList;

public class CommandChooser {

public static BasicAction performAction(ActionType action) {
		
		BasicAction basicAction = null;
		
		switch(action){
		case ADD_CAR:
			basicAction = new AddCar();
			break;
		case ADD_CAR_ACTION:
			basicAction = new AddCarAction();
			break;
		case VIEW_CAR:
			basicAction = new ViewCar();
			break;
		case VIEW_CAR_ACTION:
			basicAction = new ViewCarAction();
			break;
		case VIEW_CAR_LIST:
			basicAction = new ViewCarList();
			break;
		case DELETE_CAR:
			basicAction = new DeleteCar();
			break;
		case DELETE_CAR_ACTION:
			basicAction = new DeleteCarAction();
			break;
		case UPDATE_CAR:
			basicAction = new UpdateCar();
			break;
		case UPDATE_CAR_ACTION:
			basicAction = new UpdateCarAction();
			break;
		case UPDATE_CAR_ACTION_ON_ACTION:
			basicAction = new UpdateCarActionOnAction();
			break;
		}
		return basicAction;
	}
	
}

