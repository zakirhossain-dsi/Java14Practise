package com.cefalo.mentor.etl;

import java.io.*;
import java.util.Scanner;

public class UniqueIDFinder {
    public static void main(String[] args) throws IOException {
        String fromFile = "polopoly-id";
        String toFile = "unique-id";
        Scanner firstScanner = new Scanner(new File(fromFile));
        FileWriter fileWriter = new FileWriter(toFile, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        try {
            while (firstScanner.hasNextLine()) {
                String firstID = firstScanner.nextLine();
                boolean isFound = false;
                Scanner secondScanner = new Scanner(new File(toFile));
                while (secondScanner.hasNext()) {
                    String secondID = secondScanner.nextLine();
                    if (firstID.trim().equals(secondID.trim())) {
                        isFound = true;
                        break;
                    }
                }
                if (!isFound) {
                    System.out.println(firstID);
                    bw.write(firstID);
                    bw.newLine();
                    bw.flush();
                }
                secondScanner.close();
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            firstScanner.close();
            fileWriter.close();
        }
    }
}
