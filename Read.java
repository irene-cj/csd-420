/*Irene Carrillo Jaramillo, March 30, 2025
 * M2 Programming Assignment, This program reads and displays the data.
 */

import java.io.*;

public class Read {
    public static void main(String[] args) {

        //This defines the filename where the data will be read.
        String filename = "irene_datafile.dat";

        //This Try-with-resources statement is there to read the file using BufferedReader.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            //This will read each line in the file as well ad display it.
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
             //This handles any IO exceptions that may occur during file reading.
            System.out.println("Error occurred while reading the file.");
            e.printStackTrace();
        }
        
    }
    
}
