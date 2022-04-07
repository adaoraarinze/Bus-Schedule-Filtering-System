import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.print("Which 2 stops do you want a path between? (or enter quit) ");
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            if (input.hasNextInt()) {
                boolean quit2 = false;
                while(!quit2) {
                    int firstStop = input.nextInt();
                    System.out.print("And the second stop? (or enter quit) ");
                    Scanner input2 = new Scanner(System.in);

                    if (input.hasNextInt()) {
                        int secondStop = input.nextInt();
                    }

                    else if (input.hasNext("quit")) {
                        quit2 = true;
                    }

                    else {
                        System.out.println("Error, enter a valid input or quit.");
                        input.next();
                        System.out.print("Which 2 stops do you want a path between? (or enter quit): ");
                    }
                }

            }

            else if (input.hasNext("quit"))
            {
                quit = true;
            }

            else
            {
                System.out.println("Error, enter a valid input or quit.");
                input.next();
                System.out.print("Which 2 stops do you want a path between? (or enter quit): ");
            }
        }
    }
}
