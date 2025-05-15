package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class AccountController {

	@GetMapping("/account")
	public String index(Model model) {
		model.addAttribute("account", new Account());
		return "accountForm";
	}

	@PostMapping("/account/confirm")
	public String confirm(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {
		Account account = new Account();
		account.setName(name);
		account.setEmail(email);
		account.setPassword(password);

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
			return "accountForm";
		}
		if (password.isEmpty()) {
			errors.add("パスワードは必須です");
		}
		if (errors.size() > 0) {
			model.addAttribute("errors", errors);
			return "accountForm";
		}

		model.addAttribute("account", account);

		return "accountConfirm";
	}
}
