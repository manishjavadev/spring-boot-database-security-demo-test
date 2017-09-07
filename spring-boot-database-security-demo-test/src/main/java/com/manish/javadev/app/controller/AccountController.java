package com.manish.javadev.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.manish.javadev.app.service.AccountService;

@Controller
@RequestMapping("/apiaccount")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@GetMapping("/account/{accId}")
	public ModelAndView getAccountById() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("accountInfo", accountService.findAllAccounts());
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@GetMapping("/accounts")
	public ModelAndView getAllUserTopics() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("accounts", accountService.findAllAccounts());
		modelAndView.setViewName("home");
		return modelAndView;
	}

	@GetMapping("/error")
	public ModelAndView error() {
		ModelAndView modelAndView = new ModelAndView();
		String errorMessage = "Invalid Login Data";
		modelAndView.addObject("errorMsg", errorMessage);
		modelAndView.setViewName("error");
		return modelAndView;
	}
}