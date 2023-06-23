package Jeju.Board.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Jeju.fruit.DataDAO;
import Jeju.fruit.JejuFruitVO;


public class JejuFruitMain {

	public static void main(String[] args) {

		JejuFruitMain jm = new JejuFruitMain();
		jm.JejuFrult(); 
	}

	public void JejuFrult() {
		DataDAO dao = new DataDAO();
		try {

			int k = 1;
			for(int i=1; i<=10; i++) {

				Document doc = Jsoup.connect("https://eloasis.co.kr/category/%EC%A0%84%EC%B2%B4%EC%83%81%ED%92%88/56/"+i).get();
				Elements poster = doc.select("ul li div.thumbnail a img");  
				Elements description = doc.select("li.name span");
				Elements Price = doc.select("li.priceWrap strong "); 

				for (int j = 0; j < poster.size(); j++) {
					try {
						System.out.println("번호 : " + k); 
						System.out.println("포스터: " + poster.get(j).attr("src"));
						System.out.println("설명: " + description.get(j).text());
						System.out.println("가격: " + Price.get(j).text());
						System.out.println("======================================================");

						JejuFruitVO vo = new JejuFruitVO();

						vo.setNo(k);
						vo.setPoster(poster.get(j).attr("src"));
						vo.setDescription(description.get(j).text());
						vo.setPrice(Price.get(j).text());


						//               String s=poster.get(j).attr("style");
						//               s=s.substring(s.indexOf("(")+1,s.lastIndexOf(")"));
						//               s="https://www.siksinhot.com"+s;
						//               vo.setPoster(s);
						dao.JejuFrultSelect(vo);
						k++;

					} catch (Exception e) {             
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}