package leetcode.linkedlist;

/*
 * Reorder List 
 * 
 * Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
 * reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * http://oj.leetcode.com/problems/reorder-list/
 * 
 * Hint: Use reverse and merge linkedlist.
 */
public class ReorderList {
	public class Solution {
		public void reorderList(ListNode head) {
			if (head == null || head.next == null)
				return;
			ListNode slow = head, fast = head.next;
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
			fast = slow.next;
			slow.next = null;
			ListNode head1 = head, head2 = fast;
			
			head2 = reverse(head2); 
			ListNode p = head1, q = head2;
			while (q != null) {
				ListNode tmp1 = p.next;
				ListNode tmp2 = q.next;
				p.next = q;
				q.next = tmp1;
				p = tmp1;
				q = tmp2;
			}
		}

		public ListNode reverse(ListNode head) {
			ListNode prev = head, cur = head.next, next = null;
			while (cur != null) {
				next = cur.next;
				cur.next = prev;
				prev = cur;
				cur = next;
			}

			head.next = null;
			return prev;
		}
	}
}
