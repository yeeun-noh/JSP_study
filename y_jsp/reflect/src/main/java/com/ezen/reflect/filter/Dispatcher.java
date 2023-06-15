package com.ezen.reflect.filter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.reflect.ano.RequestMapping;
import com.ezen.reflect.controller.UserController;

public class Dispatcher implements Filter{

   @Override
   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
         throws IOException, ServletException {
//      System.out.println("이쪽으로 오니?");
	   
	   HttpServletRequest request = (HttpServletRequest)req;
	   HttpServletResponse response = (HttpServletResponse)res;

	   //요청 확인:
//	   System.out.println("컨텍츠 패스: " + request.getContextPath());
//	   System.out.println("식별자 주소: " + request.getRequestURI());
//	   System.out.println("전체주소: " + request.getRequestURL());
	   
	   //user 파싱하기:
	   //endPoint구하는 법(/user) => getRequestURI()- getContextPath() == (/reflect/user) - (/reflect)
	   String endPoint = request.getRequestURI().replaceAll(request.getContextPath(), "");
	   System.out.println("endPoint: " + endPoint);
	   
	   UserController userController = new UserController();
	   
	   //객체 생성후 출력:
//	   if(endPoint.equals("/join")) {
//		   userController.join();
//	   } else if(endPoint.equals("/login")) {
//		   userController.login();
//	   }
	   
	   //메서드 몇개인지 확인가능:
	   Method[] methods = userController.getClass().getDeclaredMethods();
/*
	   System.out.println(methods);
	   
	   for(Method m : methods)
		   System.out.println(m);
		   
	   //이름만 출력:
	   for(Method m : methods)
		   System.out.println(m.getName());
		   
	   for(Method m : methods) {
		   if(endPoint.equals("/" + m.getName())) {
			   try {
				   m.invoke(userController);
			   } catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
	   }	   
 */	   
	   for(Method m : methods) {
		   Annotation annotation = m.getDeclaredAnnotation(RequestMapping.class);
		   RequestMapping mapping = (RequestMapping)annotation;
//		   System.out.println(mapping.value());
		   
		   if(mapping.value().equals(endPoint)) {
			   try {
				   String path = (String)m.invoke(userController);
				   
				   RequestDispatcher dis = request.getRequestDispatcher(path);
				   dis.forward(request, response);
			   } catch(Exception e) {
				   e.printStackTrace();
			   }
		   }
	   }
   }
   

}



















