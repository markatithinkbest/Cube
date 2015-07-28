package com.ithinkbest.cube;

public class Cube {
	int x;
	int y;
	int z;
	int a;
	int b;
	int c;

	public Cube() {
		reset();
	}

	public void reset() {

		x = 1;
		y = 2;
		z = 3;
		a = 4;
		b = 5;
		c = 6;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int getC() {
		return c;
	}

	public void rotate(int face, int clock) {
		int temp;

		if (face == 1) { // roateX

			if (clock == 1) {
				temp = z;
				z = y;
				y = c;
				c = b;
				b = temp;
				return;
			}
			if (clock == 2) {
				temp = z;
				z = c;
				c = temp;
				temp = y;
				y = b;
				b = temp;
				return;
			}
			if (clock == 3) {
				temp = z;
				z = b;
				b = c;
				c = y;
				y = temp;
				return;
			}

			
		}
		if (face == 2) { // rotateY
			if (clock == 1) {
				temp = z;
				z = a;
				a = c;
				c = x;
				x = temp;
				return;
			}
			if (clock == 2) {
				temp = z;
				z = c;
				c = temp;
				temp = x;
				x = a;
				a = temp;
				return;
			}
			if (clock == 3) {
				temp = z;
				z = x;
				x = c;
				c = a;
				a = temp;
				return;
			}

		}
		if (face == 3) { // rotateZ
			if (clock == 1) {
				temp = y;
				y = x;
				x = b;
				b = a;
				a = temp;
				return;
			}
			if (clock == 2) {
				temp = y;
				y = b;
				b = temp;
				temp = y;
				x = a;
				a = temp;
				return;
			}
			if (clock == 3) {
				temp = y;
				y = a;
				a = b;
				b = x;
				x = temp;
				return;
			}

		}

	}

	/**
	 * 
	 * @param clock
	 *            1= 90 degree,2= 180 degree,2= 270 degree,
	 * 
	 */
	private void rotateX(int clock) {
		int temp;

		if (clock == 1) {
			temp = z;
			z = y;
			y = c;
			c = b;
			b = temp;
			return;
		}
		if (clock == 2) {
			temp = z;
			z = c;
			c = temp;
			temp = y;
			y = b;
			b = temp;
			return;
		}
		if (clock == 3) {
			temp = z;
			z = b;
			b = c;
			c = y;
			y = temp;
			return;
		}

	}

	private void rotateY(int clock) {
		int temp;

		if (clock == 1) {
			temp = z;
			z = a;
			a = c;
			c = x;
			x = temp;
			return;
		}
		if (clock == 2) {
			temp = z;
			z = c;
			c = temp;
			temp = x;
			x = a;
			a = temp;
			return;
		}
		if (clock == 3) {
			temp = z;
			z = x;
			x = c;
			c = a;
			a = temp;
			return;
		}

	}

	private void rotateZ(int clock) {
		int temp;

		if (clock == 1) {
			temp = y;
			y = x;
			x = b;
			b = a;
			a = temp;
			return;
		}
		if (clock == 2) {
			temp = y;
			y = b;
			b = temp;
			temp = y;
			x = a;
			a = temp;
			return;
		}
		if (clock == 3) {
			temp = y;
			y = a;
			a = b;
			b = x;
			x = temp;
			return;
		}

	}

	public int[] getXYZ() {
		int[] xyz = new int[6];
		xyz[0] = x;
		xyz[1] = y;
		xyz[2] = z;
		xyz[3] = a;
		xyz[4] = b;
		xyz[5] = c;

		return xyz;
	}

}
