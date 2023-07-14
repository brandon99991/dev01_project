package com.example.restfulwebservice.helloworld;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data                // lombok 이용하여 GET, SET 생성
@AllArgsConstructor  //모든 필드 값을 파라미터로 받는 생성자를 만듦 // @NoArgsConstructor 파라미터가 없는 기본 생성자를 생성
public class HelloWorldBean {
	private String message;

	
}
