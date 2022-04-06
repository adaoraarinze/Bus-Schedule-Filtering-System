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
                int stops = input.nextInt();
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
