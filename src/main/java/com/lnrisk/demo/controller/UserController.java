package com.lnrisk.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lnrisk.demo.beans.Address;
import com.lnrisk.demo.beans.User;

@Controller
@RequestMapping("/user")
public class UserController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value="/welcome", method=RequestMethod.GET, produces="application/json", consumes="application/json")
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping(value="/getUser", method=RequestMethod.GET, produces="application/json", consumes="application/json")
    public @ResponseBody User getUserDetails(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	User newUser = new User();
    	newUser.setId(counter.incrementAndGet());
    	newUser.setUserName(name);
    	
    	Address userAddress = new Address();
    	userAddress.setId(counter.incrementAndGet());
    	userAddress.setStreetName("St 1");
    	userAddress.setCity("Nashville");
    	userAddress.setState("Tennessee");
    	userAddress.setCountry("US");
    	newUser.setUserAddress(userAddress);
    	
        return newUser;
    }
    
    @RequestMapping(value="/saveUser", method=RequestMethod.POST, produces="application/json", consumes="application/json")
    public @ResponseBody Boolean saveUser(@RequestBody User user) {
        boolean isSaved = Boolean.FALSE;
        
        if(user != null){
        	System.out.println("UserID: " + user.getId());
        	System.out.println("UserID: " + user.getUserName());
        	if(user.getUserAddress() != null){
        		System.out.println("User Address ID: " + user.getUserAddress().getId());
        		System.out.println("User Address Street: " + user.getUserAddress().getStreetName());
        		System.out.println("User Address City: " + user.getUserAddress().getCity());
        		System.out.println("User Address State: " + user.getUserAddress().getState());
        		System.out.println("User Address Country: " + user.getUserAddress().getCountry());
        	}
        	isSaved = Boolean.TRUE;
        }
        
    	return isSaved;
    }
    
    @RequestMapping(value="/deleteUser/{userId}", method=RequestMethod.DELETE, produces="application/json", consumes="application/json")
    public @ResponseBody Boolean deleteUser(@PathVariable(value="userId", required=false) long userId) {
    	boolean isSaved = Boolean.FALSE;
    	if(userId > 0){
    		System.out.println("User is deleted");
    		isSaved = Boolean.TRUE;
    	}
    	return isSaved;
    }
    
    @RequestMapping(value="/getUserAddress", method=RequestMethod.GET, produces="application/json", consumes="application/json")
    public @ResponseBody Address getUserAddress(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
    	Address userAddress = new Address();
    	userAddress.setId(counter.incrementAndGet());
    	userAddress.setStreetName("St 1");
    	userAddress.setCity("Nashville");
    	userAddress.setState("Tennessee");
    	userAddress.setCountry("US");
    	return userAddress;
    }
}
