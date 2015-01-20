package Structures;

/**
 *
 * @author Jonathan
 */

import java.util.HashMap;
import java.io.*;
import java.util.Scanner;

public class HashMapDemo {
    public static void main(String[] args) throws IOException{
        HashMap <Integer, String> studentRecord = new HashMap<>();
        Integer id;
        String name;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the filename to read from.");
        String filename = in.nextLine();
        File file = new File(filename);
        try (Scanner inputFile = new Scanner(file)) {
            while (inputFile.hasNext()){
                id = Integer.parseInt(inputFile.next());
                name = inputFile.nextLine();
                studentRecord.put(id, name);
            }
        }
        System.out.println(studentRecord.values());
        System.out.println(studentRecord.keySet());
        
        System.out.print("Enter a key: ");
        id = in.nextInt();
        if (studentRecord.containsKey(id)){
            System.out.println(studentRecord.get(id));
        }
        else{
            System.out.println(id + " not found");
        }
    }
}
