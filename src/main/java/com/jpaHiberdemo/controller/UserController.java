package com.jpaHiberdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpaHiberdemo.bean.UserDetails;
import com.jpaHiberdemo.services.UserServices;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/userform")
public class UserController {
	
	@Autowired
	UserServices userservices;
	
	
	
	@RequestMapping(value= {"/tteesst"} , method = RequestMethod.POST)
    public String method1(@RequestBody UserDetails udetails){
		String st = userservices.insertEntity(udetails);
        return st;
    }
	
//	@RequestMapping(value= {"/tteesst"})
//    public String method1() {
//		userservices.insertEntity();
//        return "OK";
//    }
	
	@GetMapping("/list")
    public List<UserDetails> getlistdata() {
	    return userservices.getuserlist();
    }
	
	@GetMapping("/list/{id}")
    public Optional<UserDetails> getdatabyid(@PathVariable Integer id) {
	    return userservices.getindividualuserlist(id);
    }
	
	@RequestMapping("/deleteuser/{id}")
	public String deleteuser(@PathVariable Integer id) {
		if(userservices.deleteuser(id)) {
			return "Deleted";
		}else {
			return "Error";
		}
	}
	
}
