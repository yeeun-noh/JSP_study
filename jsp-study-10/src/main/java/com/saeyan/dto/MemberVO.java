package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberVO {
	private int code;
	private String title;
	private int price;
	private String director;
	private String actor;
	private String poster;
	private String synopsis;
	
}
