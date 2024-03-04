package com.cefalo.mentor.etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindDuplicate {
    public static void main(String[] args) throws IOException {
        String fromFile = "polopoly-id";
        String toFile = "duplicate-id";
        Scanner firstScanner = new Scanner(new File(fromFile));
        FileWriter fileWriter = new FileWriter(toFile, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        try {
            while (firstScanner.hasNextLine()) {
                String firstID = firstScanner.nextLine();
                Scanner secondScanner = new Scanner(new File(fromFile));
                int count = 0;
                while (secondScanner.hasNext()) {
                    String secondID = secondScanner.nextLine();
                    if (firstID.trim().equals(secondID.trim())) {
                        count++;
                    }
                }
                secondScanner.close();

                if (count > 1) {
                    Scanner thirdScanner = new Scanner(new File(toFile));
                    boolean isFound = false;
                    while(thirdScanner.hasNext()) {
                        String thirdID = thirdScanner.nextLine();
                        if (firstID.trim().equals(thirdID.trim())) {
                           isFound = true;
                            break;
                        }
                    }
                    if(!isFound){
                        System.out.println(firstID);
                        bw.write(firstID);
                        bw.newLine();
                        bw.flush();
                    }
                    thirdScanner.close();
                }
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            firstScanner.close();
            fileWriter.close();
        }
    }
}

