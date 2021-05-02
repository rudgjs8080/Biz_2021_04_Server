package com.callor.book.model;

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
public class BookVO {
	
	// table의 칼럼이름과 같은 방식으로 사용하기
	private String bk_isbn;
	private String bk_title;
	private String bk_ccode;
	private String bk_acode;
	private String bk_date;
	private Integer bk_price = 0;
	private Integer bk_pages = 0;
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
	public Integer getBk_price() {
		return bk_price;
	}
	public void setBk_price(Integer bk_price) {
		this.bk_price = bk_price;
	}
	public Integer getBk_pages() {
		return bk_pages;
	}
	public void setBk_pages(Integer bk_pages) {
		this.bk_pages = bk_pages;
	}

	
	
}