package com.callor.db.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// 모든 변수를 매개변수로 갖는 생성자
@AllArgsConstructor
// 기본 생성자
@NoArgsConstructor
public class BookVO {
	// DB와 연동하는 프로젝트에서는 
	// 코딩의 혼란을 줄이기 위해서
	// snake case로 VO 변수를 선언한다
	String bk_isbn;
	String bk_title;
	String bk_ccode;
	String bk_acode;
	String bk_date;
	
	// 정수형 변수를 선언할 때 Integer로 선언하면
	
	Integer bk_pages = 0;
	Integer bk_price = 0;
	public String getBk_isbn() {
		return bk_isbn;
	}
	public void setBk_isbn(String bk_isbn) {
		this.bk_isbn = bk_isbn;
	}
	public String getBk_title() {
		return bk_title;
	}
	public void setBk_title(String bk_title) {
		this.bk_title = bk_title;
	}
	public String getBk_ccode() {
		return bk_ccode;
	}
	public void setBk_ccode(String bk_ccode) {
		this.bk_ccode = bk_ccode;
	}
	public String getBk_acode() {
		return bk_acode;
	}
	public void setBk_acode(String bk_acode) {
		this.bk_acode = bk_acode;
	}
	public String getBk_date() {
		return bk_date;
	}
	public void setBk_date(String bk_date) {
		this.bk_date = bk_date;
	}
	public Integer getBk_pages() {
		return bk_pages;
	}
	public void setBk_pages(Integer bk_pages) {
		this.bk_pages = bk_pages;
	}
	public Integer getBk_price() {
		return bk_price;
	}
	public void setBk_price(Integer bk_price) {
		this.bk_price = bk_price;
	}
	
	
	
}
