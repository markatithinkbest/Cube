package com.ithinkbest.cube;

public class Cube333 {

	Cube[] cubes;

	// int[] x1={-1,26,23,20,17,14,11,8,5,2};
	// int[] x2={-1,25,22,19,16,13,10,7,4,1};
	// int[] x3={-1,24,21,18,15,12,9,6,3,0};
	//
	// final int [][]xi={{-1},
	// {-1,26,23,20,17,14,11,8,5,2},
	// {-1,25,22,19,16,13,10,7,4,1},
	// {-1,24,21,18,15,12,9,6,3,0} };

	// to keep format
	// final int [][][]xyz={{},
	// {{-1},
	// {-1,26,23,20,17,14,11,8,5,2},
	// {-1,25,22,19,16,13,10,7,4,1},
	// {-1,24,21,18,15,12,9,6,3,0}},
	// {{-2},
	// {-2,24,25,26,15,16,17,6,7,8},
	// {-2,21,22,23,12,13,14,3,4,5},
	// {-2,18,19,20,9,10,11,0,1,2}},
	// {{-3},
	// {-3,18,19,20,21,22,23,24,25,26},
	// {-3,9,10,11,12,13,14,15,16,17},
	// {-3,0,1,2,3,4,5,6,7,8}}
	// };
	//
	final int[][][] xyz = { {},
			{ { -1 }, { -1, 26, 23, 20, 17, 14, 11, 8, 5, 2 }, { -1, 25, 22, 19, 16, 13, 10, 7, 4, 1 },
					{ -1, 24, 21, 18, 15, 12, 9, 6, 3, 0 } },
			{ { -2 }, { -2, 24, 25, 26, 15, 16, 17, 6, 7, 8 }, { -2, 21, 22, 23, 12, 13, 14, 3, 4, 5 },
					{ -2, 18, 19, 20, 9, 10, 11, 0, 1, 2 } },
			{ { -3 }, { -3, 18, 19, 20, 21, 22, 23, 24, 25, 26 }, { -3, 9, 10, 11, 12, 13, 14, 15, 16, 17 },
					{ -3, 0, 1, 2, 3, 4, 5, 6, 7, 8 } } };

	public Cube333() {
		reset();
	}

	public void reset() {
		cubes = new Cube[27];
		for (int i = 0; i < 27; i++) {
			cubes[i] = new Cube();
		}
	}

	public void rotateByCommand(String cmd) {
		String[] moves = cmd.split(" ");
		int face, ring, clock;
		face = 0;
		int temp;
		for (String move : moves) {

			if (move.startsWith("X")) {
				face = 1;
			} else if (move.startsWith("Y")) {
				face = 2;
			} else if (move.startsWith("Z")) {
				face = 3;
			}
			temp = Integer.parseInt(move.substring(1));
			ring = temp / 10;
			clock = temp - ring * 10;
			// System.out.println(move+" "+face+" "+ring+" "+clock);
			rotate(face, ring, clock);
//			System.out.print(move + " " + face + " " + ring + " " + clock + "  ");
//			showColor();

		}
	}

	
	public void rotate(int face, int ring, int clock) {
		Cube temp;
		// if (face==1){
		// temp =cubes[xi[ring][1]];
		// cubes[xi[ring][1]]=cubes[xi[ring][7]];
		// cubes[xi[ring][7]]=cubes[xi[ring][9]];
		// cubes[xi[ring][9]]=cubes[xi[ring][3]];
		// cubes[xi[ring][3]]=temp;
		//
		// temp =cubes[xi[ring][2]];
		// cubes[xi[ring][2]]=cubes[xi[ring][4]];
		// cubes[xi[ring][4]]=cubes[xi[ring][8]];
		// cubes[xi[ring][8]]=cubes[xi[ring][6]];
		// cubes[xi[ring][6]]=temp;
		//
		// for (int k=1;k<=9;k++){
		// cubes[xi[ring][k]].rotate(face, clock);
		// }
		// }
		if (clock == 1) {
			temp = cubes[xyz[face][ring][1]];
			cubes[xyz[face][ring][1]] = cubes[xyz[face][ring][7]];
			cubes[xyz[face][ring][7]] = cubes[xyz[face][ring][9]];
			cubes[xyz[face][ring][9]] = cubes[xyz[face][ring][3]];
			cubes[xyz[face][ring][3]] = temp;

			temp = cubes[xyz[face][ring][2]];
			cubes[xyz[face][ring][2]] = cubes[xyz[face][ring][4]];
			cubes[xyz[face][ring][4]] = cubes[xyz[face][ring][8]];
			cubes[xyz[face][ring][8]] = cubes[xyz[face][ring][6]];
			cubes[xyz[face][ring][6]] = temp;

			for (int k = 1; k <= 9; k++) {
				cubes[xyz[face][ring][k]].rotate(face, clock);
			}
		}
		if (clock == 2) {
			temp = cubes[xyz[face][ring][1]];
			cubes[xyz[face][ring][1]] = cubes[xyz[face][ring][9]];
			cubes[xyz[face][ring][9]] = temp;

			temp = cubes[xyz[face][ring][2]];
			cubes[xyz[face][ring][2]] = cubes[xyz[face][ring][8]];
			cubes[xyz[face][ring][8]] = temp;

			temp = cubes[xyz[face][ring][3]];
			cubes[xyz[face][ring][3]] = cubes[xyz[face][ring][7]];
			cubes[xyz[face][ring][7]] = temp;

			temp = cubes[xyz[face][ring][4]];
			cubes[xyz[face][ring][4]] = cubes[xyz[face][ring][6]];
			cubes[xyz[face][ring][6]] = temp;

			for (int k = 1; k <= 9; k++) {
				cubes[xyz[face][ring][k]].rotate(face, clock);
			}
		}
		if (clock == 3) {
			temp = cubes[xyz[face][ring][1]];
			cubes[xyz[face][ring][1]] = cubes[xyz[face][ring][3]];
			cubes[xyz[face][ring][3]] = cubes[xyz[face][ring][9]];
			cubes[xyz[face][ring][9]] = cubes[xyz[face][ring][7]];
			cubes[xyz[face][ring][7]] = temp;

			temp = cubes[xyz[face][ring][2]];
			cubes[xyz[face][ring][2]] = cubes[xyz[face][ring][6]];
			cubes[xyz[face][ring][6]] = cubes[xyz[face][ring][8]];
			cubes[xyz[face][ring][8]] = cubes[xyz[face][ring][4]];
			cubes[xyz[face][ring][4]] = temp;

			for (int k = 1; k <= 9; k++) {
				cubes[xyz[face][ring][k]].rotate(face, clock);
			}
		}

	}

	public int[][] getColor() {
		int[][] color = new int[7][10];

		for (int k = 1; k <= 9; k++) {
			color[1][k] = cubes[xyz[1][1][k]].getX();
			color[2][k] = cubes[xyz[2][1][k]].getY();
			color[3][k] = cubes[xyz[3][1][k]].getZ();
			color[4][k] = cubes[xyz[1][3][k]].getA();
			color[5][k] = cubes[xyz[2][3][k]].getB();
			color[6][k] = cubes[xyz[3][3][k]].getC();
		}

		return color;
	}

	public void showColor() {
		int[][] color = getColor();
		String[] colorName = { " ", "藍", "橘", "黃", "綠", "紅", "白" };
		for (int face = 1; face <= 6; face++) {
			System.out.print("[");
			// for (int face = 1; face <= 6; face++) {
			for (int unit = 1; unit <= 9; unit++) {
				System.out.print(colorName[color[face][unit]]);
				if (unit == 3 || unit == 6) {
					System.out.print("-");

				}
			}
			System.out.print("] ");
		}
		// System.out.println();
	}

	public int getCompleteFaceCnt() {
		int[][] color = getColor();
		String[] colorName = { " ", "藍", "橘", "黃", "綠", "紅", "白" };
		int cnt = 0;
		int temp = 0;
		for (int face = 1; face <= 6; face++) {
			temp = 0;
			for (int unit = 1; unit <= 9; unit++) {
				if (color[face][5] == color[face][unit]) {
					temp++;
				}

			}
			if (temp == 9) {
				cnt++;
			}
		}
		return cnt;
	}
}
