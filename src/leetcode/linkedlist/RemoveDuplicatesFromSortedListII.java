package leetcode.linkedlist;

/*
 * Remove Duplicates from Sorted List II 
 * 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * 
 * Hint: Add a boolean to check whether it is duplicated or not.
 */
public class RemoveDuplicatesFromSortedListII {
	public class Solution {
		public ListNode deleteDuplicates(ListNode head) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (head == null)
				return null;
			ListNode begin = head;
			ListNode prev = new ListNode(-1);
			ListNode save = prev;
			prev.next = head;
			while (begin != null) {
				boolean duplicate = false;
				while (begin.next != null && begin.val == begin.next.val) {
					duplicate = true;
					begin = begin.next;
				}
				if (duplicate) {
					prev.next = begin.next;
					begin = begin.next;
				} else {
					prev = begin;
					begin = begin.next;
				}
			}
			return save.next;
		}
	}
}
