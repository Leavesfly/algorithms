package io.leavesfly.algori.tovalley.datastruct.list;

/**
 * 
 * @author LeavesFly
 *
 *         给出一个单向链表的头指针，如果有环，则返回环的长度，否则为0。
 *
 */
public class LengthOfCycle {
	public static void main(String[] args) {

	}

	public static int getCircleLength(ListNode head) {
		if (head == null || head.getNext() == null) {
			return 0;
		}
		ListNode slow = head;
		ListNode fast = head;

		while (fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			if (fast == slow) {
				return getLength(slow);
			}
		}

		return 0;
	}

	private static int getLength(ListNode node) {
		int length = 1;
		ListNode currentNode = node;
		while (currentNode.getNext() != node) {
			++length;
			currentNode = currentNode.getNext();
		}
		return length;
	}
}
