/*Irene Carrillo Jaramillo, April 7, 2025
 *M4 Programming Assignment. This test program will store 50,000 integers
 in LinkedList. This will test the time to traverse using iterator vs get(index).
 */

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedTraverseTest{

    //This method will fill a LinkedList with integers.
    public static LinkedList<Integer> createList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        //This will return the list.
        return list;
    }

    //This traverse using iterator and will give return time.
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

        //This will convert it to ms.
        return (endTime - startTime) / 1_000_000;
    }

    public static void traverseTest(int size) {
        System.out.println("Testing LinkedList traverse with " + size + " elements...\n");

        LinkedList<Integer> list = createList(size);

        long timeIterator = traverseIterator(list);
        long timeGet = traverseGet(list);

        //This will print it all out.
        System.out.println("Traversal with Iterator: " + timeIterator + " ms");
        System.out.println("Traversal with get(index): " + timeGet + " ms");
        System.out.println("---\n");
    }


    public static void main(String[] args) {

        //This will test it with 50,000 integers.
        traverseTest(50_000);
        //This will test with 500,000 integers.
        traverseTest(500_000);
    }
}

/*
Explanation:
When using an iterator to traverse the LinkedList, the performance is much faster compared to using get(index).
This is because LinkedList does not provide constant-time access by index. Each call to get(i) takes O(i) time
since it has to walk through the list from the beginning each time. So looping through it with get(i) results in
an O(n^2) operation. In contrast, using an iterator is O(n), making it significantly more efficient especially
as the list size grows. This is why the get(index) method is much slower with 500,000 elements.
*/