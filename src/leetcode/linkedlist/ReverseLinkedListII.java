package leetcode.linkedlist;

/*
 * Reverse Linked List II 
 * 
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ¡Ü m ¡Ü n ¡Ü length of list.
 * 
 * http://oj.leetcode.com/problems/reverse-linked-list-ii/
 * 
 * Hint: 
 */
public class ReverseLinkedListII {
	public class Solution {
		public ListNode reverseBetween(ListNode head, int m, int n) {
			ListNode begin = new ListNode(-1);
			begin.next = head;
			ListNode prev = begin;
			if (head == null)
				return null;
			while (m > 1) {
				head = head.next;
				prev = prev.next;
				m--;
				n--;
			}
			while (n > 1) {
				ListNode tmp = head.next;
				head.next = tmp.next;
				tmp.next = prev.next;
				prev.next = tmp;
				n--;
			}
			return begin.next;
		}
	}
}
