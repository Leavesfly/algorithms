package io.leavesfly.algori.challenge.other;

public class PrimaryArithmetic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new PrimaryArithmetic().carryNum(91, 909));

	}

	public int carryNum(int a, int b) {
		int result = 0;
		StringBuilder sba = new StringBuilder(new Integer(a).toString()).reverse();
		StringBuilder sbb = new StringBuilder(new Integer(b).toString()).reverse();
		int[] carryArr = null;

		if (sba.length() == sbb.length()) {
			carryArr = new int[sba.length()];

			if (Integer.parseInt(new Character(sba.charAt(0)).toString())
					+ Integer.parseInt(new Character(sbb.charAt(0)).toString()) >= 10) {
				carryArr[0] = 1;
			}
			for (int i = 1; i < sba.length(); i++) {

				if (Integer.parseInt(new Character(sba.charAt(i)).toString())
						+ Integer.parseInt(new Character(sbb.charAt(i)).toString())
						+ carryArr[i - 1] >= 10) {
					carryArr[i] = 1;
				}
			}
		} else {

			StringBuilder sbMax = sba.length() < sbb.length() ? sbb : sba;
			StringBuilder sbMin = sba.length() > sbb.length() ? sbb : sba;
			carryArr = new int[sbMin.length() + 1];

			if (Integer.parseInt(new Character(sbMax.charAt(0)).toString())
					+ Integer.parseInt(new Character(sbMin.charAt(0)).toString()) >= 10) {
				carryArr[0] = 1;
			}
			for (int i = 1; i < sbMin.length(); i++) {

				if (Integer.parseInt(new Character(sbMax.charAt(i)).toString())
						+ Integer.parseInt(new Character(sbMin.charAt(i)).toString())
						+ carryArr[i - 1] >= 10) {
					carryArr[i] = 1;
				}
			}
			if (Integer.parseInt(new Character(sbMax.charAt(sbMin.length())).toString())
					+ carryArr[sbMin.length() - 1] >= 0) {
				carryArr[sbMin.length()] = 1;
			}

		}
		for (int i = 0; i < carryArr.length; i++) {
			if (carryArr[i] == 1) {
				result++;
			}
		}
		return result;
	}
}
