/*Irene Carrillo Jaramillo, April 7, 2025
 *M4 Programming Assignment. This test program will store 50,000 integers
 in LinkedList. This will test the time to traverse using iterator vs get(index).
 */

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedTraverseTest {
    
    public static LinkedList<Integer> createList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public static long traverseIterator(LinkedList<Integer> list) {
        long startTime = System.nanoTime();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }

    public static long traverseGet(LinkedList<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000;
    }

    public static void traverseTest(int size) {
        System.out.println("Testing LinkedList traverse with " + size + " elements...\n");

        LinkedList<Integer> list = createList(size);

        long timeIterator = traverseIterator(list);
        long timeGet = traverseGet(list);

        System.out.println("Traversal with Iterator: " + timeIterator + " ms");
        System.out.println("Traversal with get(index): " + timeGet + " ms");
        System.out.println("---\n");
    }


    public static void main(String[] args) {
        traverseTest(50_000);
        traverseTest(500_000);
    }
}
