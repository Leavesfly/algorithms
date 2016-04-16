package io.leavesfly.algori.leetcode.sort;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author yefei.yf
 * 
 */
public class MergeTwoSortedLists {
	public static void main(String[] args) {
		LinkedNode one = new LinkedNode(1);
		LinkedNode one1 = new LinkedNode(1);
		LinkedNode one2 = new LinkedNode(3);
		LinkedNode one3 = new LinkedNode(6);
		LinkedNode one4 = new LinkedNode(9);
		one.setNext(one1);
		one1.setNext(one2);
		one2.setNext(one3);
		one3.setNext(one4);

		LinkedNode other = new LinkedNode(7);
		LinkedNode other1 = new LinkedNode(10);
		LinkedNode other2 = new LinkedNode(15);
		LinkedNode other3 = new LinkedNode(18);
		LinkedNode other4 = new LinkedNode(19);
		other.setNext(other1);
		other1.setNext(other2);
		other2.setNext(other3);
		other3.setNext(other4);

		LinkedNode result = merge(one, other);

		while (result != null) {
			System.out.println(result.getValue());
			result = result.getNext();
		}

	}

	public static LinkedNode merge(LinkedNode one, LinkedNode other) {
		LinkedNode result = new LinkedNode();
		LinkedNode tmp = result;

		while (one != null && other != null) {
			if (one.getValue() > other.getValue()) {
				tmp.setNext(other);
				other = other.getNext();
			} else {
				tmp.setNext(one);
				one = one.getNext();
			}
			tmp = tmp.getNext();
		}
		if (one != null) {
			tmp.setNext(one);
		} else {
			tmp.setNext(other);
		}

		return result = result.getNext();
	}

	static class LinkedNode {
		private int value;
		private LinkedNode next;

		public LinkedNode() {

		}

		public LinkedNode(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public LinkedNode getNext() {
			return next;
		}

		public void setNext(LinkedNode next) {
			this.next = next;
		}

	}

}
