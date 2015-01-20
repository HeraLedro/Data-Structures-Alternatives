package Structures;

/**
 *
 * @author Jonathan
 * 
 * Sorts an unsorted ArrayList by taking the average of the list** and
 * finding a halfway point. We then create two empty MinHeaps and iterate through
 * the list; anything less than the halfway point will be added to one minHeap
 * and anything greater than the halfway point will be added to the other. We
 * then combine these into a single ArrayList.
 * 
 * ** - We take the average because it requires only a single iteration through
 * the list; finding the max and min and a halfway point will require two
 * iterations
 */

import java.util.ArrayList;
public class CustomSort {
    public static void main(String[] args){
        ArrayList<Integer> unsorted = new ArrayList<>();
//        Worst case scenario: we have to read the list and cannot increment a
//        sum while we create the list. In this case we would have to create a
//        sum value and add to it after creating the list. For our purposes,
//        we will assume that we may access the list as items are added to it.
        
//        For loop: order n (O(n))
        int sum = 0;
        for (int i=0; i<100; i++){
            Integer item = (int)Math.ceil(Math.random()*10001);
            unsorted.add(item);
            sum += item;
        }
        System.out.println(unsorted);
        
        System.out.println(newMergeSort(unsorted, sum));
        /**
         * Final O(n) = n + nlog(n) + N -> O(nlog(n)) (Worst Case scenario)
         */
    }
    
    public static ArrayList newMergeSort(ArrayList<Integer> unsorted, int sum){
        
        int av = sum/unsorted.size();
//        Note: using the latest version of the JDK, so object identifiers in
//        the second set of <>-braces in the declaration are unnecessary.
        MinHeap<Integer> min = new MinHeap<>();
        MinHeap<Integer> max = new MinHeap<>();
        
//        Add anything smaller than the average to the min minHeap; add anything
//        larger than the average to the max minHeap.
//        Stream: order nlog(n) (O(nlog(n))) due to the sorting of data while
//        added to the heap.
        unsorted.stream().forEach((unsorted1) -> {
            if (unsorted1 < av) {
                min.add(unsorted1);
            } else {
                max.add(unsorted1);
            }
        });
        
        ArrayList<Integer> sorted = new ArrayList<>();
//        While loops: order N (N = size of each heap) (O(N))
        while(!min.isEmpty()){
            sorted.add(min.deleteMin());
        }
        while(!max.isEmpty()){
            sorted.add(max.deleteMin());
        }
        return sorted;
    }
}
