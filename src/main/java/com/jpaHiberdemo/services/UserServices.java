package com.jpaHiberdemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaHiberdemo.bean.UserDetails;
import com.jpaHiberdemo.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	UserRepository userrepository;
	
//	public String insertEntity() {
//        String result = "true";
//		UserDetails userdetails = new UserDetails("Bhatia", "yashh@javaguides.com");
//		try {
//			userrepository.save(userdetails);
//		} catch (Exception e) {
//			return e.toString();
//			// TODO: handle exception
//		}
//		return result;
//    }
	
	public String insertEntity(UserDetails udetails) {
  String result = "true";
  UserDetails userdetails = new UserDetails(udetails.getFirstName(),udetails.getLastName(),udetails.getEmail());
	try {
		userrepository.save(userdetails);
	} catch (Exception e) {
		return e.getLocalizedMessage();
		// TODO: handle exception
	}
	return result;
}
	
//	public void insertEntity() {
//        
//		UserDetails userdetails = new UserDetails("Harsh", "Kaushik");
//		System.out.println(userrepository.save(userdetails));	
//		
//    }
	
	public List<UserDetails> getuserlist() {
		System.out.println("in");	
			
	        return (List<UserDetails>) userrepository.findAll();
	}

	public Optional<UserDetails> getindividualuserlist(Integer id) {
		// TODO Auto-generated method stub
		return userrepository.findById(id);
	}
	
	public boolean deleteuser(Integer id) {
		Boolean result;
		try {
			result = true;
			userrepository.deleteById(id);
		} catch (IllegalArgumentException e) {
			System.out.println("Error: "+e);
			result = false;
			// TODO: handle exception
		}
		return result;		
	}
	
}
