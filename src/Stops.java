import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.TST;

public class Stops {
    public static ArrayList<String> fileList = new ArrayList<>();
    public static ArrayList<String> readFile(){
        ArrayList<String> stopList = new ArrayList<>();
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
                    fileList.add(newLine);
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

    public static TST<Integer> TSTCreate() {
        ArrayList<String> stops = readFile();
        TST<Integer> tree = new TST<>();

        for(int i = 0; i < stops.size(); i++){
            String tempStop = stops.get(i);
            tree.put(tempStop, i);
        }

        return tree;

    }

    public static ArrayList<String> searchStops(String search){
        TST<Integer> tree = TSTCreate();
        ArrayList<String> stops = new ArrayList<>();


        for (String i : tree.keysThatMatch(search)) {
            //StdOut.println(i);
            //stops.add(i);
            stops.add(fileList.get(Integer.parseInt(String.valueOf(tree.get(i)))));
        }

        return stops;
    }
}
