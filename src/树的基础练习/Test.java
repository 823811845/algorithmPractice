package Ê÷µÄ»ù´¡Á·Ï°;

import java.util.TreeSet;

public class Test {
    public static void main(String args[]) {
        // Create a tree set
        TreeSet<String> ts = new TreeSet();
        // Add elements to the tree set
        ts.add("C");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");
        ts.add("D");
        for (String str : ts) {
            System.out.println(str);
        }
        System.out.println(ts);
    }
}
