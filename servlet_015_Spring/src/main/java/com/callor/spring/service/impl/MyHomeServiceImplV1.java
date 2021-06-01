package com.callor.spring.service.impl;

import org.springframework.stereotype.Service;

import com.callor.spring.model.MyVO;
import com.callor.spring.service.MyHomeService;

@Service
public class MyHomeServiceImplV1 implements MyHomeService{

	@Override
	public MyVO findById() {
		// TODO Auto-generated method stub
		
		MyVO vo = new MyVO();
		
		vo.setT_name("홍길동");
		vo.setT_tel("010-1234-1234");
		vo.setT_age("26");
		return null;
	}

}
