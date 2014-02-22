package otehr;
class Pair {
	int indexA;
	int indexB;
	int sum;

	Pair(int a, int b,int sum) {
		this.indexA = a;
		this.indexB = b;
		this.sum=sum;
	}

	@Override
	public boolean equals(Object other) {
		if (other == null)
			return false;
		if (other instanceof Pair) {
			Pair pair = (Pair) other;
			if (this.indexA == pair.indexA && this.indexB == pair.indexB&&sum==pair.sum)
				return true;
		}
		return false;

	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash = indexA + 31 * indexB;
		return hash;
	}
}
