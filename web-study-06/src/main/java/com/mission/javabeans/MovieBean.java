package com.mission.javabeans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MovieBean {
	private String title;
	private int price;
	private String director;
	private String actor;
	private String synopsis;
	private String genre;
}
