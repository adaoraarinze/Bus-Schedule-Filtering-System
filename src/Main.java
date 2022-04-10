import java.io.FileNotFoundException;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        boolean end = false;
        int option=0;
        while(!end) {
            System.out.print("""
                    Choose between:
                     1) Finding the shortest path between 2 stops
                     2) Finding a stop by searching its name
                     3) Searching for trips by their arrival time.
                    (type 1, 2, 3 or quit to exit the program.)\s""");
            Scanner inputs = new Scanner(System.in);

            if (inputs.hasNextInt()) {
                option = inputs.nextInt();
            }

                if (option == 1 ) {
                    System.out.print("Which 2 stops do you want a path between? (or enter quit) ");
                    Scanner input = new Scanner(System.in);
                    boolean quit = false;
                    while (!quit) {
                        if (input.hasNextInt()) {
                            boolean quit2 = false;
                            while (!quit2) {

                                int firstStop = input.nextInt();
                                System.out.print("And the second stop? (or enter quit) ");
                                Scanner input2 = new Scanner(System.in);

                                if (input.hasNextInt()) {
                                    int secondStop = input2.nextInt();
                                    Sorts.TSTCreate();
                                    quit = true;
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

                        } else if (input.hasNext("quit")) {
                            quit = true;
                        } else {
                            System.out.println("Error, enter a valid input or quit.");
                            input.next();
                            System.out.print("Which 2 stops do you want a path between? (or enter quit): ");
                        }
                    }
                    option = 0;
                }

                else if (option == 2) {
                    System.out.println("okie");
                    option = 0;
                }

                else if (option == 3) {
                    System.out.println("ok");
                    option = 0;
                }

                else if (inputs.hasNext("quit")) {
                    end = true;
                }

                else {
                    System.out.println("Error, enter a valid input or quit.");
                    inputs.next();
                }
        }
    }
}
