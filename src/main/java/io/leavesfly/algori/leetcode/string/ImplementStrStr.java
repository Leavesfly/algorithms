package io.leavesfly.algori.leetcode.string;

/**
 * Implement strStr(). Returns a pointer to the first occurrence of needle in
 * haystack, or null if needle is not part of haystack.
 * 
 * @author yefei.yf
 * 
 */
public class ImplementStrStr {
	public static void main(String[] args) {
		System.out.println(ImplementStrStr.getSubStrIndexInefficiency(
				"A man, a plan, a canal: Panama", "plan"));
		System.out.println(ImplementStrStr.getSubStrIndexEfficiency(
				"A man, a plan, a canal: Panama", "plan"));

	}

	public static int getSubStrIndexInefficiency(String haystack, String needle) {
		char[] needleArray = needle.toCharArray();
		char[] haystackArray = haystack.toCharArray();

		for (int i = 0; i < haystackArray.length; i++) {
			int pointer = i;
			for (int j = 0; j < needleArray.length && pointer < haystackArray.length - 1; j++, pointer++) {
				if (haystackArray[pointer] != needleArray[j]) {
					break;
				}
				if (j >= needleArray.length - 1) {
					return i;
				}
			}

		}

		return -1;
	}

	public static int getSubStrIndexEfficiency(String haystack, String needle) {

		return -1;
	}
}
