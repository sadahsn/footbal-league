package com.sapient.football.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller class for Home page
 * @author sadashiv.m
 *
 */
@Controller
@Slf4j
public class HomeController {

	@RequestMapping("/home")
	public String home() {
		return "index";
	}
}
