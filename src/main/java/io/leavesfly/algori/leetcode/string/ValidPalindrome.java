package io.leavesfly.algori.leetcode.string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama�� is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * Note: Have you consider that the string might be empty? ��This is a good
 * question to ask during an interview. For the purpose of this problem, we
 * define empty string as valid palindrome.
 * 
 * @author yefei.yf
 */

public class ValidPalindrome {

	public static void main(String[] args) {
		System.out.println(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(ValidPalindrome.isPalindrome("race a car"));

	}

	public static boolean isPalindrome(String checkedStr) {
		checkedStr = checkedStr.toLowerCase();
		int startPointer = 0;
		int endPointer = checkedStr.length() - 1;
		while (startPointer < endPointer) {
			char startChar = checkedStr.charAt(startPointer);
			char endChar = checkedStr.charAt(endPointer);

			if (!isAlphanumeric(startChar)) {
				startPointer++;
				continue;
			}
			if (!isAlphanumeric(endChar)) {
				endPointer--;
				continue;
			}

			if (startChar != endChar) {
				return false;
			} else {
				startPointer++;
				endPointer--;
			}
		}
		return true;
	}

	private static boolean isAlphanumeric(char checkedChar) {
		if ((checkedChar >= '0' && checkedChar <= '9')
				|| (checkedChar >= 'a' && checkedChar <= 'z')) {
			return true;
		}
		return false;
	}
}
