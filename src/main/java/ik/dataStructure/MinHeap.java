/**
 * 
 */
package ik.dataStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 212393859
 *
 */
public class MinHeap {

	List<Integer> heap = new ArrayList<Integer>();

	public MinHeap(ArrayList<Integer> a) {
		buildHeap(a);
	}

	public MinHeap() {
		
	}

	/**
	 * Builds a max heap from a given input array
	 * @param a
	 */
	public void buildHeap(ArrayList<Integer> a) {
		for (int i = 0; i < a.size(); i++) {
			insertIntoHeap(a.get(i));
		}
	}

	/**
	 * Adds an element to the heap
	 * Algo:
	 * 1. Adds the element at the end
	 * 2. heapifyUp operation
	 */
	public void insertIntoHeap(int value) {

		heap.add(value);
		int i = heap.size();
		heapifyUp(i - 1);
	}

	/**
	 * Deletes the max element from the heap
	 * Algo:
	 * 1. Removes the root element.
	 * 2. Adds the last element as the root
	 * 3. heapifyDown operation
	 */
	public void deleteFromHeap() {

		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);
		int i = 0;
		heapifyDown(i);

	}

	/**
	 * This operation is called when an element is deleted.
	 * Algo :
	 * 1. Compare node to its parent
	 * 		if N < parent  -> swap(parent, node)
	 * Continue doing this till the correct max heap is built or when all nodes are processed
	 * @param index
	 */
	private void heapifyUp(int index) {

		int parentIndex = Math.floorDiv(index - 1, 2);

		while (parentIndex >= 0 && heap.get(parentIndex) > heap.get(index)) {
			int oldParent = heap.get(parentIndex);

			heap.set(parentIndex, heap.get(index));
			heap.set(index, oldParent);

			index = parentIndex;
			parentIndex = Math.floorDiv(index - 1, 2);

		}
	}

	/**
	 * This operation is called when an element is deleted.
	 * Algo :
	 * 1. Compare node to MIN(L,R)
	 * 		if N > MIN(L,R)  -> swap(parent, min(l,r))
	 * Continue doing this till the correct max heap is built or when all nodes are processed
	 * 			
	 * @param i
	 */
	private void heapifyDown(int i) {
		// Check if leaf node
		if (i > heap.size() / 2)
			return;

		int leftChildIdx = 2 * i + 1;
		int rightChildxIdx = 2 * i + 2;
		int minChildIdx = 0;

		int min = heap.get(i);
		if (leftChildIdx < heap.size() && heap.get(leftChildIdx) < min) {
			min = heap.get(leftChildIdx);
			minChildIdx = leftChildIdx;
		}
		if (rightChildxIdx < heap.size() && heap.get(rightChildxIdx) < min) {
			min = heap.get(rightChildxIdx);
			minChildIdx = rightChildxIdx;
		}

		int parent = heap.get(i);

		if (parent > min) {

			heap.set(i, min);
			heap.set(minChildIdx, parent);

			i = minChildIdx;

			heapifyDown(i);

		}

	}

	public List<Integer> getHeap() {
		return heap;
	}

	public void setHeap(List<Integer> heap) {
		this.heap = heap;
	}

}
