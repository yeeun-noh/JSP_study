package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardListAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory: " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction(); //action은 객체만 생성(execute실행 아직 안됨, action.execute()를 해야만 실행가능)
		}
		
		return action;
	}
}
