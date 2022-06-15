package queues;

import java.util.Arrays;

public class SimpleQueue extends Queue {
	
	/**
	 * @invar | elements != null
	 * @invar | Arrays.stream(elements).allMatch(e -> e != null)
	 * 
	 * @representationObject
	 */
	private Object[] elements = new Object[0];
	
	public int size() { return elements.length; }
	
	public Object[] toArray() { return elements.clone(); }
	
	/**
	 * @post | size() == 0
	 */
	public SimpleQueue() {}
	
	public void enqueue(Object element) {
		if (element == null)
			throw new IllegalArgumentException("`element` is null");
		
		Object[] newElements = new Object[elements.length + 1];
		for (int i = 0; i < elements.length; i++)
			newElements[i] = elements[i];
		newElements[elements.length] = element;
		elements = newElements;
	}
	
	public Object dequeue() {
		Object result = elements[0];
		Object[] newElements = new Object[elements.length - 1];
		for (int i = 0; i < newElements.length; i++)
			newElements[i] = elements[i + 1];
		elements = newElements;
		return result;
	}

}
