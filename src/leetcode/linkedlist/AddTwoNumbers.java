package leetcode.linkedlist;

/*
 * Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * http://oj.leetcode.com/problems/add-two-numbers/
 * 
 * Hint: 
 */
public class AddTwoNumbers {
	public class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			int sum = 0;
			ListNode head = new ListNode(0);
			ListNode ptr = head;
			while (l1 != null || l2 != null) {
				if (l1 != null) {
					sum += l1.val;
					l1 = l1.next;
				}
				if (l2 != null) {
					sum += l2.val;
					l2 = l2.next;
				}
				ListNode node = new ListNode(sum % 10);
				sum = sum / 10;
				ptr.next = node;
				ptr = ptr.next;
			}
			if (sum != 0) {
				ListNode node = new ListNode(1);
				ptr.next = node;
			}
			return head.next;

		}
	}
}
