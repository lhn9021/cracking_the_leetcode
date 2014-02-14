package leetcode.stack;

import java.util.Stack;

/*
 * Simplify Path
 * 
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * http://oj.leetcode.com/problems/simplify-path/
 * 
 * Hint: User stack to store path. ".." means pop, "." or length==0 means nothing, else push into stack
 */
public class SimplifyPath {
	public class Solution {
		public String simplifyPath(String path) {
			// Note: The Solution object is instantiated only once and is reused
			// by each test case.
			if (path == null || path.length() == 0)
				return "/";
			String[] path2 = path.trim().split("/");
			Stack<String> stack = new Stack<String>();
			int i = 0;
			for (String str : path2) {
				if (str.length() == 0 || str.equals(".")) {
					continue;
				} else if (str.equals("..")) {
					if (!stack.empty())
						stack.pop();
				} else
					stack.push(str);
			}
			StringBuilder sb = new StringBuilder();
			if (stack.empty()) {
				sb.insert(0, '/');
				return sb.toString();
			}
			while (!stack.empty()) {
				sb.insert(0, stack.pop());
				sb.insert(0, '/');
			}
			return sb.toString();
		}
	}
}
