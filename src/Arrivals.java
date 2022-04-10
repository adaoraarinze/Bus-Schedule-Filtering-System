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
                    if (arr[0].equalsIgnoreCase("24") ||
                            arr[0].equalsIgnoreCase("25") ||
                            arr[0].equalsIgnoreCase("26") ||
                            arr[0].equalsIgnoreCase("27") ||
                            arr[0].equalsIgnoreCase("28") ||
                            arr[0].equalsIgnoreCase("29")) {
                        arrivalTime = null;
                    }

                    else if (Character.isWhitespace(arrivalTime.charAt(0))){
                        arrivalTime = arrivalTime.substring(1);
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

    public static ArrayList<String> searchTimes(ArrayList<String> arrayList, String time){

        if(time != null) {
            ArrayList<String> timeMatches = new ArrayList<>();
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i).equalsIgnoreCase(time)) {
                    timeMatches.add(fileList.get(i));
                }
            }
            return timeMatches;
        }

        return null;

    }
}
