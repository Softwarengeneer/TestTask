package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "Test.txt";
        try {
            //Reading file
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line;
            ArrayList<ArrayList<String>> arrList = new ArrayList<>();
            while ((line = bufferReader.readLine()) != null){
                ArrayList<String> smallArrayList = new ArrayList<String>();
                Collections.addAll(smallArrayList, line.split(";"));
                arrList.add(smallArrayList);
            }
            //Reading file
            //Sorting
            ArrayList<ArrayList<String>> result = new ArrayList<>();
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            for (int i = 0; i < arrList.size(); i++) {
                for (int j = 0; j < arrList.get(i).size(); j++) {
                    String key = arrList.get(i).get(j);
                    ArrayList<String> temp;
                    if (map.containsKey(key)) {
                        temp = map.get(key);
                    } else {
                        temp = new ArrayList<String>();
                    }
                    temp.add(arrList.get(i).get(j));
                    map.put(key, temp);
                }
            }
            for (ArrayList<String> value : map.values()) {
                result.add(value);
            }
            //Sorting
            //Writing
            FileWriter outputFile = new FileWriter("output.txt");
            for(ArrayList<String> arrayList : result) {

                for (String str : arrayList) {
                    outputFile.write(str + ";");
                }
                outputFile.write("\n");
            }
            outputFile.close();
            bufferReader.close();
        }
        //Writing
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}