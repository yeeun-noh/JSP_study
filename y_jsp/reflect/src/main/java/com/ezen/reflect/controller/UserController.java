package com.ezen.reflect.controller;

import com.ezen.reflect.ano.RequestMapping;

public class UserController {
	
	@RequestMapping("/user/join2")
	public String join() {
		System.out.println("join()�Լ� ȣ��");
		return "/join.jsp";
	}
	
	@RequestMapping("/user/login2")
	public String login() {
		System.out.println("login()�Լ� ȣ��");
		return "/";
	}
	
	@RequestMapping("/user/user2")
	public String user() {
		System.out.println("user()�Լ� ȣ��");
		return "/";
	}
	
	@RequestMapping("/user/hello2")
	public String hello() {
		System.out.println("hello()�Լ� ȣ��");
		return "/";
	}
	
}