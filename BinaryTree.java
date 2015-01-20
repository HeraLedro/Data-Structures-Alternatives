package Structures;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Jonathan
 * @param <T>
 */
public class BinaryTree<T> {
    private T data;
    private BinaryTree<T> parent;
    private BinaryTree<T> left;
    private BinaryTree<T> right;
    
    public BinaryTree(){
        parent = left = right = null;
        data = null;
    }
    
    public Boolean isEmpty(){
        return data==null;
    }
    public void clear(){
        left = right = parent = null;
        data = null;
    }
    public void makeRoot(T data){
        if (!isEmpty()){
            System.out.println("Root already exists, cannot make root.");
        }
        else{
            this.data = data;
        }
    }
    public void setData(T data){
        this.data = data;
    }
    public void setLeft(BinaryTree<T> tree){
        left = tree;
    }
    public void setRight(BinaryTree<T> tree){
        right = tree;
    }
    public void setParent(BinaryTree<T> tree){
        parent = tree;
    }
    
    public T getData(){
        return data;
    }
    public BinaryTree<T> getParent(){
        return parent;
    }
    public BinaryTree<T> getRight(){
        return right;
    }
    public BinaryTree<T> getLeft(){
        return left;
    }
    
    public int nodeCount(){
        int count = 0;
        if (left==null){
            return 1;
        }
        if (right==null){
            return 1;
        }
        else{
            return count = (1+ left.nodeCount() + right.nodeCount());
        }
    }
    
    public int getHeight(){
        int height = 0;
        if (left==null){
            return 1;
        }
        if (right==null){
            return 1;
        }
        else{
            int countLeft = left.getHeight();
            int countRight = right.getHeight();
            return height = 1+(Math.max(countRight, countLeft));
        }
    }
    
    public static<T> int balance(BinaryTree<T> tree){
        if (tree==null){
            return -1;
        }
        int checkLeft = balance(tree.getLeft());
        if (checkLeft == -1){
            return -1;
        }
        int checkRight = balance(tree.getRight());
        if (checkRight == -1){
            return -1;
        }
        if (Math.abs(checkLeft - checkRight) > 1){
            return -1;
        }
        else{
            return (1 + Math.max(checkLeft, checkRight));
        }
    }
    
    public void attachLeft(BinaryTree<T> tree){
        if (tree==null || left!=null || tree.getParent()!=null){
            System.out.println("Cannot attach.");
        }
        else{
            tree.setParent(this);
            this.setLeft(tree);
        }
    }
    public void attachRight(BinaryTree<T> tree){
        if (tree==null || right!=null || tree.getParent()!=null){
            System.out.println("Cannot attach.");
        }
        else{
            tree.setParent(this);
            this.setRight(tree);
        }
    }
    
    public BinaryTree<T> detachLeft(){
        if (isEmpty()){
            return null;
        }
        BinaryTree<T> retLeft = this.getLeft();
        left = null;
        if (retLeft!=null){
            retLeft.setParent(null);
        }
        return retLeft;
    }
    public BinaryTree<T> detachRight(){
        if (isEmpty()){
            return null;
        }
        BinaryTree<T> retRight = this.getRight();
        left = null;
        if (retRight!=null){
            retRight.setParent(null);
        }
        return retRight;
    }
    public BinaryTree<T> root(){
        if (parent==null){
            return this;
        }
        else{
            BinaryTree<T> next = parent;
            while (next.getParent()!=null){
                next = next.getParent();
            }
            return next;
        }
    }
    
    public static<T> void preorder(BinaryTree<T> tree){
        if (tree!=null){
            System.out.println(tree.getData() + " ");
            preorder(tree.getLeft());
            preorder(tree.getRight());
        }
    }
    
    public static<T> void inorder(BinaryTree<T> tree){
        if (tree!=null){
            inorder(tree.getLeft());
            System.out.println(tree.getData() + " ");
            inorder(tree.getRight());
        }
    }
    
    public static<T> void postorder(BinaryTree<T> tree){
        if (tree!=null){
            postorder(tree.getLeft());
            postorder(tree.getRight());
            System.out.println(tree.getData() + " ");
        }
    }
    
    public static<T> void levelOrder(BinaryTree<T> tree){
        ArrayList<BinaryTree<T>> list = new ArrayList<>();
        if (tree==null){
            return;
        }
        list.add(tree);
        while (!list.isEmpty()){
            BinaryTree<T> next = list.remove(0);
            System.out.print(next.getData() + "  ");
            if(next.getLeft()!=null){
                list.add(next.getLeft());
            }
            if (next.getRight()!=null){
                list.add(next.getRight());
            }
        }
    }
}
