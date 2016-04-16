package io.leavesfly.algori.leetcode.spelist;

import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid
 * but "(]" and "([)]" are not.
 * 
 * @author yefei.yf
 * 
 */
public class ValidParentheses {
	public static void main(String[] args) {
		System.out.println(isValidParentheses("(ewewe)ewew{dsds(dsds)[dsds(dsd)]}"));
		System.out.println(isValidParentheses("[()]{}"));
		System.out.println(isValidParentheses("()[]{}"));
		System.out.println(isValidParentheses("([)]"));
	}

	public static boolean isValidParentheses(String parenthesesStr) {
		if (parenthesesStr == null || parenthesesStr.length() == 0) {
			throw new IllegalArgumentException();
		}

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < parenthesesStr.length(); i++) {
			char tmp = parenthesesStr.charAt(i);

			switch (tmp) {
			case '(':
				stack.add(tmp);
				break;
			case ')':
				if (!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				} else {
					return false;
				}
				break;
			case '[':
				stack.add(tmp);
				break;
			case ']':
				if (!stack.isEmpty() && stack.peek() == '[') {
					stack.pop();
				} else {
					return false;
				}
				break;
			case '{':
				stack.add(tmp);
				break;
			case '}':
				if (!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				} else {
					return false;
				}
				break;
			default:
				break;
			}
		}
		return true;
	}

}
