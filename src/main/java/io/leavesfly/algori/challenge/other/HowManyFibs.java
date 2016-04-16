package io.leavesfly.algori.challenge.other;

public class HowManyFibs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new HowManyFibs().getFibsNum(10, 100));

	}

	public int getFibsNum(long a, long b) {
		int small = getFibsNumTo(a);
		int big = getFibsNumTo(b);

		return big - small;
	}

	private int getFibsNumTo(long end) {
		long[] fibsArray = new long[3];
		fibsArray[0] = 1;
		fibsArray[1] = 2;

		int tmp = 0;
		for (int i = 0; fibsArray[i % 3] <= end; i++) {
			fibsArray[(i + 2) % 3] = fibsArray[(i + 1) % 3] + fibsArray[i % 3];
			tmp = i;
		}
		return tmp;

	}

}
