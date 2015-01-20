/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author Jonathan
 */

import java.util.ArrayList;
import java.util.Collections;
public class OrderedList<T extends Comparable<T>> {
    private ArrayList<T> elements;
    private int cursor;
    
    public OrderedList(){
        elements = new ArrayList<>();
        cursor = -1;
    }
    public OrderedList(int cap){
        elements = new ArrayList<>(cap);
        cursor = -1;
    }
    
    public int size(){
        return elements.size();
    }
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    
    public void clear(){
        elements.clear();
    }
    
    public T get(int pos){
        if (pos <0 || pos >= elements.size()){
            System.out.println("Index out of bounds.");
            return null;
        }
        return elements.get(pos);
    }
    
    public T first(){
        if (elements.isEmpty()){
            return null;
        }
        cursor = 0;
        return elements.get(cursor);
    }
    public T next(){
        if (cursor < 0 || cursor >= elements.size()){
            return null;
        }
        cursor++;
        return elements.get(cursor);
    }
    
    public void enumerate(){
        System.out.println(elements);
    }
    public void add(int pos, T item){
        elements.add(pos, item);
    }
    
    public int binarySearch(T item){
        if (isEmpty()){
            return -1;
        }
        else{
            int lo = 0, hi = elements.size()-1, mid = (lo+hi)/2, index = -1;
            while (lo <= hi && index!=mid){
                mid = (lo+hi)/2;
                int c = item.compareTo(elements.get(mid));
                if (c==0){
                    index = mid;
                }
                else if (c<0){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            return index;
        }
    }
    
    public void insert(T item){
        if (isEmpty()){
            elements.add(item);
        }
        Collections.sort(elements);
    }
    
    public void remove(T item){
        int pos = binarySearch(item);
        if (pos < 0){
            System.out.println("No such element.");
        }
        else{
            elements.remove(pos);
        }
    }
}
