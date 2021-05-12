package com.callor.diet.model;

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
public class FoodVO {
	
	private String fd_code; 	//
	private String fd_name; 	//
	private Integer fd_year; 	//
	private String fd_ccode; 	//
	private String fd_icode; 	//
	private Float fd_once; 	//
	private Float fd_capa; 	//
	private Float fd_cal; 	//
	private Float fd_protein; //
	private Float fd_fat; 	//
	private Float fd_carbo; 	//
	private Float fd_sugar; 	//
}
