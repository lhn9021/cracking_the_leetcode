package leetcode.linkedlist;

/*
 * Reverse Nodes in k-Group 
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * http://oj.leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Hint: First move head k-1 times to see whether the rest can be reversed or not.
 * Then reverse the list as other reverse linkedlist question.
 */
public class ReverseNodesInKGroup {
	public class Solution {
		public ListNode reverseKGroup(ListNode head, int k) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			ListNode begin = new ListNode(-1);
			if (k < 1 || head == null || head.next == null)
				return head;
			begin.next = head;
			ListNode prev = begin;
			while (head != null) {
				int count = k;
				while (head != null && count > 1) {
					head = head.next;
					count--;
				}
				if (head != null) {
					head = prev.next;
					count = k;
					while (count > 1) {
						ListNode tmp = head.next;
						head.next = tmp.next;
						tmp.next = prev.next;
						prev.next = tmp;
						count--;
					}
					prev = head;
					head = head.next;
				}
			}
			return begin.next;
		}
	}
}
