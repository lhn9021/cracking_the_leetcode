package leetcode.linkedlist;

/*
 * Linked List Cycle II 
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * http://oj.leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Hint : Same as LinkedListCycle I. 
 * When fast==slow, reset slow to head and move slow and fast at same speed until they meet.
 */
public class LinkedListCycleII {
	public class Solution {
		public ListNode detectCycle(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
			while (true) {
				if (fast == null || fast.next == null) {
					return null;
				}
				slow = slow.next;
				fast = fast.next.next;
				if (fast == slow) {
					break;
				}
			}

			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
	}
}
