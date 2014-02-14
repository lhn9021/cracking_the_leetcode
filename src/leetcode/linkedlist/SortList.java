package leetcode.linkedlist;

/*
 * Sort List 
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * http://oj.leetcode.com/problems/sort-list/
 * 
 * Hint: find the median of linkedlist seperate, sort and merge them.
 * 
 */
public class SortList {
	public class Solution {
		public ListNode sortList(ListNode head) {
			if (head == null || head.next == null)
				return head;

			ListNode slow = head, fast = head.next;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			fast = slow.next; // use fast as the head of 2nd list
			slow.next = null; // point last to null
			head = sortList(head);
			fast = sortList(fast);
			head = mergeTwoLists(head, fast);
			return head;
		}

		private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
			if (l1 == null)
				return l2;
			if (l2 == null)
				return l1;
			ListNode prev = new ListNode(0);
			ListNode save = prev;
			int a, b;
			while (l1 != null && l2 != null) {
				if (l1.val <= l2.val) {
					prev.next = l1;
					l1 = l1.next;
				} else {
					prev.next = l2;
					l2 = l2.next;

				}
				prev = prev.next;
			}
			if (l1 != null)
				prev.next = l1;
			else if (l2 != null)
				prev.next = l2;
			return save.next;
		}
	}
}
