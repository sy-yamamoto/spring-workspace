package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class Cart {
	private List<Item> items = new ArrayList<Item>();
	private String name;

	public List<Item> getItems() {
		return this.items;
	}
}
