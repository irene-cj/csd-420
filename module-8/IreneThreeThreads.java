/*Irene Carrillo Jaramillo, May 18, 2025
 *M8 Programming Assignment REDO FOR M12. This program will display a minimum of 10,000 for each of the three sets.
 There will be three threads.
 */

 //This will import everything needed for the program to run.
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class IreneThreeThreads extends JFrame {
    private static final int CHARACTER_COUNT = 10000;
    private JTextArea textArea;

    //This is so everything can be displayed in the window.
    public IreneThreeThreads() {

        //This is a title for the output.
        setTitle("IreneThreeThreads Output");
        setSize(800, 600);

        //This just makes sure that the application closes when the window does.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced" , Font.PLAIN, 12));
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        setVisible(true);

        startThreads();
    }

        //This method is going to have all three threads generate random things.
    private void startThreads() {
        Thread lettersThread = new Thread(new LetterGenerator());
        Thread numbersThread = new Thread(new NumberGenerator());
        Thread symbolsThread = new Thread(new SymbolGenerator());

        //This is going to start the letter, number and symbol generating threads.
        lettersThread.start();
        numbersThread.start();
        symbolsThread.start();
    }
     // Append text to the area in a thread-safe way
     private void appendToTextArea(String text) {
        SwingUtilities.invokeLater(() -> textArea.append(text));
    }

    class LetterGenerator implements Runnable {
        private final Random rand = new Random();

        public void run() {
            for (int i = 0; i < CHARACTER_COUNT; i++) {
                char letter = (char) (rand.nextInt(26) + 'a');
                appendToTextArea(Character.toString(letter));
            }
        }
    }

    class NumberGenerator implements Runnable {
        private final Random rand = new Random();

        public void run() {
            for (int i = 0; i < CHARACTER_COUNT; i++) {
                char digit = (char) (rand.nextInt(10) + '0');
                appendToTextArea(Character.toString(digit));
            }
        }
    }

    class SymbolGenerator implements Runnable {

        //This is an array of symbols that can get chosen.
        private final char[] symbols = {'!', '@', '#', '$', '%', '&', '*'};
        private final Random rand = new Random();

        public void run() {

            //This loop will generate and display 10,000 random symbols.
            for (int i = 0; i < CHARACTER_COUNT; i++) {
                char symbol = symbols[rand.nextInt(symbols.length)];
                appendToTextArea(Character.toString(symbol));
            }
        }
    }

    //This will test the code.
    public static void main(String[] args) {
        SwingUtilities.invokeLater(IreneThreeThreads::new);
    }
}