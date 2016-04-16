package io.leavesfly.algori.tovalley.datastruct.list;

/**
 * 
 * @author LeavesFly
 *
 *         递归方法和非递归方法来实现反转链表
 */
public class ListRollback {

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode one = new ListNode(1);
		head.setNext(one);
		ListNode two = new ListNode(2);
		one.setNext(two);
		ListNode three = new ListNode(3);
		two.setNext(three);
		ListNode four = new ListNode(4);
		three.setNext(four);

		reverseList(head);

	}

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.getNext() == null) {
			return head;
		}

		ListNode preNode = reverseList(head.getNext());
		preNode.setNext(head);
		head.setNext(null);
		return head;

	}

	public static ListNode reverseList1(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.setNext(head);

		if (head == null) {
			return head;
		}

		ListNode curr = head.getNext();
		head.setNext(null);

		while (curr != null) {
			ListNode next = curr.getNext();
			curr.setNext(dummy.getNext());
			dummy.setNext(curr);
			curr = next;
		}
		return dummy.getNext();
	}

}
