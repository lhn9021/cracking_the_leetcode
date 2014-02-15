package leetcode.tree;
/*
 * Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * Hint: Idea is same convert sorted array to bst
 * 
 */
public class ConvertSortedListToBinarySearchTree {
	class ListNode{
		int val;
		ListNode next;
	}
	public class Solution {
		public TreeNode sortedListRangeBST(ListNode head, ListNode tail) {
		    if (head==tail || head==null) return null;
		    ListNode curr = getMidNode(head,tail);
		    TreeNode root = new TreeNode(curr.val);
		    root.left = sortedListRangeBST(head,curr);
		    root.right = sortedListRangeBST(curr.next,tail);
		    return root;
		}
		public ListNode getMidNode(ListNode head, ListNode tail) {
		    if (head.next == tail) return head;
		    ListNode slow=head,fast=head.next;
            while(fast!=tail&&fast.next!=tail){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
		}
		public TreeNode sortedListToBST(ListNode head) {
		    return sortedListRangeBST(head,null);
		}
    }
}
