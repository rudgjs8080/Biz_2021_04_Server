package com.callor.todo.service;

import java.util.List;
import java.util.Map;

/*
 * 이번 프로젝트는 1개의 table만으로 구성된
 * 간단한 프로젝트 이므로
 * 별도로 vo, dto를 만들지 않고
 * Map<>을 사용하여 구성한다.
 * 
 * Map은 key, value 형식의 데이터를 저장하는 자료구조
 * put(key, value) method를 사용하여 데이터항목(칼럼)을
 * 		추가하고
 * get(key) method를 사용하여 데이터 항목을 읽기
 * 
 * Map<String, Class> maps 형식으로 type을 정의하고
 * maps.put<"이름", 객체> 형식으로 데이터를 추가하기
 * 
 * Class class = map.get("이름")형식으로 값을 읽어서 다른 변수에 담을 수 있다
 * System.out.println(map.get("이름")) 형식으로
 * 		Console에 출력하기
 * 
 * VO(DTO)를 선언하지 않고 임시로 VO type의 데이터를 사용하는 방법
 * 
 * Map을 사용할 때 key 값을 String 형으로 지정하면
 * 값을 put(), get() 할 때 key 값을 "" 로 감싼 문자열
 * 형식으로 사용해야 하기 때문에 많은 오타로 인한 논리적 오류가 발생할 수 있다
 * 이러한 문제를 방지하기 위해 key 값을 별도 static 변수로 만들어두고
 * 활용하는 방법을 사용한다
 * 
 */

public interface TodoService {
	
	// Map의 value를 어떤 형태의 데이터라도
	// 저장할 수 있도록 하겠다
	
	// Map의 선언방식
	// Map<String , String> strmap
	// strmap.put("이름", "홍길동")
	// -- 데이터는 문자열 type만 저장가능
	
	// Map<String, integer> intMap
	// intMap.put("이름", 100)
	// -- 데이터는 정수형 type만 저장가능
	
	// Map<String, Object> objMap
	// objMap.put("이름", "홍길동");
	// objMap.put("나이",33);
	
	
	public List<Map<String, Object>> selectAll();
	
	public Map<String, Object> findById(Long td_seq);
	
	public List<Map<String, Object>> findBySdate();
	public List<Map<String, Object>> findByDoit();
	
	public Integer insert(Map<String, Object> tdVO);
	public Integer update(Map<String, Object> tdVO);
	public Integer delete(Long td_seq);
	
	
}
