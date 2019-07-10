package com.example.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String show() {
		return "Home";
	}
	
	@GetMapping("/getData")
	public @ResponseBody String getName(@RequestParam("empName")String name) {
		System.out.println(name);
		return "Hello Mr/Mrs:"+name;
	}
}
