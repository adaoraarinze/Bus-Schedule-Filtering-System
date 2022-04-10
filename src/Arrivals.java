import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Arrivals {
    public static ArrayList<String> fileList = new ArrayList<>();
    public static ArrayList<String> readFile(){
        ArrayList<String> arrivalList = new ArrayList<>();
        try
        {
            FileReader fileReader = new FileReader("stop_times.txt");
            // Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;
            while(!endOfFile)
            {
                String newLine = bufferedReader.readLine();
                if (newLine != null)
                {
                    String[] timeData = newLine.split(",");
                    String arrivalTime = timeData[1];

                    String [] arr = arrivalTime.split(":", 2);
                    if (Integer.parseInt(arr[0]) > 23){
                        arrivalTime = null;
                    }

                    if(arrivalTime != null) {
                        arrivalList.add(arrivalTime);
                        fileList.add(newLine);
                    }
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

        return arrivalList;
    }
}
