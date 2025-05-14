package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {
	@GetMapping("/contact")
	public String index() {
		return "contactForm";
	}

	@PostMapping("/contact")
	public String contact(
			@RequestParam(name = "genre", defaultValue = "") String genre,
			@RequestParam(name = "detail", defaultValue = "") String detail,
			@RequestParam(name = "lang", defaultValue = "") String[] langList,
			@RequestParam(name = "dueDate", defaultValue = "") LocalDate dueDate,
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,

			Model model) {

		List<String> errors = new ArrayList<String>();

		if (name.isEmpty()) {
			errors.add("名前は必須です");
		} else if (name.length() > 20) {
			errors.add("名前は20文字以上で入力してください");
		}

		if (email.isEmpty()) {
			errors.add("メールアドレスは必須です");
		}
		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			return "contactForm";
		}

		model.addAttribute("genre", genre);
		model.addAttribute("langList", langList);
		model.addAttribute("detail", detail);
		model.addAttribute("dueDate", dueDate);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		return "contactResult";

	}

}
