package leetcode.linkedlist;

/*
 * Swap Nodes in Pairs 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 * 
 * http://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * 
 * Hint: Same as any reverse linkedlist question
 */
public class SwapNodesInPairs {
	public class Solution {
		public ListNode swapPairs(ListNode head) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			ListNode begin = new ListNode(-1);
			begin.next = head;
			ListNode prev = begin;
			while (head != null && head.next != null) {
				ListNode tmp = head.next;
				head.next = tmp.next;
				tmp.next = prev.next;
				prev.next = tmp;
				prev = head;
				head = head.next;
			}
			return begin.next;
		}
	}
}
