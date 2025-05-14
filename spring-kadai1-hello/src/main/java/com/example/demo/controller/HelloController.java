package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@PostMapping("/hello")
	public String show(
			@RequestParam("name") String name,
			@RequestParam("age") int age,
			@RequestParam("hobby") String hobby,
			Model model) { //Model＝データの共用置き場
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		model.addAttribute("hobby", hobby);
		return "hello";
	}

	@GetMapping("/") // "/"の意味はhttp://localhost:8080である
	public String index() { //public String は定型文のため変更なし
		return "index"; //表示するHTMLのファイルベース名を""の中に入れる
	}

	@GetMapping("/hello")
	public String input() {
		return "input";
	}

}
