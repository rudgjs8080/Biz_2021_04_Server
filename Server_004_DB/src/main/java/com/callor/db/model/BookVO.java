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
	
	
	
}
