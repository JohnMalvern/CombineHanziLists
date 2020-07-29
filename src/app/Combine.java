package app;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class Combine {


    public void CreateHeisigList(List<String> freqList) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("/Users/john/Code/hanzi-heisiglist.txt"));
            outputStream = new PrintWriter(new FileWriter("ordered-heisig-hanzi.txt"));

            String l;
            int n = 0;
            while ((l = inputStream.readLine()) != null) {
                if (l.contains("Primitive")) {
                    System.out.println(l);
                }
                else {
                    String hanzi = l.substring(0, l.indexOf("\t", 0));
                    System.out.println(hanzi);
                    int freqPos = freqList.indexOf(hanzi);
                    if (freqPos == -1) {
                        freqPos = 0;
                    }
                    String outputString = hanzi + "\t" + ++n + "\t" + ++freqPos;

                    outputStream.println(outputString);
                }
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }

    public List<String> ReadFreqList() throws IOException {

        List<String> list = new ArrayList<>();
        
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader("/Users/john/Code/hanzifreqlist.txt"));

            String l;
            int n = 0;
            while ((l = inputStream.readLine()) != null) {
                list.add(l);
                ++n;
            }
            System.out.format("Read %d characters.", n);

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return list;
    }

}