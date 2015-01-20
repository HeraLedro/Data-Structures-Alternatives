/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Structures;

/**
 *
 * @author Jonathan
 * @param <T>
 */
public class BinarySearchTree <T extends Comparable<T>> {
    private BinaryTree<T> tree;
    private int size;
    
    public BinarySearchTree(){
        tree = new BinaryTree<>();
        size = 0;
    }
    
    public BinaryTree<T> getTree(){
        return tree;
    }
    public boolean isEmpty(){
        return tree.isEmpty();
    }
    public int size(){
        return size;
    }
    public BinaryTree<T> search(T key){
        BinaryTree<T> t = tree;
        if (size==0){
            return null;
        }
        while(t!=null){
            if (key.compareTo(t.getData())<0){
                t = t.getLeft();
            }
            else if (key.compareTo(t.getData()) > 0){
                t = t.getRight();
            }
            else{
                return t;
            }
        }
        return null;
    }
    
    public void insert(T item){
        BinaryTree<T> newNode = new BinaryTree<>();
        newNode.setData(item);
        
        if (size==0){
            tree = newNode;
            size++;
            return;
        }
        BinaryTree<T> t = tree;
        boolean done = false;
        while(!done){
            int c = item.compareTo(t.getData());
            if (c==0){
                System.out.println("Duplicate key, cannot insert.");
                return;
            }
            else if (c<0){
                if (t.getLeft()==null){
                    t.setLeft(newNode);
                    newNode.setParent(t);
                    size++;
                    done = true;
                }
                else{
                    t = t.getLeft();
                }
            }
            else{
                if (t.getRight()==null){
                    t.setRight(newNode);
                    newNode.setParent(t);
                    size++;
                    done = true;
                }
                else{
                    t = t.getRight();
                }
            }
        }
    }
    public BinaryTree<T> findPredecessor(BinaryTree<T> node){
        if (node == null || node.getLeft()==null){
            return null;
        }
        BinaryTree<T> pred = node.getLeft();
        while(pred.getRight()!=null){
            pred = pred.getRight();
        }
        return pred;
    }
    
    public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach){
        if (deleteNode==null){
            return;
        }
        BinaryTree<T> parent = deleteNode.getParent();
        if (parent==null){
            return;
        }
        if (attach==null){
            if (parent.getLeft()==deleteNode){
                parent.setLeft(null);
            }
            else{
                parent.setRight(null);
            }
            return;
        }
        if (deleteNode==parent.getRight()){
            parent.detachRight();
            attach.setParent(null);
            parent.attachRight(attach);
        }
        else{
            parent.detachLeft();
            attach.setParent(null);
            parent.attachLeft(attach);
        }
        deleteNode.clear();
    }
    
//    Delete method here
}
