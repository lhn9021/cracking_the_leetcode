package other;
import java.util.ArrayList;

public class topKprime {
	public static ArrayList<Integer> createPrimeList(int k) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (k <= 1)
			return res;
		res.add(2);
		if (k == 2)
			return res;
		for (int i = 3; i <= k; i += 2) {
			int j;
			for (j = 0; j < res.size(); j++) {
				if (i % res.get(j) == 0) {
					break;
				}
			}
			if (j==res.size()) {
				res.add(i);
			}
		}
		return res;
	}

	public static ArrayList<Integer> createNPrimeList(int n) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (n < 1)
			return res;
		res.add(2);
		if (n == 1)
			return res;
		while (res.size() < n) {
			for (int i = 3;; i += 2) {
				int j;
				for (j = 0; j < res.size(); j++) {
					if (i % res.get(j) == 0) {
						break;
					}
				}
				if (j==res.size()) {
					res.add(i);
				}
				if (res.size() == n) {
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		System.out.println(createPrimeList(100));
		ArrayList<Integer> res = createNPrimeList(100);
		System.out.println(res);
		System.out.println(res.size());
	}
}
