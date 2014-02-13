package leetcode.sumandscan;

/*
 * Given n non-negative integers a1, a2, ..., an, 
 * where each represents a point at coordinate (i, ai). n vertical lines are drawn
 * such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * 
 * http://oj.leetcode.com/problems/container-with-most-water/
 * 
 * Hint: scan from head to tail and update the min height and calculate the area
 * Always moving the index which is the shorter of head and tail. 
 * --The area is determined by min height of two sides and the length from head to tail.
 * And the length is decreasing.
 * So moving the shorter one is always good. (Greedy).
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int l = 0;
		int r = height.length - 1;
		int area = 0;
		//when l==r the area is 0
		while (l < r) {
			int min = height[l] > height[r] ? height[r] : height[l];
			if (min * (r - l) > area) {
				area = min * (r - l);
			}
			if (height[l] <= height[r])
				l++;
			else
				r--;
		}
		return area;
	}
}
