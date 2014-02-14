package leetcode.linkedlist;
/*
 * Insertion Sort List
 * 
 * Sort a linked list using insertion sort.
 * 
 * http://oj.leetcode.com/problems/insertion-sort-list/
 * 
 * Hint: find the first node which is larger or equal to current node, then swap current node's value with next nodes.
 */
public class InsertionSortList {
	public class Solution {
	    public ListNode insertionSortList(ListNode head) {
	        if(head == null || head.next == null)
				return head;
			ListNode cur = head.next;
			while(cur != null){
				ListNode tmp = head;
				while(tmp.val < cur.val)//first node whose value greater than current value
					tmp = tmp.next;
				if(tmp != cur){
					while(tmp != cur){
						int tmpvalue = tmp.val;
						tmp.val = cur.val;
						cur.val = tmpvalue;
						tmp = tmp.next;
					}
				}
				cur = cur.next;
			}
			return head;
	    }
	}
}
