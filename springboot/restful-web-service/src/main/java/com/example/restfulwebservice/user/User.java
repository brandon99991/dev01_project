package com.example.restfulwebservice.user;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value={"password", "ssn"})  // password, ssn을 응답에서 제외
@JsonFilter("UserInfo")
public class User {
	private Integer id;
	//private String nameString;
	//private Date joinDate;
	
    @Size(min=2, message = "Name은 2글자 이상 입력해 주세요.")
    private String name;
    
    @Past
    private Date joinDate;	
    
    //@ApiModelProperty(notes = "사용자의 패스워드를 입력해 주세요.")
    //@JsonIgnore  //응답에서 제외
    private String password;
    
    //@ApiModelProperty(notes = "사용자의 주민번호를 입력해 주세요.")
    //@JsonIgnore  //응답에서 제외  
    private String ssn;    

}
