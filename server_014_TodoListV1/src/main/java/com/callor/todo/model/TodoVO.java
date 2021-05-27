package com.callor.todo.model;

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

public class TodoVO {

	private String td_seq;	
	private String td_sdate;	
	private String td_stime;	
	private String td_doit;	
	private String td_edate;	
	private String td_etime;
}
