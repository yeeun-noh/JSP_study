package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberVO {
	
	private String name;
	private String userid;
	private String pwd;
	private String email;
	private String phone;
	private int admin;
}
