package leetcode.linkedlist;

/*
 * Populating Next Right Pointers in Each Node 
 * Populating Next Right Pointers in Each Node II
 * 
 * Given a binary tree
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * 
 * Hint: User prev to connect next level's node.
 * Use next to record next loop's node. 

 */
public class PopulatingNextRightPointersInEachNodeI_II {
	public class Solution {
		public void connect(TreeLinkNode root) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			while (root != null) {
				TreeLinkNode prev = null;
				TreeLinkNode next = null;
				for (; root != null; root = root.next) {
					if (next == null)
						next = root.left == null ? root.right : root.left;
					if (root.left != null) {
						if (prev != null)
							prev.next = root.left;
						prev = root.left;
					}
					if (root.right != null) {
						if (prev != null)
							prev.next = root.right;
						prev = root.right;
					}
				}
				root = next;
			}
		}
	}
}
