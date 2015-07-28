package com.ithinkbest.cube;

import java.util.Arrays;

public class Cube {
	private int x;
	private int y;
	private int z;
	private int a;
	private int b;
	private int c;

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

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void setA(int a) {
		this.a = a;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setC(int c) {
		this.c = c;
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

	
	@Override
	public String toString() {
		return ""+x+y+z+a+b+c;
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
