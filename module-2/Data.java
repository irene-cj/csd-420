/*Irene Carrillo Jaramillo, March 30, 2025
 *M2 Programming Assignment. This program will store an array of five random integers and double values.
 */
import java.io.*;
import java.util.Random;

public class Data{
    public static void main(String[] args) {
        //This will declare the arrays to hold the random integers and double values.
        int[] randomIntegers = new int[5];
        double[] randomDoubles = new double[5];

        Random rand = new Random();

        //This will generate 5 random integers and store them in the randomIntergers array.
        for (int i = 0; i < 5; i++) {
            randomIntegers[i] = rand.nextInt(100);
            randomDoubles[i] = rand.nextDouble() * 100;
        }

        //This defines the file name where the data is gonna be written.
        String filename = "irene_datafile.dat";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            
            //Writes the "Random Integers" label followed by the integers to the file
            writer.write("Random Integers: ");
            for (int num : randomIntegers) {
                writer.write(num + " ");
            }
            writer.newLine();

             //Writes the "Random Doubles" label followed by the double values to the file.
            writer.write("Random Doubles: ");
            for (double num : randomDoubles) {
                writer.write(num + " ");
            }

            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error occurred while writing file.");
            e.printStackTrace();
        }

        System.out.println("Data written to " + filename);
        
    }
}