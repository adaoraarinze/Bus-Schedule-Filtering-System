import java.util.*;
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
                    System.out.print("What is the first stop that you want a path between? (or enter quit): ");
                    Scanner input = new Scanner(System.in);
                    boolean quit = false;
                    while (!quit) {
                        if (input.hasNextInt()) {

                                int firstStop = input.nextInt();
                                ArrayList<String> stopList = Paths.readFile();
                                if(Paths.isStop(stopList, String.valueOf(firstStop))) {
                                    System.out.print("And the second stop? (or enter quit): ");
                                    input = new Scanner(System.in);

                                    if (input.hasNextInt()) {
                                        int secondStop = input.nextInt();
                                        if(Paths.isStop(stopList, String.valueOf(secondStop))) {
                                            quit = true;
                                        }

                                        else {
                                            System.out.println("Error, bus stop does not exist.");
                                            input = new Scanner(System.in);
                                            System.out.print("What is the first stop that you want a path between? (or enter quit): ");
                                        }
                                    }

                                    else if (input.hasNext("quit")) {
                                        quit = true;
                                    }

                                    else {
                                        System.out.println("Error, enter a valid input or quit.");
                                        input.next();
                                        System.out.print("What is the first stop that you want a path between? (or enter quit): ");
                                    }
                                }

                                else {
                                    System.out.println("Error, bus stop does not exist.");
                                    input = new Scanner(System.in);
                                    System.out.print("What is the first stop that you want a path between? (or enter quit): ");
                                }


                        }

                        else if (input.hasNext("quit")) {
                            quit = true;
                        }

                        else {
                            System.out.println("Error, enter a valid input or quit.");
                            input.next();
                            System.out.print("What is the first stop that you want a path between? (or enter quit): ");
                        }
                    }
                    option = 0;
                }

                else if (option == 2) {
                    System.out.print("What is the name of the bus stop you are searching for? (or enter quit): ");
                    Scanner input = new Scanner(System.in);
                    String stopName = "";
                    boolean quit = false;
                    while(!quit) {
                        if (input.hasNext()) {
                            stopName = input.nextLine();
                        }

                        ArrayList<String> arrayStops = Stops.searchStops(stopName);

                        if(arrayStops.size() != 0) {
                            System.out.println("The stop(s) that match " + stopName + " are listed as follows:");
                            for (String element : arrayStops) {
                                System.out.println(element);
                            }
                            quit = true;
                        }

                        else if(stopName.equalsIgnoreCase("quit")){
                            quit = true;
                        }

                        else{
                            System.out.println("Error, you entered an invalid input or there are no bus stops " +
                                    "that match this criteria");
                            input = new Scanner(System.in);
                            System.out.print("What is the name of the bus stop you are searching for? (or enter quit): ");
                        }
                    }

                    option = 0;
                }

                else if (option == 3) {
                    System.out.print("What time do you want your bus to arrive at? " +
                            "(please format the time as hh:mm:ss or enter quit): ");
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
                            System.out.println("The trip(s) that will arrive at " + time + " are listed as follows:");
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
                                    "(please format the time as hh:mm:ss or enter quit) : ");
                        }
                    }

                    option = 0;
                }

                else if (inputs.hasNext("quit")) {
                    end = true;
                }

                else {
                    System.out.println("Error, enter a valid input or quit.");
                }
        }
    }
}
