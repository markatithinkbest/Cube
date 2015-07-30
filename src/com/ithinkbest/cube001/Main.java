package com.ithinkbest.cube001;

public class Main {
	public static void main(String[] args) {
		test1();
	}

	public static void test1() {
		Cube1 c1;
		for (int i = 0; i < 9; i++) {
			c1 = new Cube1();
			System.out.printf("c1 is %s, ", c1);
			c1.rotate(i);
			System.out.printf("after roating %2d, %3s\n", i, c1);
		}
	}

}
