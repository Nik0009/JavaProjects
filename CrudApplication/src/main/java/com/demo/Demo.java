package com.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController 
public class Demo {

	@GetMapping("/testing ")
	public String job() {
		return "<body bgcolour= 'red' text='yellow'><h1>I am Nik <h1></body>";
	}
}
