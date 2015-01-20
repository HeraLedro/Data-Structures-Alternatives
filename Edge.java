/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;
import java.util.*;
/**
 *
 * @author Jonathan
 */
public class Edge<E> {
    private static int ID = 0;
    private E elem;
    private int id;
    private int weight;
    private LinkedList<Connector<E>> pointers;
    
    public Edge(){
        this(null, Integer.MAX_VALUE);
    }
    public Edge(E elem, int distance){
        this.elem = elem;
        id = ID++;
        pointers = new LinkedList<>();
        this.weight = distance;
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Edge.ID = ID;
    }

    public E getElem() {
        return elem;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LinkedList<Connector<E>> getPointers() {
        return pointers;
    }

    public void setPointers(LinkedList<Connector<E>> pointers) {
        this.pointers = pointers;
    }
    public void sortConnections(){
        Collections.sort(pointers);
    }
    public Iterator<Connector<E>> iterator(){
        return pointers.iterator();
    }
    
    public void connectTo(Edge<E> other){
        Connector<E> c = new Connector<>(this, other);
        if(!pointers.contains(c)){
            pointers.add(c);
        }
        LinkedList<Connector<E>> conn = other.getPointers();
        if (!conn.contains(c)){
            conn.add(c);
        }
    }
    
}
