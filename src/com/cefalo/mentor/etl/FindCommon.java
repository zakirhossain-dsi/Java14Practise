package com.cefalo.mentor.etl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FindCommon {
    public static void main(String[] args) throws IOException {
        String successList = "successlist-1";
        String errorList = "successlist-2";
        String commonList = "successlist-3";
        Scanner successScanner = new Scanner(new File(successList));
        FileWriter commonWriter = new FileWriter(commonList, true);
        BufferedWriter bw = new BufferedWriter(commonWriter);
        try {
            while (successScanner.hasNextLine()) {
                String successID = successScanner.nextLine();
                Scanner errorScanner = new Scanner(new File(errorList));
                boolean isCommon = false;
                while (errorScanner.hasNext()) {
                    String errorID = errorScanner.nextLine();
                    if (successID.trim().equals(errorID.trim())) {
                        isCommon = true;
                        break;
                    }
                }
                errorScanner.close();

                if (isCommon) {
                    Scanner commonScanner = new Scanner(new File(commonList));
                    boolean isFound = false;
                    while(commonScanner.hasNext()) {
                        String commonID = commonScanner.nextLine();
                        if (successID.trim().equals(commonID.trim())) {
                            isFound = true;
                            break;
                        }
                    }
                    if(!isFound){
                        System.out.println(successID);
                        bw.write(successID);
                        bw.newLine();
                        bw.flush();
                    }
                    commonScanner.close();
                }
            }
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }finally {
            successScanner.close();
            commonWriter.close();
        }
    }
}

