package Jeju.Board.controller;

import Jeju.Board.controller.action.Action;



public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {
	}
	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		if (command.equals("Jeju_Main")) {
			action = new JejuMainAction();
		}else if (command.equals("Jeju_Login")) {
			action = new JejuLoginAction();
		}else if (command.equals("Jeju_Join")) {
			action = new JejuJoinAction();	
		}else if(command.equals("Jeju_Join_Form")) {
	         action = new JejuJoinFormAction();
		}
		return action;
	}		
}
