package com.callor.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	
	private String bk_isbn;	//isbn	char(13)
	private String bk_title;	//도서명	nvarchar2(125)
	private String bk_cname;	//출판사명	nvarchar2(125)
	private String bk_cceo;		//출판사대표	nvarchar2(20)
	private String bk_auname;	//저자명	nvarchar2(50)
	private String bk_autel;	//저자연락처	varchar2(20)
	private String bk_date;		//출판일	char(10)
	private Integer bk_price;	//가격	number
	private Integer bk_pages;	//페이지	number
	
}
