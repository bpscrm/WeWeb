package com.bp.wei.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class TestController {

	@RequestMapping(value = "pass", method = RequestMethod.GET)
	public String passParams(HttpServletRequest request, RedirectAttributes attr){
		attr.addAttribute("openid", "123");
		return "redirect:menu";
	}
}
