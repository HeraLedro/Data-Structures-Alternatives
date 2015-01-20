/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;
import java.util.LinkedList;
/**
 *
 * @author Jonathan
 */
public class UnorderedList<T> {
    private int cursor;
    private LinkedList<T> elements;
    
    public UnorderedList(){
        elements = new LinkedList<>();
        cursor = -1;
    }
    public void add(T item){
        elements.add(item);
    }
    public int size(){
        return elements.size();
    }
    public boolean isEmpty(){
        return elements.isEmpty();
    }
    public int contains(T item){
        return elements.indexOf(item);
    }
    public T remove(T item){
        return elements.remove(elements.indexOf(item));
    }
    public T remove(int index){
        return elements.remove(index);
    }
    public void removeAll(T item){
        while(elements.contains(item)){
            elements.remove(item);
        }
    }
    public void clear(){
        elements.clear();
    }
    public String enumerate(){
        return elements.toString();
    }
    public T first(){
        if(elements.isEmpty()){
            return null;
        }
        cursor=0;
        return elements.get(cursor);
    }
    public T next(){
        if(cursor==elements.size()-1 || elements.isEmpty()){
            return null;
        }
        cursor++;
        return elements.get(cursor);
    }
}
