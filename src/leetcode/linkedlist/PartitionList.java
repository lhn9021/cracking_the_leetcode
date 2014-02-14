package leetcode.linkedlist;

/*
 * Partition List 
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * http://oj.leetcode.com/problems/partition-list/
 * 
 * Hint: ptr points to the smaller partition, pp is the current node.
 * If pp.next.val<x append the node to ptr.
 * Else continue;
 */
public class PartitionList {
	public class Solution {
		public ListNode partition(ListNode head, int x) {
			ListNode dummy = new ListNode(-1);
			dummy.next = head;
			ListNode ptr = dummy;
			ListNode pp = dummy;
			//find the first node which value is larger or equal than x
			while (pp.next != null && pp.next.val < x) {
				pp = pp.next;
				ptr = ptr.next;
			}
			while (pp.next != null) {
				if (pp.next.val >= x)
					pp = pp.next;
				else {
					ListNode tmp = pp.next;
					pp.next = pp.next.next;
					tmp.next = ptr.next;
					ptr.next = tmp;
					ptr = ptr.next;
				}
			}
			return dummy.next;
		}
	}
}
