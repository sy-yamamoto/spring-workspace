package com.example.demo.quiz;

import java.util.Scanner;

public class Quiz3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("お金を入れてください：");
		int money = scan.nextInt();
		if (money < 120) {
			System.out.println("お金が足りません");
		} else {
			System.out.print("購入できました");
			System.out.println("おつりは" + (money - 120) + "円です！");
		}

		scan.close();

	}

}
