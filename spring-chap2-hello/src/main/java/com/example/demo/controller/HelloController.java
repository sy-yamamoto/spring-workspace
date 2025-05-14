package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //アノテーション(annotation):ソースコードだけではコンパイラに伝えられない不足情報の記述
public class HelloController {

	@PostMapping("/hello")
	public String helloByPost(@RequestParam("msg") String message, Model model) {
		model.addAttribute("memo", message);
		return "hello";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam("msg") String message, //クエリストリングを受け取る仮引数
			Model model //遷移先画面にデータを引き継ぐための変数
	) {

		model.addAttribute("memo", message);

		return "hello";
	}

	/*
	 * hello.htmlを表示する
	 * @return Thmeleafテンプレート名
	 */

	@GetMapping({ "/", "/test" }) //GETメソッドでURLパターン「/」でアクセスされた場合に呼び出される:「/」 = 「http://localhost:8080/」
	public String index() {
		return "hello";

	}
}
