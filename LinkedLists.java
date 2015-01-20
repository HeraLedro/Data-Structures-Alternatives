package Structures;

/**
 *
 * @author Jonathan
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
public class LinkedLists {
    public static void main(String[] arge){
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0; i<50; i++){
            list.add((int)(Math.ceil(Math.random()*10001)));
        }
//        System.out.println(list);
//        System.out.println();
        for (int i=0; i<list.size(); i++){
            System.out.print(list.get(i));
            if (i!=list.size()-1){
                System.out.print(" --> ");
            }
            if ((i+1)%10==0){
                System.out.println();
            }
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.addAll(list);
        list.clear();
        System.out.println();
        Collections.sort(list2);
        for (int i=0; i<list2.size(); i++){
            System.out.print(list2.get(i));
            if (i!=list.size()-1){
                System.out.print(" --> ");
            }
            if ((i+1)%10==0){
                System.out.println();
            }
        }
        System.out.println(list);
        LinkedList<Integer> stack = new LinkedList<>();
        list2.stream().forEach((list21) -> {
            stack.push(list21);
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        while(!stack.isEmpty()){
            int pop = stack.pop();
            queue.add(pop);
            System.out.println(pop);
        }
        System.out.println();
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
//        System.out.println(list2);
    }
}
