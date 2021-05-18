package com.callor.guest.model;

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
public class GuestBookVO {
	private Long gb_seq;//	BIGINT
	private String gb_date;//	varchar(10)
	private String gb_time;//	varchar(10)
	private String gb_writer;//	varchar(30)
	private String gb_email;//	varchar(30)
	private String gb_password;//	varchar(125)
	private String gb_content;//	varchar(2000)

}
