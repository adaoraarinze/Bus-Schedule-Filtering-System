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
                    Stops.TSTCreate();
                    Stops.searchStops("CRESCENT");
                    option = 0;
                }

                else if (option == 3) {
                    System.out.print("What time do you want your bus to arrive at? " +
                            "(please format the time as hh:mm:ss): ");
                    Scanner userTime = new Scanner(System.in);
                    String time = "";
                    boolean quit = false;
                    while(!quit) {
                        if (userTime.hasNext()) {
                            time = userTime.next();
                        }

                        ArrayList<String> array = Arrivals.readFile();
                        ArrayList<String> arrayTimes = Arrivals.searchTimes(array, time);

                        if(arrayTimes != null && arrayTimes.size() != 0) {
                            System.out.println("The stops that arrive at " + time + " are listed as follows:");
                            for (String element : arrayTimes) {
                                System.out.println(element);
                            }
                            quit = true;
                        }

                        else if(time.equalsIgnoreCase("quit")){
                            quit = true;
                        }


                        else{
                            System.out.println("Error, you entered an invalid time format or there are no trips that " +
                                    "match that time.");
                            userTime = new Scanner(System.in);
                            System.out.print("What time do you want your bus to arrive at? " +
                                    "(please format the time as hh:mm:ss): ");
                        }
                    }

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
