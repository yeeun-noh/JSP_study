package com.ezen.dao;

import org.jsoup.nodes.Element;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SeoulHotelVO {
	
	private int no;
	private String name, address, poster, images;
	private int score;
}
