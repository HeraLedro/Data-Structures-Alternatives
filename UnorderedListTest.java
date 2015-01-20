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
public class UnorderedListTest {
    public static void main(String[] args){
        UnorderedList<String> list1 = new UnorderedList<>();
        for (int i=0; i<100; i++){
            list1.add(Math.ceil(Math.random()*100) + "");
        }
        System.out.println(list1.enumerate());
        UnorderedList<String> list2 = new UnorderedList<>();
        for (int i=0; i<100; i++){
            list2.add(Math.ceil(Math.random()*100) + 100 + "");
        }
        System.out.println(list2.enumerate());
        UnorderedList concatenated;
        concatenated = concat(list1, list2);
        System.out.println(concatenated.enumerate());
    }
    
    public static UnorderedList concat(UnorderedList list1, UnorderedList list2){
        UnorderedList cat = new UnorderedList<>();
        while(!list1.isEmpty()){
            cat.add(list1.remove(0));
        }
        while(!list2.isEmpty()){
            cat.add(list2.remove(0));
        }
        if(cat.isEmpty()){
            System.out.println("Result is an empty list.");
        }
        return cat;
    }
}
