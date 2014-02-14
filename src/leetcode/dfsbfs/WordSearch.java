package leetcode.dfsbfs;

/*
 * Word Search
 * 
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 * ["ABCE"],
 * ["SFCS"],
 * ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * http://oj.leetcode.com/problems/word-search/
 * 
 * Hint: dfs every position
 * 
 */
public class WordSearch {
	public class Solution {
		public boolean exist(char[][] board, String word) {
			if (board == null)
				return false;
			if (word == null || word.length() == 0)
				return true;
			boolean[][] visited = new boolean[board.length][board[0].length];
			for (int i = 0; i < board.length; i++)
				for (int j = 0; j < board[0].length; j++)
					if (DFS(board, i, j, word, 0, visited))
						return true;
			return false;
		}

		public boolean DFS(char[][] b, int i, int j, String word, int index,
				boolean[][] visited) {
			if (visited[i][j] || b[i][j] != word.charAt(index))
				return false;
			if (index == word.length() - 1)
				return true;
			visited[i][j] = true;
			if (i >0 && DFS(b, i - 1, j, word, index + 1, visited))
				return true;
			if (i < b.length - 1 && DFS(b, i + 1, j, word, index + 1, visited))
				return true;
			if (j > 0 && DFS(b, i, j - 1, word, index + 1, visited))
				return true;
			if (j < b[0].length - 1 && DFS(b, i, j + 1, word, index + 1, visited))
				return true;
			visited[i][j] = false;
			return false;
		}
	}
}
