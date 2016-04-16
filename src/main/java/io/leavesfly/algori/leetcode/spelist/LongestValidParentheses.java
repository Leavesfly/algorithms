package io.leavesfly.algori.leetcode.spelist;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of
 * the longest valid (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length
 * = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is
 * "()()", which has length = 4.
 * 
 * @author yefei.yf
 * 
 */
public class LongestValidParentheses {

	public static void main(String[] args) {
		System.out.println(getLongestValidParentheses("(ewewe)ewew{dsds(dsds)[dsds(dsd)]}"));
		System.out.println(getLongestValidParentheses("[()]{}"));
		System.out.println(getLongestValidParentheses("()[]{}"));
		System.out.println(getLongestValidParentheses(")()())"));

	}

	public static int getLongestValidParentheses(String parenthesesStr) {
		if (parenthesesStr == null || parenthesesStr.length() == 0) {
			throw new IllegalArgumentException();
		}
		int result = 0;
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
					result++;
				}
				break;
			default:
				break;
			}
		}
		return result * 2;
	}
}
