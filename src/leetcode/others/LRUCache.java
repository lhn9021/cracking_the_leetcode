package leetcode.others;

import java.util.HashMap;

/*
 * LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 * http://oj.leetcode.com/problems/lru-cache/
 * 
 * Hint: User linkedhashmap or deque
 */
public class LRUCache {
	// import java.util.LinkedHashMap;
	// import java.util.Map;

	// public class LRUCache<K, V> {

	// private final LinkedHashMap<K, V> cacheMap;

	// public LRUCache(final int cacheSize) {

	// // true = use access order instead of insertion order.
	// this.cacheMap = new LinkedHashMap<K, V>(cacheSize, 0.75f, true) {
	// @Override
	// protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
	// // When to remove the eldest entry.
	// return size() > cacheSize; // Size exceeded the max allowed.
	// }
	// };
	// }

	// public synchronized void put(K key, V elem) {
	// cacheMap.put(key, elem);
	// }

	// public synchronized V get(K key) {
	// return cacheMap.get(key);
	// }

	// public synchronized V atomicGetAndSet(K key, V elem) {
	// V result = get(key);
	// put(key, elem);
	// return result;
	// }
	// }
	private int capacity;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	private Node head = new Node(-1, -1);
	private Node tail = new Node(-2, -2);

	public LRUCache(int capacity) {
		this.capacity = capacity;
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		if (!map.containsKey(key))
			return -1;
		Node cur = map.get(key);
		cur.pre.next = cur.next;
		cur.next.pre = cur.pre;
		attach(cur);
		return cur.value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node cur = map.get(key);
			cur.value = value;
			cur.pre.next = cur.next;
			cur.next.pre = cur.pre;
			attach(cur);
		} else {
			if (map.size() == capacity)
				dettach();
			Node cur = new Node(key, value);
			attach(cur);
			map.put(key, cur);
		}
	}

	public void dettach() {
		Node last = tail.pre;
		last.pre.next = last.next;
		last.next.pre = last.pre;
		map.remove(last.key);
	}

	public void attach(Node cur) {
		cur.next = head.next;
		cur.next.pre = cur;
		head.next = cur;
		cur.pre = head;
	}

	private class Node {
		public Node pre = null;
		public int key;
		public int value;
		public Node next = null;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
