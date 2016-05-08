/**
 * @author Pavlenko R.A.
 * this is Controller class for mapping all requests which is linked
 * with our first Task
 */
package com.rosteach.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rosteach.models.CountOfPaths;

@Controller
public class FirstTaskController {
	private static final Logger logger = LoggerFactory.getLogger(FirstTaskController.class);
	
	//controller which rendering to our first task page
	@RequestMapping(value = "/firstTask", method = RequestMethod.GET)
	public String firstTaskPage() {
		Date date = new Date();
		logger.info("FirstTask page downloaded with success!  Server date & time is: {}.",date.getTime());
		return "firstTask";
	}
	
	//controller which use ajax input test cases value, validate it and send needed value of input parameters 
	//or error of validation
	@RequestMapping(value = "/testCases", method = RequestMethod.POST, produces = { "text/html; charset=UTF-8" })
	public @ResponseBody String tesCases(@RequestParam String name) {
		try {
			int temp = Integer.parseInt(name);
			if(temp>30||temp==0){
				name = "Input must be between 0 and 30";
			}
			return "Number of test cases:"+name;
        } catch (Exception e) {
        	logger.info("Error", e.getMessage());
            return "Input must be numeric value!";
        }
	}
	//controller which use ajax input test cases value, validate it and send needed value of input parameters 
	//or error of validation
	@RequestMapping(value = "/parameters", method = RequestMethod.POST, produces = { "text/html; charset=UTF-8" })
	public @ResponseBody String parameters(@RequestParam String name) {
		int m=0,n=0;
		String tempName = "";
		
		CountOfPaths count = new CountOfPaths();
		try{
			for(int i = 0; i<name.length();i++){ 
				char temp = name.charAt(i);
				if(temp==(';')){
					// get our matrix parameter
					m = Integer.parseInt(name.charAt(i-3)+"");
					n = Integer.parseInt(name.charAt(i-1)+"");
					// get output of path like 6;8;20 
					tempName +=count.countOfPath(m,n)+"; ";
				}
			}
			name=tempName;
			return name;
		}
		catch(Exception ex){
			logger.info("Error", ex.getMessage());
			name = "incorrect input n & m must be >0 and <10";
			return name;
		}
	}	
}
