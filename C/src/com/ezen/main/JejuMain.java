package com.ezen.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.ezen.dao.DataDAO;
import com.ezen.dao.JejuFoodVO;

public class JejuMain {

	public static void main(String[] args) {
		JejuMain jm = new JejuMain();
		jm.JejuFood(); 
	}

	public void  JejuFood() {

		DataDAO dao = new DataDAO();
		try {

			int k = 1;
			for(int i=1; i<=10; i++) {
				Document doc = Jsoup.connect("https://www.siksinhot.com/taste?upHpAreaId=15&hpAreaId=&isBestOrd=Y"+i).get();
				Elements poster = doc.select("li div.cont a span.img img");
				Elements title = doc.select("li div.cnt div.box_tit strong");
				Elements location = doc.select("li div.cnt ul li");


				for (int j = 0; j < poster.size(); j++) {
					try {
						System.out.println("번호 : " + k); 
						System.out.println("제목: " + title.get(j).text());
						System.out.println("포스터: " + poster.get(j).attr("src"));
						System.out.println("위치: " + location.get(j).text());
						System.out.println("======================================================");

						JejuFoodVO vo = new JejuFoodVO();


						vo.setNo(k);
						vo.setTitle(title.get(j).text());
						vo.setPoster(poster.get(j).attr("src"));
						vo.setLocation(location.get(j).text());


						//               String s=poster.get(j).attr("style");
						//               s=s.substring(s.indexOf("(")+1,s.lastIndexOf(")"));
						//               s="https://www.siksinhot.com"+s;
						//               vo.setPoster(s);

						dao.JejuFoodInsert(vo);
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