package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.RandomStringService;

@Controller
public class RandomStringController {
	@GetMapping("/random")
	public String index() {
		return "random";
	}

	@Autowired //DI：依存性の注入
	RandomStringService service;

	@PostMapping("/random")
	public String gemerate(
			@RequestParam("charLength") int charLength,
			@RequestParam(name = "withNumber", defaultValue = "false") boolean withNumber,
			Model model) {

		//RandomStringService service = new RandomStringService();
		List list = service.generate(charLength, withNumber);

		model.addAttribute("randList", list);
		return "random";
	}

}
