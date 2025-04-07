/*Irene Carrillo Jaramillo, April 6, 2025
 *M3 Programming Assignment. This test program will contain a static method
 that returns a new arraylist (with no duplicates).
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

 public class RemovalTest{

    public static void main(String[] args) {
        //This will create an arraylist with 50 random integers 1-20.
        ArrayList<Integer> ogList = generateRandomList(50, 1, 20);

        System.out.println("Original List: " + ogList);
        //This arraylist will remove duplicates from the ogList.
        ArrayList<Integer> noDupList = removeDuplicates(ogList);

        System.out.println("No Duplicate List: " + noDupList);
    }
    
    //This method will make a list with random integers between min-max.
    public static ArrayList<Integer> generateRandomList(int size, int min, int max) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        //This will make a random object to make the random numbers.
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max - min + 1) + min);
        }
        //This will return the list.
        return list;
    }


    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        //This HashSet is being used to remove duplicates.
        return new ArrayList<>(new HashSet<>(list));
    }
}
 