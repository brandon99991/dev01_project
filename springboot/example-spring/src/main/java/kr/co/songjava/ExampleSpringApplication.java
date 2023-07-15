package kr.co.songjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 외장 톰캣으로 구동하기 위한 import 추가
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

//외장 톰캣으로 구동하기 위해서는 SpringBootServletInitializer 를 상속받는다.
@SpringBootApplication
public class ExampleSpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringApplication.class, args);
	}

	//외장 톰캣으로 구동하기 위해서 추가되는 코드
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ExampleSpringApplication.class);
	}	
	
}
