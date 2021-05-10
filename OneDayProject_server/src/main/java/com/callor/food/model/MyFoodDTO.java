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
public class MyFoodDTO {

	private String mf_date;
	private String mf_fname;
	private Integer mf_value;
	private Integer mf_one;
	private Integer mf_total;
	private Integer mf_energy;
	private Integer mf_protein;
	private Integer mf_fat;
	private Integer mf_carbon;
	private Integer mf_sugar;
	
	
	
}
