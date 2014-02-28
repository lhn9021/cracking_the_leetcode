package other;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeHashMap<K, V> extends HashMap<K,V> {

	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private final Lock read = readWriteLock.readLock();

	private final Lock write = readWriteLock.writeLock();

	public ThreadSafeHashMap(){
		super();
	}
	
	@Override
	public V put(K key, V value) {
		write.lock();
		try {
			super.put(key,value);
		} finally {
			write.unlock();
		}
		return value;
	}
	
	@Override
	public V get(Object key) {
		read.lock();
		try {
			return super.get(key);
		} finally {
			read.unlock();
		}
	}
}