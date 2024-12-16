package com.example.demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/paymentprovider")
public class ClientController {

	@GetMapping("/paynow/{price}")
	public String payNow(@PathVariable int price) {
		return "payment with price "+price+" is successfully done";
	}
	
	
	
}


