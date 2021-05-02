package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * VO 클래스와 DTO클래스
 * 일반적인 개념은 거의 같다
 * 
 * DB와 연동을 할때는 약간의 차이가 있다
 * 		VO : CRUD모두에서 사용하는 데이터
 * 		DTO : 읽기전용 데이터를 담은 용도
 * 
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

	private String bk_isbn;
	private String bk_title;
	private String bk_cname;
	private String bk_cceo;
	
	private String bk_author;
	private String bk_au_tel;
	
	private Integer bk_price;
	private Integer bk_pages;
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
	public String getBk_cname() {
		return bk_cname;
	}
	public void setBk_cname(String bk_cname) {
		this.bk_cname = bk_cname;
	}
	public String getBk_cceo() {
		return bk_cceo;
	}
	public void setBk_cceo(String bk_cceo) {
		this.bk_cceo = bk_cceo;
	}
	public String getBk_author() {
		return bk_author;
	}
	public void setBk_author(String bk_author) {
		this.bk_author = bk_author;
	}
	public String getBk_au_tel() {
		return bk_au_tel;
	}
	public void setBk_au_tel(String bk_au_tel) {
		this.bk_au_tel = bk_au_tel;
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