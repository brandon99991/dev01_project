package com.example.restfulwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import java.util.Locale;

//외장 톰캣으로 구동하기 위한 import 추가
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.boot.builder.SpringApplicationBuilder;

//외장 톰캣으로 구동하기 위해서는 SpringBootServletInitializer 를 상속받는다.
@SpringBootApplication
public class RestfulWebServiceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServiceApplication.class, args);
	}
	
    @Bean  // 다국어 처리를 위한 Bean 추가
    public LocaleResolver localeResolver() {
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.KOREA);
        return localeResolver;
    }	
    
	//외장 톰캣으로 구동하기 위해서 추가되는 코드
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RestfulWebServiceApplication.class);
	}	
   
	
}
