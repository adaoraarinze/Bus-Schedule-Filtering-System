import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import edu.princeton.cs.algs4.Digraph;

public class Paths {
    public static ArrayList<String> readFile(){
        ArrayList<String> stopList = new ArrayList<>();
        try
        {
            FileReader fileReader = new FileReader("stops.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            while(!endOfFile)
            {
                String newLine = bufferedReader.readLine();
                if (newLine != null)
                {
                    String[] stopData = newLine.split(",");
                    String stopID = stopData[0];

                    stopList.add(stopID);
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

    public static boolean isStop(ArrayList<String> list, String stop){
        for(int i =0; i < list.size(); i++){
            if (list.get(i).equalsIgnoreCase(stop)) {
                return true;
            }
        }
        return false;
    }
}
