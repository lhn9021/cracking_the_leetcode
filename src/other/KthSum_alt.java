package other;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * 就是两个数组A,B. 是排好序的，a是A中的元素，b是B中的元素，求第k大的sum(a+b)
 * 重复数字算1次
 */
public class KthSum_alt {
	static int[] first = null;
	static int[] second = null;
	static int count = 1;
	static HashMap<Integer, Set<Pair>> map = new HashMap<Integer, Set<Pair>>();
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

	public static ArrayList<Integer> kthsum(int[] a, int[] b, int k) {
		int i = a.length;
		int j = b.length;
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (k == 0 || k > i * j)
			return res;
		Arrays.sort(a);
		Arrays.sort(b);
		if (i == 0) {
			if (k > b.length)
				return res;
			for (int m = 0; k < b.length; k++) {
				res.add(b[k]);
			}
			return res;
		} else if (j == 0) {
			if (k > a.length)
				return res;
			for (int m = 0; k < a.length; k++) {
				res.add(a[k]);
			}
			return res;
		}
		first = a;
		second = b;
		pq.offer(a[a.length - 1] + b[b.length - 1]);
		List<Pair> list = new LinkedList<Pair>();
		Set<Pair> set = new HashSet<Pair>();
		Pair p = createPair(a.length - 1, b.length - 1);
		set.add(p);
		map.put(a[a.length - 1] + b[b.length - 1], set);
		while (count <= k) {
			int min = pq.peek();
			Set<Pair> setInMap = map.get(min);
			for (Pair everyPair : setInMap) {
				if (everyPair.indexA > 0) {
					Pair one = createPair(everyPair.indexA - 1,
							everyPair.indexB);
					addToMap(one);
				}
				if (everyPair.indexB > 0) {
					Pair two = createPair(everyPair.indexA,
							everyPair.indexB - 1);
					addToMap(two);
				}
			}
		}
		while (count > k) {
			removeMap(pq.poll());
		}
		int prev = pq.poll();
		res.add(prev);
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			if (cur != prev) {
				res.add(cur);
				prev = cur;
			}
		}
		return res;

	}

	private static void removeMap(Integer poll) {
		Set<Pair> set = map.get(poll);
		Iterator it = set.iterator();
		Pair m = (Pair) it.next();
		set.remove(m);
		if (set.isEmpty()) {
			count--;
			map.remove(poll);
		}
	}

	private static Pair createPair(int i, int j) {
		return new Pair(i, j, first[i] + second[j]);
	}

	private static void addToMap(Pair pair) {

		if (map.containsKey(pair.sum)) {
			Set<Pair> set = map.get(pair.sum);
			if (!set.contains(pair)) {
				pq.offer(pair.sum);
				set.add(pair);
			}
		} else {
			Set<Pair> set = new HashSet<Pair>();
			set.add(pair);
			map.put(pair.sum, set);
			count++;
			pq.offer(pair.sum);
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 3, 1 };
		int[] b = { 3, 1, 9 };
		System.out.println(kthsum(a, b, 4));
	}
}
