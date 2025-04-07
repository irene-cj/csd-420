/*Irene Carrillo Jaramillo, April 6, 2025
 *M3 Programming Assignment. This test program will contain a static method
 that returns a new arraylist (with no duplicates).
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

 public class RemovalTest{

    public static void main(String[] args) {
        
        ArrayList<Integer> ogList = generateRandomList(50, 1, 20);

        System.out.println("Original List: " + ogList);

        ArrayList<Integer> noDupList = removeDuplicates(ogList);

        System.out.println("No Duplicate List: " + noDupList);
    }
    
    public static ArrayList<Integer> generateRandomList(int size, int min, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min + 1) + min);
        }
        return list;
    }


    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Using a HashSet to remove duplicates
        return new ArrayList<>(new HashSet<>(list));
    }
}
 