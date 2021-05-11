package com.callor.food.model;

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

public class FoodDTO {
	
	private String f_code;	// as 식품코드,
	private String f_name;	// as 식품명,
	private String f_year;	// as 출시연도,
	private String c_name;	// as 제조사명,
	private String i_name;	// as 분류명,
	private Integer f_one;	// as 제공량,
	private Integer f_total;	// as 총내용량,
	private Integer f_energy;	// as 에너지,
	private Integer f_protein;	// as 단백질,
	private Integer f_fat;	// as 지방,
	private Integer f_carbon;	// as 탄수화물,
	private Integer f_sugar;	// as 총당류
	
	
}
