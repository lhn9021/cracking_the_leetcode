package leetcode.linkedlist;

/*
 * Remove Duplicates from Sorted List 
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * 
 * Hint: If next node is the same with current node, skip next node
 */
public class RemoveDuplicatesFromSortedList {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (head == null)
				return head;
			ListNode n1 = head;
			while (n1.next != null) {
				if (n1.next.val == n1.val) {
					n1.next = n1.next.next;
				} else {
					n1 = n1.next;
				}
			}
			return head;
		}
	}
}
