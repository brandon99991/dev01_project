package com.example.restfulwebservice.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
@RequestMapping("/admin")
public class AdminUserController {
	private UserDaoService service;
	
	public AdminUserController(UserDaoService service) {
		this.service = service;
	}
	
    @GetMapping("/users")
    public MappingJacksonValue retrieveAllUsers() {
        List<User> users = service.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "password");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(users);
        mapping.setFilters(filters);

        return mapping;
    }	
	
	//@GetMapping("/admin/users/{id}")
	@GetMapping("/users/{id}")
    public MappingJacksonValue retrieveUser(@PathVariable int id) {
        //List<User> users = service.findAll();
        User user = service.findOne(id);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "joinDate", "password");

        // UserInfo는 User클래스에 정의되어 있음.
        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }
    

    // GET /admin/users/1 -> /admin/v1/users/1
    //@GetMapping("/v1/users/{id}")   //http://localhost:8088/admin/v1/users/1
    //@GetMapping(value = "/users/{id}/", params = "version=1")  // http://localhost:8088/admin/users/1/?version=1
    //@GetMapping(value = "/users/{id}", headers="X-API-VERSION=1") // 요청 HEADER에 셋팅
    @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv1+json")  // 요청 HEADER에 셋팅
    public MappingJacksonValue retrieveUserV1(@PathVariable int id) throws UserNotFoundException {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id", "name", "password", "ssn");

        FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfo", filter);

        MappingJacksonValue mapping = new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }    
    
  //@GetMapping("/v2/users/{id}")   //http://localhost:8088/admin/v2/users/1
  //@GetMapping(value = "/users/{id}/", params = "version=2")  // http://localhost:8088/admin/users/1/?version=2
  //@GetMapping(value = "/users/{id}", headers="X-API-VERSION=2") // 요청 HEADER에 셋팅
  @GetMapping(value = "/users/{id}", produces = "application/vnd.company.appv2+json") // 요청 HEADER에 셋팅
  public MappingJacksonValue retrieveUserV2(@PathVariable int id) throws UserNotFoundException {
      User user = service.findOne(id);

      if (user == null) {
          throw new UserNotFoundException(String.format("ID[%s] not found", id));
      }

      // User -> UserV2
      UserV2 userV2 = new UserV2();
      // BeanUtils를 이용하면, user객체의 필드를 userV2에 copy할 수 있음.
      BeanUtils.copyProperties(user, userV2); // id, name, joinDate, password, ssn
      userV2.setGrade("VIP");

      SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
              .filterOutAllExcept("id", "name", "joinDate", "grade");

      FilterProvider filters = new SimpleFilterProvider().addFilter("UserInfoV2", filter);

      MappingJacksonValue mapping = new MappingJacksonValue(userV2);
      mapping.setFilters(filters);

      return mapping;
  }    
    
}
