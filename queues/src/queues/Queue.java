package queues;

import java.util.Arrays;

/**
 * @invar | toArray() != null
 * @invar | Arrays.stream(toArray()).allMatch(e -> e != null)
 */
public abstract class Queue {

	/**
	 * @inspects | this
	 * @post | result == toArray().length
	 */
	public abstract int size();
	
	/**
	 * @inspects | this
	 * @creates | result
	 */
	public abstract Object[] toArray();
	
	/**
	 * @throws IllegalArgumentException | element == null
	 * 
	 * @mutates | this
	 * 
	 * @post | size() == old(size()) + 1
	 * @post | Arrays.equals(toArray(), 0, old(size()), old(toArray()), 0, old(size()))
	 * @post | toArray()[old(size())] == element 
	 */
	public abstract void enqueue(Object element);
	
	/**
	 * @pre | size() > 0
	 * 
	 * @mutates | this
	 * 
	 * @post | size() == old(size()) - 1
	 * @post | Arrays.equals(toArray(), 0, size(), old(toArray()), 1, old(size()))
	 * @post | result == old(toArray())[0]
	 */
	public abstract Object dequeue();
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Queue q && Arrays.equals(toArray(), q.toArray());
	}

}
