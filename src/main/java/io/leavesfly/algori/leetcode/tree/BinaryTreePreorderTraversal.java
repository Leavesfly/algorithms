package io.leavesfly.algori.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,2,3].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author yefei.yf
 * 
 */
public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode node3 = new TreeNode(3, null, null);
		TreeNode node2 = new TreeNode(2, node3, null);
		TreeNode root = new TreeNode(1, null, node2);

		System.out.println(Arrays.toString(preorderTraversal(root).toArray()));

	}

	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode tmp;
		while (!stack.isEmpty()) {
			tmp = stack.pop();
			result.add(tmp.getValue());
			if (tmp.getLeft() != null) {
				stack.push(tmp.getLeft());
				continue;
			}
			if (tmp.getRight() != null) {
				stack.push(tmp.getRight());
			}
		}

		return result;
	}

}
