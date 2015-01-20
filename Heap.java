/**
 * @author Jonathan
 * 
 * Due to some issues with my findItem and changePriority methods, I went online
 * to research some tactics for searching and modifying the Heap structure. The
 * following class uses a modified version of the sorting/sifting algorithm that
 * are used for our purposes. It implements a series of methods to directly
 * manipulate the main Heap structure. I based the methods on the class outlined
 * at http://www.cs.dartmouth.edu/~cs10/notes/14/Heapsort.java . Many of the
 * methods were redundant, easily substituted, or inefficient for our purposes,
 * so I made changes to improve on the structure while still maintaining the
 * general structure and purpose of the program.
 */

import java.util.ArrayList;
import java.util.Collections;

public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heapList;
	
	public Heap()
	{
		heapList = new ArrayList<>();
	}
	
	public int size()
	{
		return heapList.size();
	}
	
	public boolean isEmpty()
	{
		return heapList.isEmpty();
	}
	
	public void clear()
	{
		heapList.clear();
	}
	public void enumerate()
	{
		System.out.println(heapList);
	}

        public ArrayList<T> getHeapList() {
            return heapList;
        }

        public void setHeapList(ArrayList<T> heapList) {
            this.heapList = heapList;
        }
	
        /**
         * I removed the sorting tactic and applied the sorting tactic I called
         * below.
         * 
         * @param item
         */
	public void add(T item)
	{
            heapList.add(item);
            heapsort(heapList);
	}
	
        
        /**
         * I find that applying the sort method after deletion is more code-
         * efficient than repeatedly applying the sorting tactic, so I have
         * modified the code to reflect this.
         * 
         * @return T
         */
	public T deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}
		
		else
		{
                    T ret = heapList.remove(0);
                    heapsort(heapList);
                    return ret;
		}
	}
        
        /**
         * Exercise 3
         * 
         * Since the heap is formatted as an ArrayList, we simply need to call
         * the min() method from the Collections class. If the heap is empty
         * then we simply return null.
         * 
         * @return T
         */
        public T findMin(){
            if (isEmpty()){
                System.out.println("Cannot return, empty list.");
                return null;
            }
            else{
                return Collections.min(heapList);
            }
        }
        
        /**
         * Exercise 4
         * 
         * Returns the index of an item. If the list is empty then the object
         * is not to be found and we return -1. We also return -1 if the list is
         * not empty, but the item cannot be found. Otherwise, we call the
         * indexOf function from the ArrayList class to return the index of the
         * item. We cannot achieve an order of complexity less than O(n), as the
         * heap is primarily unordered; there are some objects in the left half
         * that are either greater or less than objects in the right. The best
         * case scenario is that we achieve a n/2 complexity where only one half
         * of the heap is searched, but this is still functionally an O(n) order
         * of complexity.
         * 
         * @param item
         * @return int
         */
        public int findItem(T item){
            if (heapList.isEmpty()){
                return -1;
            }
			
            else{
                return heapList.indexOf(item);
            }
        }
        
        /**
         * Exercise 5
         * 
         * Changes the priority of an object by replacing it with  a second
         * object. If the list does not contain item1, then we simply print a
         * statement. If the list contains item2, then while the list contains
         * item1, we replace all instances of item1 with item2. Afterwards, we
         * call the sort method, which functions recursively to sort the list
         * based on the maximum value of the final leaf nodes and their parent.
         * 
         * @param item1
         * @param item2
         */
        public void changePriority(T item1, T item2){
            if (!heapList.contains(item1)){
                System.out.println("Cannot change, item does not exist.");
            }
            else{
                while(heapList.contains(item1)){
                    heapList.set(heapList.indexOf(item1), item2);
                }
                heapsort(heapList);
            }
        }
        
        
        /**
         * Calls the buildMaxHeap method based on the size of the array.
         */
        private void heapsort(ArrayList<T> list){
            buildMaxHeap(list, size()-1);
        }
        
        /**
         * Creates a Max-Heap for sorting. Calls the maxHeapify method based on
         * the heapList object, the parent node of its last leaves, and the
         * relevant number of nodes.
         */
        private void buildMaxHeap(ArrayList<T> list, int last){
            int lastParent = (last-1)/2;
            for (int i=lastParent; i>=0; i--){
                maxHeapify(list, i, last);
            }
        }
        
        /**
         * Sorts the heap based on the following algorithm:
         * 
         * Identify the left and right children of a parent item in the list.
         * Compare these items to their parent and find the greatest value among
         * them. If the larger value is the left leaf child, then assign this
         * value to a variable max. After this, check the right child; if the
         * right child is larger, then change max to this value; otherwise, do
         * nothing. At the end, check the max; if it is the parent node then we
         * do not need to swap. If it is not the parent node then we swap the
         * max with the parent and recursively call the function until such time
         * as the maximum value becomes the parent node.
         */
        private void maxHeapify(ArrayList<T> list, int i, int last){
            int left = 2*i + 1;
            int right = 2*i + 2;
            int max;
            if (left <=last && list.get(left).compareTo((list.get(i)))>0){
                max = left;
            }
            else{
                max = i;
            }
            if (right <=last && list.get(right).compareTo((list.get(i)))>0){
                max = right;
            }
            if (max!=i){
                swap(list, i, max);
                maxHeapify(list, max, last);
            }
        }
        
        /**
         * A list to swap the necessary objects in the list (for ordering)
         */
        private void swap(ArrayList<T> list, int i, int j){
            T item = list.get(i);
            list.set(i, list.get(j));
            list.set(j, item);
        }
        
        
}