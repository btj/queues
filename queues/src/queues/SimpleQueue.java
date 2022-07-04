package queues;

import java.util.Arrays;
import java.util.LinkedList;

public class SimpleQueue extends Queue {
	
	/**
	 * @invar | elements != null
	 * @invar | elements.stream().allMatch(e -> e != null)
	 * 
	 * @representationObject
	 */
	private LinkedList<Object> elements = new LinkedList<>();
	
	public int size() { return elements.size(); }
	
	public Object[] toArray() { return elements.toArray(); }
	
	/**
	 * @post | size() == 0
	 */
	public SimpleQueue() {}
	
	public void enqueue(Object element) {
		if (element == null)
			throw new IllegalArgumentException("`element` is null");
		
		elements.add(element);
	}
	
	public Object dequeue() {
		return elements.removeFirst();
	}

}
