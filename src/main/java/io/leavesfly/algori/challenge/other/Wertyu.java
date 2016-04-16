package io.leavesfly.algori.challenge.other;


public class Wertyu {

	private static final int STR_NUM = 4;

	private String[] strArray;

	public Wertyu() {
		strArray = new String[STR_NUM];
		strArray[0] = "'1234567890-=".toUpperCase();
		strArray[1] = "qwertyuiop[]\\".toUpperCase();
		strArray[2] = "asdfghjkl;'".toUpperCase();
		strArray[3] = "zxcvbnm,./".toUpperCase();
	}

	private char translateChar(String alp) {
		char result = alp.charAt(0);
		int charAt = -1;
		for (int i = 0; i < STR_NUM; i++) {
			charAt = strArray[i].indexOf(alp.charAt(0));

			if (charAt != -1) {
				if (charAt == 0) {
					return result;
				} else {
					result = strArray[i].charAt(strArray[i].indexOf(alp) - 1);
					return result;
				}
			}

		}
		return result;
	}

	public String translateString(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i,
					translateChar(new Character(sb.charAt(i)).toString()));
		}

		return sb.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new Wertyu().translateString("O S, GOMR YPFSU/"));
	}

}
