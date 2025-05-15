package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;

@Controller

public class CartController {

	@Autowired
	HttpSession session;

	@Autowired
	Cart cart;

	@Autowired
	Account account;

	@GetMapping("/cart/clear")
	public String clearCart() {
		List<Item> items = cart.getItems();
		items.clear();
		return "cart";
	}

	@PostMapping("/cart/add")
	public String addCart(
			@RequestParam("name") String name,
			@RequestParam(name = "price", defaultValue = "0") int price) {
		List<Item> item = cart.getItems();
		Item items = new Item(name, price);
		item.add(items);
		//item.setName(name);
		//item.setPrice(price);

		return "cart";

	}

	@GetMapping("/cart")
	public String showCart() {
		return "cart";
	}

	@GetMapping("/cart/login")
	public String login() {
		session.invalidate();
		return "cartLogin";

	}

	@PostMapping("/cart/login")
	public String login(
			@RequestParam("name") String name) {
		account.setName(name);

		return "cart";

	}

}
