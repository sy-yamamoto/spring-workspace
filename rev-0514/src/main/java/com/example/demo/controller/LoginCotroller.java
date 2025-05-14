package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginCotroller {
	@GetMapping("/login")
	public String index() {
		return "login";
	}

	private static final String USER_ID = "student";
	private static final String USER_PASSWORD = "himitu";

	@PostMapping("/login")
	public String login(
			@RequestParam("id") String id,
			@RequestParam("password") String password,
			Model model) {

		String nextPage = "";
		if (USER_ID.equals(id) && USER_PASSWORD.equals(password)) {
			nextPage = "index";
		} else {
			String errorMessage = "";
			if (!USER_ID.equals(id)) {
				errorMessage = "ユーザーIDが一致しませんでした";
			} else {
				errorMessage = "パスワードが一致しませんでした";
			}
			model.addAttribute("message", errorMessage);
			nextPage = "login";

		}

		return "index";
	}
}
