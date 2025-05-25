package com.interview;

public class TestClient {

	public static void main(String[] args) {

		int a = 5;
		int b = 10;

		FunctionalInterfaceExample addition = (valA, valB) -> valA + valB;

		int result = addition.sum(a, b);

		System.out.println(result);

	}

}
