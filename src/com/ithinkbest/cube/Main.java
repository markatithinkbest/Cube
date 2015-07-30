package com.ithinkbest.cube;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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
		// testGoodcombo();
		// testNormalizedCmd();
		try {
			filterLast2Cubes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void filterLast2Cubes() throws IOException {
		Util util = new Util();
		Set<String> solSet = new HashSet<>();

		// Open the file
		FileInputStream fstream = null;
		try {
			fstream = new FileInputStream("/home/mark/MyDev/data/last2cubes.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		String str;

		// Read File Line By Line
		int i = 0;
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			str = strLine.substring(4).trim();
			// System.out.println (cmd);

			// String str=getGoodcombo().split("=>")[1];
			if (str.length() > 1) {
				System.out.printf("(%2d) %s \n", i++, str);
				str = util.getNormalizedCmd(str);
				System.out.printf(".....%s \n", str);

				boolean isNew = solSet.add(str);
				if (isNew) {
					System.out.println(" sol cnt now is => " + solSet.size());

				}
			}

		}

		// Close the input stream
		br.close();
		int k = 0;
		for (String str2 : solSet) {
			System.out.printf("%3d %s\n", k++, str2);

		}

		List<String> solList = new LinkedList<>(solSet);

		class SolComparator implements Comparator<String> {

			public int compare(String e1, String e2) {
				if (e1.length() > e2.length()) {
					return 1;
				}
				if (e1.length() < e2.length()) {
					return -1;
				}

				return e1.compareTo(e2);
			}

		}

		System.out.printf("--- order by length then string sequence ---\n");

		Collections.sort(solList, new SolComparator());
		k = 0;
		for (String str2 : solList) {
			System.out.printf("%3d %s\n", k++, str2);

		}

	}

	public static void testNormalizedCmd() {
		Util util = new Util();
		Set<String> solSet = new HashSet<>();
		for (int i = 0; i < Util.sampleCmd.length; i++) {
			System.out.println("before => " + Util.sampleCmd[i]);

			String str = util.getNormalizedCmd(Util.sampleCmd[i]);
			System.out.println(" after => " + str);
			boolean isNew = solSet.add(str);
			if (isNew) {
				System.out.println(" sol cnt now is => " + solSet.size());

			}
		}
		System.out.println("set => " + solSet);

	}

	public static void testGoodcombo() {
		Util util = new Util();
		Set<String> solSet = new HashSet<>();

		for (int i = 1; i <= 999; i++) {
			String str = getGoodcombo().split("=>")[1];
			if (str.length() > 1) {
				System.out.printf("(%2d) %s \n", i, str);
				str = util.getNormalizedCmd(str);
				System.out.printf(".....%s \n", str);

				boolean isNew = solSet.add(str);
				if (isNew) {
					System.out.println(" sol cnt now is => " + solSet.size());

				}
			}

		}
		// System.out.println("set => " + solSet);
		int k = 0;
		for (String str : solSet) {
			System.out.printf("%3d %s\n", k++, str);

		}

	}

	public static String getGoodcombo() {
		Random rnd = new Random();
		int face, ring, clock;
		face = rnd.nextInt(3) + 1;
		Cube333 cube333 = new Cube333();
		// showCube333Color(cube333.getColor());

		// System.out.println("\n --- " + cube333.getCompleteFaceCnt());
		// cube333.showColor();
		// System.out.println();

		String sol001 = "Z23 X13 Z23 X13 Z23 X12 Z21 X13 Z21 X13 Z21 X12";
		cube333.rotateByCommand(sol001);

		// System.out.println("\n case --- " + cube333.getCompleteFaceCnt());
		// cube333.showColor();
		// System.out.println();
		int completeFaceCnt = 0;

		String[] steps = sol001.split(" ");
		Set<String> set = new HashSet<>();
		for (String step : steps) {
			set.add(step);
			// System.out.println(set);

		}
		// System.out.println("\n" + sol001);

		String[] elements = set.toArray(new String[set.size()]);
		// for (String element : elements) {
		//
		// System.out.println(element);
		//
		// }

		int r = 0;
		int tryCnt = 654321;
		for (int m = 1; m <= tryCnt; m++) {
			cube333.reset();
			cube333.rotateByCommand(sol001);
			// System.out.printf("\n%7d %s " ,m, cube333.getCompleteFaceCnt());
			// cube333.showColor();
			// System.out.println(" "+m);
			String goodMoves = "";
			for (int i = 0; i < 20; i++) {
				// r=rnd.nextInt(3) + 1;
				// ring=rnd.nextInt(3) + 1;
				// clock=rnd.nextInt(3) + 1;
				//
				// cube333.rotate(face, ring, clock);
				//
				r = rnd.nextInt(elements.length);
				goodMoves = goodMoves + elements[r] + " ";
				cube333.rotateByCommand(elements[r]);

				//
				completeFaceCnt = cube333.getCompleteFaceCnt();
				// if (completeFaceCnt >= 6) {
				//
				// // System.out.printf("\n%6d %d%d%d
				// // %d",i,face,ring,clock,completeFaceCnt);
				// System.out.printf("\n%6d %d", m,completeFaceCnt);
				//
				// cube333.showColor();
				// }

				if (completeFaceCnt == 6) {
					// System.out.printf("\n%6d %d", m, completeFaceCnt);

					// cube333.showColor();
					// System.out.printf("\n%6d => %s",m, goodMoves);
					String str = String.format("%6d =>%s", m, goodMoves);

					return str;
				}
				// showCube333Color(cube333.getColor());

				// System.out.print( rnd.nextInt(3) + 1);
			}
		}
		// showCube333Color(cube333.getColor());

		// System.out.println("\n This time, no good combo found!");
		String str = String.format("%6d =>%s", tryCnt, "-");
		return str;
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

		// System.out.println("\n case --- " + cube333.getCompleteFaceCnt());
		cube333.showColor();
		// System.out.println();
		int completeFaceCnt = 0;

		String[] steps = sol001.split(" ");
		Set<String> set = new HashSet<>();
		for (String step : steps) {
			set.add(step);
			// System.out.println(set);

		}
		System.out.println("\n" + sol001);

		String[] elements = set.toArray(new String[set.size()]);
		for (String element : elements) {

			System.out.println(element);

		}

		int r = 0;
		for (int m = 1; m < 200000; m++) {
			cube333.reset();
			cube333.rotateByCommand(sol001);
			// System.out.printf("\n%7d %s " ,m, cube333.getCompleteFaceCnt());
			// cube333.showColor();
			// System.out.println(" "+m);
			String goodMoves = "";
			for (int i = 0; i < 20; i++) {
				// r=rnd.nextInt(3) + 1;
				// ring=rnd.nextInt(3) + 1;
				// clock=rnd.nextInt(3) + 1;
				//
				// cube333.rotate(face, ring, clock);
				//
				r = rnd.nextInt(elements.length);
				goodMoves = goodMoves + elements[r] + " ";
				cube333.rotateByCommand(elements[r]);

				//
				completeFaceCnt = cube333.getCompleteFaceCnt();
				// if (completeFaceCnt >= 6) {
				//
				// // System.out.printf("\n%6d %d%d%d
				// // %d",i,face,ring,clock,completeFaceCnt);
				// System.out.printf("\n%6d %d", m,completeFaceCnt);
				//
				// cube333.showColor();
				// }

				if (completeFaceCnt == 6) {
					System.out.printf("\n%6d  %d", m, completeFaceCnt);

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
