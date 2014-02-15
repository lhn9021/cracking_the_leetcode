package leetcode.linkedlist;

/*
 * Rotate List 
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * http://oj.leetcode.com/problems/rotate-list/
 * 
 * Hint: Two pointers. One points to the new end and one points to the original tail
 */
public class RotateList {
	public class Solution {
		public ListNode rotateRight(ListNode head, int n) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			ListNode n2 = head;
			ListNode n1 = head;
			if (head == null)
				return null;
			for (int i = 0; i < n; i++) {
				if (n1.next == null)
					n1 = head;
				else
					n1 = n1.next;
			}
			if (n1 == head)
				return head;
			while (n1.next != null) {
				n1 = n1.next;
				n2 = n2.next;
			}
			ListNode top = n2.next;
			n1.next = head;
			n2.next = null;
			return top;

		}
	}
}
