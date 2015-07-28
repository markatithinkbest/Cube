package com.ithinkbest.cube;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
	// static String[] color = { " ", "Red", "Blue", "Yellow", "Orange",
	// "Green", "White" };
	// 白黃相對、紅橘相對、藍綠相對，且藍、橘、黃
	static String[] colorName = { " ", "藍", "橘", "黃", "綠", "紅", "白" };
	static int style = 1;

	public static void main(String[] args) {
		// testCubeRotate();
		// testCube333Rotate();
		// testSol();
		//testRnd();
		new Cube333().showSample(1);
	}

	
	
	public static void testRnd() {
		Random rnd = new Random();
		int face, ring, clock;
		face = rnd.nextInt(3) + 1;
		Cube333 cube333 = new Cube333();
		// showCube333Color(cube333.getColor());

		System.out.println("\n --- " + cube333.getCompleteFaceCnt());
		cube333.showColor();
		System.out.println();

		String sol001 = "Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		cube333.rotateByCommand(sol001);

//		System.out.println("\n case --- " + cube333.getCompleteFaceCnt());
		cube333.showColor();
//		System.out.println();
		int completeFaceCnt = 0;

		String[] steps = sol001.split(" ");
		Set<String> set = new HashSet<>();
		for (String step : steps) {
			set.add(step);
//			System.out.println(set);

		}
		System.out.println("\n"+sol001);

		String[] elements = set.toArray(new String[set.size()]);
		for (String element : elements) {

			System.out.println(element);

		}

		int r = 0;
		for (int m = 1; m < 200000; m++) {
			cube333.reset();
			cube333.rotateByCommand(sol001);
		//	System.out.printf("\n%7d %s " ,m, cube333.getCompleteFaceCnt());
//			cube333.showColor();
//			System.out.println(" "+m);
			String goodMoves="";
			for (int i = 0; i < 20; i++) {
				// r=rnd.nextInt(3) + 1;
				// ring=rnd.nextInt(3) + 1;
				// clock=rnd.nextInt(3) + 1;
				//
				// cube333.rotate(face, ring, clock);
				//
				r = rnd.nextInt(elements.length);
				goodMoves=goodMoves+elements[r]+" ";
				cube333.rotateByCommand(elements[r]);
				
				//
				completeFaceCnt = cube333.getCompleteFaceCnt();
//				if (completeFaceCnt >= 6) {
//
//					// System.out.printf("\n%6d %d%d%d
//					// %d",i,face,ring,clock,completeFaceCnt);
//					System.out.printf("\n%6d  %d", m,completeFaceCnt);
//
//					cube333.showColor();
//				}
				
				if (completeFaceCnt == 6) {
					System.out.printf("\n%6d  %d", m,completeFaceCnt);

					cube333.showColor();
					System.out.printf("\ngood moves =>  %s", goodMoves);
						return;
				}
				// showCube333Color(cube333.getColor());

				// System.out.print( rnd.nextInt(3) + 1);
			}
		}
		// showCube333Color(cube333.getColor());

		System.out.println("\n --- Not found!");

	}

	public static void testSol() {
		// String sol001ch="[中右,右下][中右,右下][中右,右翻][中左,右下][中左,右下][中左,右翻]";
		// String sol001=" Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		String sol001 = "Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		// String sol001="Z23 X13 Z23";

		// String [] moves=sol001.split(" ");
		// for (String move:moves){
		// System.out.println(move);
		// }
		Cube333 cube333 = new Cube333();
		// showCube333Color(cube333.getColor());
		cube333.showColor();
		cube333.rotateByCommand(sol001);
		System.out.println();
		System.out.println(cube333.getCompleteFaceCnt() + " ");
		cube333.showColor();

		// showCube333Color(cube333.getColor());
	}

	public static void testCube333Rotate() {

		Cube333 cube333 = new Cube333();

		for (int face = 1; face <= 3; face++) {
			for (int ring = 1; ring <= 3; ring++) {
				for (int clock = 1; clock <= 3; clock++) {
					System.out.printf("face=%d ring=%d clock=%d  ", face, ring, clock);

					cube333.reset();
					// showCube333Color(cube333.getColor());
					cube333.rotate(face, ring, clock);

					showCube333Color(cube333.getColor());
					// System.out.println();
				}
			}
		}
	}

	public static void testCubeRotate() {

		Cube cube = new Cube();

		for (int face = 1; face <= 3; face++) {
			for (int clock = 1; clock <= 3; clock++) {
				cube.reset();
				showCubeColor(cube.getXYZ());
				cube.rotate(face, clock);
				showCubeColor(cube.getXYZ());
				System.out.println();

			}
		}

	}

	public static void testRotateX() {

		Cube cube = new Cube();
		// int[] xyz=cube.getXYZ();
		showCubeColor(cube.getXYZ());
		cube.rotate(1, 1);
		showCubeColor(cube.getXYZ());

		cube.reset();
		cube.rotate(1, 2);
		showCubeColor(cube.getXYZ());

		cube.reset();
		cube.rotate(1, 3);
		showCubeColor(cube.getXYZ());

	}

	public static void showCubeColor(int[] xyz) {
		if (style == 1) {
			for (int k : xyz) {
				System.out.print(k);
			}
			System.out.print(" ");
			return;
		}

		for (int k : xyz) {
			System.out.print(k + "_" + colorName[k] + " ");
		}
		System.out.println();
	}

	public static void showCube333Color(int[][] color) {
		if (style == 1) {
			for (int face = 1; face <= 3; face++) {
				// for (int face = 1; face <= 6; face++) {
				for (int unit = 1; unit <= 9; unit++) {
					System.out.print(colorName[color[face][unit]]);
					if (unit == 3 || unit == 6) {
						System.out.print("-");

					}

				}
				System.out.print(" ");
			}

			// System.out.println( "--- "+);
			return;
		}
	}
}
