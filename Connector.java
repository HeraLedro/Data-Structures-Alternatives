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
public class Connector<E> implements Comparable<Connector<E>> {
    private Edge<E> one, two;
    private int distance;
    public Connector(Edge<E> one, Edge<E> two){
        this(one, two, 0);
    }
    public Connector(Edge<E> one, Edge<E> two, int distance){
        this.one = one;
        this.two = two;
        this.distance = distance;
    }

    public Edge<E> getOne() {
        return one;
    }

    public void setOne(Edge<E> one) {
        this.one = one;
    }

    public Edge<E> getTwo() {
        return two;
    }

    public void setTwo(Edge<E> two) {
        this.two = two;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public boolean equals(Connector<E> other){
        return one.equals(other.getOne()) && two.equals(other.getTwo()) && distance==other.getDistance();
    }
    
    public String toString(){
        return "(" + one.getElem() + ", " + two.getElem() + "): " + distance;
    }
    
    @Override
    public int compareTo(Connector<E> other) {
        return this.distance - other.distance;
    }
    
}
