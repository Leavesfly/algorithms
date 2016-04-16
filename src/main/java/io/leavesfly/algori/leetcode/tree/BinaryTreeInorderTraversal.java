package io.leavesfly.algori.leetcode.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * @author yefei.yf
 * 
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		TreeNode node4 = new TreeNode(4, null, null);
		TreeNode node3 = new TreeNode(3, node4, null);
		TreeNode node2 = new TreeNode(2, node3, null);
		TreeNode root = new TreeNode(1, null, node2);

		System.out.println(Arrays.toString(inorderTraversal(root).toArray()));
	}

	public static List<Integer> inorderTraversal(TreeNode root) {

		List<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode tmp;
		while (!stack.isEmpty()) {
			tmp = stack.peek();
			if (tmp.getLeft() != null) {
				stack.push(tmp.getLeft());
				tmp.setLeft(null);
				continue;
			} else {
				result.add(tmp.getValue());
				tmp = stack.pop();

				if (tmp.getRight() != null) {
					stack.push(tmp.getRight());
					tmp.setRight(null);
				}
			}
		}
		return result;
	}

}
