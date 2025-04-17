/*Irene Carrillo Jaramillo, April 13, 2025
 *M5 Programming Assignment. This test program will read words from a text file
 and then display those words in 2 orders, ascending and descending. 
 This program will also remove all non-duplicate words.
 */

 //Importing everything needed to run this program.
 import java.io.*;
 import java.util.*;
 
 public class WordDisplay {
 
     public static void main(String[] args) {
         Set<String> wordSet = readWordsFromFile("collection_of_words.txt");
 
         if (wordSet == null) {
             System.out.println("Failed to read words from file.");
             return;
         }
 
         System.out.println("Ascending Order:");
         for (String word : wordSet) {
             System.out.println(word);
         }
 
         System.out.println("\nDescending Order:");
         List<String> descendingList = new ArrayList<>(wordSet);
         Collections.reverse(descendingList);
         for (String word : descendingList) {
             System.out.println(word);
         }
 
         //This will run the test.
         runTest();
     }
 
     //This is going to read the words from the file and is gonna return a sorted set (no duplicates).
     public static Set<String> readWordsFromFile(String filename) {
         Set<String> wordSet = new TreeSet<>();
         try (Scanner scanner = new Scanner(new File(filename))) {
             while (scanner.hasNext()) {
                 String word = scanner.next().toLowerCase().replaceAll("[^a-z]", "");
                 if (!word.isEmpty()) {
                     wordSet.add(word);
                 }
             }
         } catch (FileNotFoundException e) {
             System.out.println("Error: File '" + filename + "' not found.");
             return null;
         }
         return wordSet;
     }
 
     // Test function to verify functionality
     public static void runTest() {
         System.out.println("\nRunning Test...");
 
         //This is what the expected words are supposed to be from the file.
         Set<String> expected = new TreeSet<>(Arrays.asList(
             "beach", "banana", "blue", "cherry", "coffee", "dog", "earth", "green", 
             "insane", "mango", "money", "music", "redbull", "website"
         ));
 
         Set<String> actual = readWordsFromFile("collection_of_words.txt");
 
         //This is going to check if the words match the file.
         if (actual == null) {
             System.out.println("Test failed: Could not read file.");
         } else if (actual.equals(expected)) {
             
            //If it matches this statement will be printed out.
            System.out.println("YAY Test passed! Words match expected values.");
         } else {

            //This will be displayed if it fails because it doesnt match.
             System.out.println("OOPS Test failed!");
             System.out.println("Expected: " + expected);
             System.out.println("Actual:   " + actual);
         }
     }
 }
 