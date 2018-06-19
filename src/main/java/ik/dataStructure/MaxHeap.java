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
public class MaxHeap {

	List<Integer> heap = new ArrayList<Integer>();

	public MaxHeap(ArrayList<Integer> a) {
		buildHeap(a);
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
	 * 		if N > parent  -> swap(parent, node)
	 * Continue doing this till the correct max heap is built or when all nodes are processed
	 * @param index
	 */
	private void heapifyUp(int index) {

		int parentIndex = Math.floorDiv(index - 1, 2);

		while (parentIndex >= 0 && heap.get(parentIndex) < heap.get(index)) {
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
	 * 1. Compare node to MAX(L,R)
	 * 		if N < MAX(L,R)  -> swap(parent, max(l,r))
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
		int maxChildIdx = 0;

		int max = heap.get(i);
		if (leftChildIdx < heap.size() && heap.get(leftChildIdx) > max) {
			max = heap.get(leftChildIdx);
			maxChildIdx = leftChildIdx;
		}
		if (rightChildxIdx < heap.size() && heap.get(rightChildxIdx) > max) {
			max = heap.get(rightChildxIdx);
			maxChildIdx = rightChildxIdx;
		}

		int parent = heap.get(i);

		if (parent < max) {

			heap.set(i, max);
			heap.set(maxChildIdx, parent);

			i = maxChildIdx;

			heapifyDown(i);

		}

	}

}
