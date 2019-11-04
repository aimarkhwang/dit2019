package com.naver.api;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.naver.vo.DaumVO;
// https://img1.daumcdn.net/thumb/C236x340/?fname=http://t1.daumcdn.net/movie/cc7165f75bb94140a95d977881cebc191571895256827
public class MyApi {
	public static ArrayList<DaumVO> daum() {
		ArrayList<DaumVO> list = new ArrayList<DaumVO>();
		try {
			// 1. URL 선언
			String connUrl = "https://movie.daum.net/boxoffice/weekly";
			// 2. HTML 가져오기
			Document doc = Jsoup.connect(connUrl).get();
			Elements els = doc.select(".info_movie img");
			
//			System.out.println(els);
			for (Element e : els ) {
				DaumVO vo = new DaumVO();
				vo.setTitle(e.attr("alt"));
				vo.setImg("https:" + e.attr("src"));
//				System.out.println(e.attr("alt"));
//				System.out.println(e.attr("src"));
				list.add(vo);
			}
			// 3. 가져온 HTML Document 를 확인하기
			//System.out.println(doc.toString());
		} catch (IOException e) {
			// Exp : Connection Fail
			e.printStackTrace();
		}
		return list;

	}

}
