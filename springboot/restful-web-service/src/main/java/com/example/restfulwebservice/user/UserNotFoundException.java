package com.example.restfulwebservice.user;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

//HTTP Status code
//2XX -> OK
//4XX -> Client
//5XX -> Server
@ResponseStatus(HttpStatus.NOT_FOUND)  // 조회 사용자가 없을 경우, 404로 응답
public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
		super(message);
	}
}
