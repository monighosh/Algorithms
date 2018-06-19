/**
 * 
 */
package ik.dataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import org.junit.Test;

/**
 * @author 212393859
 *
 */
public class MinHeapTest {

	@Test
	public void testInsertHeap() {
		ArrayList<Integer> heap = new ArrayList<Integer>(Arrays.asList(40,60,10,20,50,30));

		MinHeap minHeap = new MinHeap(heap);

		minHeap.insertIntoHeap(45);
		


	}
	
	@Test
	public void testBuildHeap() {
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(40,60,10,20,50,30));

		MinHeap minHeap = new MinHeap(array);

	}

	@Test
	public void testDeleteFromHeap() {

		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(40, 18, 20, 15, 13, 9, 19, 1, 3, 8));

		MinHeap minHeap = new MinHeap(array);

		//minHeap.deleteFromHeap();
	}
	
	@Test
	public void testTopKNos(){
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(1, 5, 1, 5, 1));
		int k = 3 ;
		MinHeap minHeap = new MinHeap();
		Set<Integer> set = new HashSet<Integer>();
		for(Integer i : array){
			if(minHeap.getHeap().size() < k){
				if(set.add(i)){
					minHeap.insertIntoHeap(i);
				}
					
				
			}
			else {
				if(minHeap.getHeap().get(0) < i){
					minHeap.deleteFromHeap();
					minHeap.insertIntoHeap(i);
				}
			}
		}
		System.out.println("Top "+k+" elements are: ");
		for(int i =0;i<k;i++){
			System.out.println(minHeap.getHeap().get(i));
		}
		
		
		
	}
	
//	@Test
//	public void topK() {
//		
//		int[] arr = new int[]{11,4,8,9,6,6,2,10,2,8,1,2};
//		int k = 9;
//        int[] result;
//        PriorityQueue pQueue = new PriorityQueue();
//        //pQueue.addAll(Arrays.asList(arr));
//        Set<Integer> set = new HashSet<Integer>();
//        for(int no : arr){
//        	if(!set.contains(no)){
//            if(pQueue.size() < k){
//                set.add(no);
//                    pQueue.add(no);
//                
//            }
//            else {
//                if((Integer)pQueue.peek() < no){
//                    pQueue.remove(pQueue.peek());
//                    set.add(no);
//                    pQueue.add(no);
//                }
//            }
//        	}
//        }
//        
//       Object[] topKElements =  pQueue.toArray();
//       result = new int[topKElements.length];
//        for(int i = 0; i< topKElements.length ; i++) {
//         
//            result[i] = (Integer)topKElements[i];
//        }
//        
//       
//    }
	
	@Test
	public void mergeArrays() {
        int[][] arr = new int[][]{ {1, 3, 5, 7},{2, 4, 6, 8},{0, 9, 10, 11}} ;
          int k = arr.length;
          int n = arr[0].length;
          int[] processArray = new int[k];
          int  processArrayCount = k;
          int[] result = new int[k*n];
          int resultIdx = 0;
          
          while(processArrayCount > 0){
              int min = Integer.MAX_VALUE;
              int minIndex = -1;
              for(int i = 0;i<processArray.length;i++){
                  int processArrayNo = processArray[i];
                  
                  if(processArrayNo < n){
                    if(arr[i][processArray[i]] < min) {
                        min = arr[i][processArray[i]];
                        minIndex = i;
                    }
                  }
              }
              
              int indexValue = processArray[minIndex];
              processArray[minIndex] = ++indexValue;
              result[resultIdx] = min;
              resultIdx++;
              
              if(indexValue == n)
                processArrayCount --;
                
            
          }
          
	}
}
