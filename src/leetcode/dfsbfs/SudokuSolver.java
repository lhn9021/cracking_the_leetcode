package leetcode.dfsbfs;

import java.util.HashSet;
import java.util.Set;

/*
 * 
 * Sudoku Solver 
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * http://oj.leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
	public class Solution {
		public boolean isValid(char[][] board, int a, int b) {
			Set<Character> contained = new HashSet<Character>();
			for (int i = 0; i < 9; i++) {
				if (contained.contains(board[a][i]))
					return false;
				if (board[a][i] > '0' && board[a][i] <= '9')
					contained.add(board[a][i]);
			}
			contained.clear();
			for (int j = 0; j < 9; j++) {
				if (contained.contains(board[j][b]))
					return false;
				if (board[j][b] > '0' && board[j][b] <= '9')
					contained.add(board[j][b]);
			}
			contained.clear();
			for (int m = 0; m < 3; m++) {
				for (int n = 0; n < 3; n++) {
					int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
					if (contained.contains(board[x][y]))
						return false;
					if (board[x][y] > '0' && board[x][y] <= '9')
						contained.add(board[x][y]);
				}
			}

			return true;
		}

		public boolean solveSudoku(char[][] board) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						for (int k = 0; k < 9; k++) {
							board[i][j] = (char) ('1' + k);
							if (isValid(board, i, j) && solveSudoku(board))
								return true;
							board[i][j] = '.';
						}
						return false;
					}
				}
			}
			return true;
		}
	}
}
