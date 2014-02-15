package leetcode.others;

import java.util.HashMap;
import java.util.Map;

/*
 * Max Points on a Line
 * 
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * http://oj.leetcode.com/problems/max-points-on-a-line/
 * 
 * Hint: Iterate all points and find the max points on a line. There could be multiple same points
 */
public class MaxPointsOnALine {

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public class Solution {
		public int maxPoints(Point[] points) {
			int maxCount = 0;
			int sameCount = 0;
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			for (Point pi : points) {
				map.clear();
				sameCount = 0;
				for (Point pj : points) {
					if (pi.x == pj.x && pi.y == pj.y) {
						sameCount++;
						continue;
					}
					double slope = Double.NaN;
					if (pi.x != pj.x)
						slope = (pi.y - pj.y) * 1d / (pi.x - pj.x);
					increase(map, slope);
				}
				maxCount = Math.max(maxCount, sameCount);
				for (int v : map.values())
					maxCount = Math.max(maxCount, v + sameCount);
			}
			return maxCount;
		}

		private int increase(Map<Double, Integer> map, double d) {
			int val = 1;
			if (map.containsKey(d)) {
				val = map.get(d) + 1;
			}
			map.put(d, val);
			return val;
		}
	}
}
