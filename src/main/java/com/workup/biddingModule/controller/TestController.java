package com.workup.biddingModule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class TestController {
    @GetMapping("/")
	public String index() {
        System.out.println("Hello");
		return "home";
	}
}
