package app;

import java.util.*;

public class App {
    public static void main(final String[] args) throws Exception {
        System.out.println("Hanzi Combiner");

        System.out.println("Testing...");
        final Combine test = new Combine();

        System.out.println("Reading frequency list...");
        List<String> freqList = test.ReadFreqList();
        System.out.format("List has %d entries.", freqList.size());

        test.CreateHeisigList(freqList);
        
        System.out.println("Finished.");
    }
}