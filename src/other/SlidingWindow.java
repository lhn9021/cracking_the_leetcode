package other;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
/*
 * http://leetcode.com/2011/01/sliding-window-maximum.html
 * 
 * A long array A[] is given to you. 
 * There is a sliding window of size w which is moving from the very left of the array to the very right. 
 * You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position. 
 * Following is an example:
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.
 */
public class SlidingWindow {
	public static void findMax(int[] A, int n, int w, int[] B) {
		Deque<Integer> deque = new LinkedList<Integer>();
		for (int i = 0; i < w; i++) {
			while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}
		for (int i = w; i < n; i++) {
			B[i - w] = A[deque.peekFirst()];
			while (!deque.isEmpty() && A[deque.peekLast()] < A[i]) {
				deque.pollLast();
			}
			while (!deque.isEmpty() && deque.peekFirst() <= i - w) {
				deque.pollFirst();
			}
			deque.offerLast(i);
		}
		B[n - w] = A[deque.peekFirst()];
	}
	public static void main(String[] args) {
		int[] A = { 10, 75, 67, 53, 67, 42, 41, 38, 41, 3, 30 };
		int[] B = new int[A.length - 4];
		findMax(A, A.length, 5, B);
		System.out.println(Arrays.toString(B));
	}
}
