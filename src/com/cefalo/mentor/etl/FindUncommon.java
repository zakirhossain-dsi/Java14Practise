package com.cefalo.mentor.etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindUncommon {
    public static void main(String[] args) throws IOException {
        String fileA = "fileA";
        String fileB = "fileB";
        String uncommon = "uncommon";
        Scanner fileAScanner = new Scanner(new File(fileA));
        FileWriter inANotBWriter = new FileWriter(uncommon, true);
        BufferedWriter bw = new BufferedWriter(inANotBWriter);
        try {
            while (fileAScanner.hasNextLine()) {
                String fileAID = fileAScanner.nextLine();
                Scanner fileBScanner = new Scanner(new File(fileB));
                boolean isFound = false;
                while (fileBScanner.hasNext()) {
                    String fileBID = fileBScanner.nextLine();
                    //if (fileAID.trim().equals(fileBID.trim())) {
                    if (fileAID.trim().contains(fileBID.trim())) {
                        isFound = true;
                        break;
                    }
                }
                fileBScanner.close();

                if (!isFound) {
                    System.out.println(fileAID);
                    bw.write(fileAID);
                    bw.newLine();
                    bw.flush();
                }
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            fileAScanner.close();
            inANotBWriter.close();
        }
    }
}

