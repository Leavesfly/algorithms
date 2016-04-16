package io.leavesfly.algori.challenge.other;

public class BitOper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = -1024;
		System.out.println("a=" + a + ":" + Integer.toBinaryString(a));

		a = BitOper.setIntBitZero(a, 16);
		System.out.println("a=" + a + ":" + Integer.toBinaryString(a));
	}

	public static int setIntBitOne(int a, int n) {
		int tmp = (int) Math.pow(2, n);
		a = tmp | a;
		return a;
	}

	public static int setIntBitZero(int a, int n) {
		int tmp = (int) Math.pow(2, n);
		a = tmp ^ a;
		return a;
	}

}
