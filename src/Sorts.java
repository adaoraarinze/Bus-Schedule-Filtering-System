import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;

public class Sorts {
    public static ArrayList<String> stopList = new ArrayList<>();
    public static ArrayList<String> readFile(){
        try
        {
            FileReader fileReader = new FileReader("stops.txt");
            // Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;

            while(!endOfFile)
            {
                String newLine = bufferedReader.readLine();
                if (newLine != null)
                {
                    String[] stopData = newLine.split(",");
                    String stopName = stopData[2];

                    String [] arr = stopName.split(" ", 2);
                    if (arr[0].equalsIgnoreCase("flagstop")){
                        stopName = arr[1];
                    }

                    arr = stopName.split(" ", 2);
                    if (arr[0].equalsIgnoreCase("wb")){
                        stopName = arr[1];
                    }

                    arr = stopName.split(" ", 2);
                    if (arr[0].equalsIgnoreCase("nb")){
                        stopName = arr[1];
                    }

                    arr = stopName.split(" ", 2);
                    if (arr[0].equalsIgnoreCase("sb")){
                        stopName = arr[1];
                    }

                    arr = stopName.split(" ", 2);
                    if (arr[0].equalsIgnoreCase("eb")){
                        stopName = arr[1];
                    }

                    stopList.add(stopName);
                }
                else
                {
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } // End try

        catch (IOException e)
        {
            e.printStackTrace();
        }

        return stopList;
    }

    public static TST<String> TSTCreate() {
        ArrayList<String> stops = readFile();
        var tree = new TST<String>();

        for(int i = 1; i < stops.size(); i++){
            String tempStop = stops.get(i);
            tree.put(Integer.toString(i), tempStop);
        }

        StdOut.println("keys(\"\"):");
        for (String key : tree.keys()) {
            StdOut.println(key + " " + tree.get(key));
        }
        StdOut.println();

        return tree;

    }

    public static String searchStops(String search){
        var tree = TSTCreate();
        tree.keysThatMatch(search);
        for (String i : tree.keysThatMatch(search))
            StdOut.println(i);

        return null;
    }
}
