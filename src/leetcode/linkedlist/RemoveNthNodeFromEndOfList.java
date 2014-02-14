package leetcode.linkedlist;

/*
 * Remove Nth Node From End of List 
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 
 * http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Hint: Use two pointer. Let fast move n step first from begin and then move fast slow together until fast is the tail. 
 * Then slow is n+1th node from end. slow.next=slow.next.next will remove nth node.
 * During moving of fast, if there is null, then the list is not long enough and return null
 * 
 */
public class RemoveNthNodeFromEndOfList {
	public class Solution {
		public ListNode removeNthFromEnd(ListNode head, int n) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (head == null)
				return null;
			ListNode begin = new ListNode(-1);
			begin.next = head;
			ListNode fast = begin;
			for (int i = 0; i < n; i++) {
				if (fast == null)
					return null;
				fast = fast.next;
			}
			if (fast == null)
				return null;
			ListNode slow = begin;
			while (fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
			slow.next = slow.next.next;
			return begin.next;
		}
	}
}
