package io.leavesfly.algori.leetcode.detail;



/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints: Could negative integers be palindromes? (ie, -1)
 * 
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * 
 * You could also try reversing an integer. However, if you have solved the
 * problem "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * 
 * There is a more generic way of solving this problem.
 * 
 * @author yefei.yf
 * 
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		System.out.println(isPalindromeNumber(1213));
		System.out.println(isPalindromeNumber(12155121));
	}

	public static boolean isPalindromeNumber(int checkedNumber) {
		if (checkedNumber < 0) {
			return false;
		}

		int leftDiv = 1;
		int count = 1;
		while (checkedNumber / leftDiv >= 10) {
			leftDiv *= 10;
			count++;
		}
		count = count / 2;
		for (int tmp = checkedNumber; tmp > 0 && count > 0; tmp = tmp / 10) {
			int left = (checkedNumber / leftDiv) % 10;
			int right = tmp % 10;
			if (left != right) {
				return false;
			}
			leftDiv = leftDiv / 10;
			count--;
		}

		return true;
	}
}
