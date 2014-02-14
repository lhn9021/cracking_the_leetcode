package leetcode.string;

import java.util.ArrayList;

/*
 * Text Justification 
 * 
 * Given an array of words and a length L, format the text such that each line has exactly L characters
 * and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * http://oj.leetcode.com/problems/text-justification/
 * 
 * Hint: Add as more words as possible.
 * If cur is the last word or there is one word in a line append spaces.
 * Else split spaces between words.
 */
public class TextJustification {
	public class Solution {
		public ArrayList<String> fullJustify(String[] words, int L) {
			ArrayList<String> list = new ArrayList<String>();
			ArrayList<String> res = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			int cur = 0;
			int len = 0;
			while (cur < words.length) {
				sb.setLength(0);
				list.clear();
				len = words[cur].length();
				sb.append(words[cur]);
				cur++;
				while (cur < words.length && len + 1 + words[cur].length() <= L) {
					list.add(" " + words[cur]);
					len = len + 1 + words[cur].length();
					cur++;
				}
				if (list.size() == 0 || cur == words.length) {
					for (int i = 0; i < list.size(); i++) {
						sb.append(list.get(i));
					}
					appendSpaces(sb, L - len);
				} else {
					int avg = (L - len) / list.size();
					int rem = (L - len) % list.size();
					for (int i = 0; i < list.size(); i++) {
						appendSpaces(sb, i < rem ? avg + 1 : avg);
						sb.append(list.get(i));
					}
				}
				res.add(sb.toString());
			}

			return res;
		}

		private void appendSpaces(StringBuilder sb, int n) {
			for (int i = 0; i < n; i++)
				sb.append(' ');
		}
	}
}
