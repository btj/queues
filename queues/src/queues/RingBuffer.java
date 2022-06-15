package queues;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RingBuffer extends Queue {
	
	/**
	 * @invar | 0 <= start
	 * @invar | start < elements.length
	 * @invar | 0 <= size
	 * @invar | size <= elements.length
	 * @invar | IntStream.range(0, elements.length).allMatch(i -> (elements[(start + i) % elements.length] != null) == (i < size))
	 * 
	 * @representationObject
	 */
	private Object[] elements = new Object[3];
	private int start;
	private int size;
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public Object[] toArray() {
		Object[] result = new Object[size];
		if (start + size <= elements.length)
			System.arraycopy(elements, start, result, 0, size);
		else {
			int sizeFirstPart = elements.length - start;
			System.arraycopy(elements, start, result, 0, sizeFirstPart);
			System.arraycopy(elements, 0, result, sizeFirstPart, size - sizeFirstPart);
		}
		return result;
	}
	
	/**
	 * @post | size() == 0
	 */
	public RingBuffer() {}
	
	@Override
	public void enqueue(Object element) {
		if (element == null)
			throw new IllegalArgumentException("`element` is null");
		
		if (elements.length == size) {
			elements = Arrays.copyOf(toArray(), size * 2);
			start = 0;
		}
		
		elements[(start + size++) % elements.length] = element; 
	}
	
	@Override
	public Object dequeue() {
		Object result = elements[start];
		elements[start] = null;
		start = (start + 1) % elements.length;
		size--;
		return result;
	}

}
