package com.ezen.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ezen.dao.DataDAO;
import com.ezen.dao.SeoulHotelVO;

public class SeoulMain {
	
	public static void main(String[] args) {
		
		SeoulMain sm = new SeoulMain();
		sm.seoulHotel();
	}
	
	public void seoulHotel() {
		DataDAO dao = new DataDAO();
		
		try {
			int k = 1;
			for(int i=1; i<=48; i++) {
//				-사이트에 있는 소스(코드) 다 긁어어오기:
				Document doc = Jsoup.connect("https://korean.visitseoul.net/hotels?curPage="+i).get();
//				System.out.println(doc);
				
//				-사이트에서 특정 부분 가져오기 (썸네일 이미지):
				Elements poster = doc.select("ul.article-list li.item div.thumb img");
//				System.out.println(poster);
				
//				-사이트에서 특정 부분 가져오기 (썸네일 장소 세부설명 링크):
				Elements link = doc.select("ul.article-list li.item a");
//				System.out.println(link);
//				
//				-사이트에서 특정 부분 가져오기 (타이틀):
				Elements title = doc.select("ul.article-list li.item div.infor-element span.title");
//				System.out.println(title);
				
//				-사이트에서 특정 부분 가져오기 (리뷰+ 점수):
				Elements score = doc.select("ul.article-list li.item div.infor-element span.trip-text");
//				System.out.println(score);
				
				for(int j=0; j<poster.size(); j++) {
					try {
						System.out.println("번호: " + k);
						System.out.println("title: " + title.get(j).text());
						System.out.println("poster: " + poster.get(j).attr("src"));
						System.out.println("link: " + link.get(j).attr("href"));
						System.out.println("score: " + score.get(j).text());
						
//						-상세페이지로 이동하는 코드 가져오기:
						Document doc2 = Jsoup.connect("https://korean.visitseoul.net" + link.get(j).attr("href")).get();
//						System.out.println(doc2);
						
//						-사이트에서 특정 부분 가져오기 (호텔주소):
						Element address = doc2.select("div.addaress-element dl dd").get(0);
						System.out.println("address:" + address.text());
												
//						-사이트에서 특정 부분 가져오기 (호텔 내부 이미지 사진):
						Elements images = doc2.select("div.wide-slide div.item");
//						System.out.println(images);
						
						//
						String simg = null;
						for(int m=0;m<images.size(); m++) {
							String temp = images.get(m).attr("style");
//							System.out.println(temp);

							temp = temp.substring(temp.indexOf("(")+1, temp.lastIndexOf(")"));
							simg += temp + "^";
						}
						simg = simg.substring(0, simg.lastIndexOf("^"));
//						System.out.println(simg);
						
						System.out.println("-------------------------------");
						
						SeoulHotelVO vo = new SeoulHotelVO();
						
						vo.setNo(k);
						vo.setName(title.get(j).text());
						vo.setAddress(address.text());
						vo.setPoster(poster.get(j).attr("src"));
						
//						vo.setScore(score.get(j).text());
						int num = Integer.parseInt(score.get(j).text().substring(0, score.get(j).text().indexOf(" ")));
						vo.setScore(num);
						vo.setImages(simg);
						
						dao.seoulHotelInsert(vo);
						k++;
//						System.out.println(vo);
//						System.out.println(score.get(j).text().substring(0, score.get(j).text().indexOf(" ")));
						
					} catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
