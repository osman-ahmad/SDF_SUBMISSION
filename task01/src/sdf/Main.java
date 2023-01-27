package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;

public class Main {

    public static String removePunctuations(String source) {
        return source.replaceAll("[\\p{P}&&[^\u0027]']", "");
    }

    public static void main(String[] args) throws IOException {

        Path cithPath = Paths.get(args[0]);

        System.out.printf("file name: %s\n", cithPath);

        File cith = cithPath.toFile();
        LinkedHashMap<String, Integer> wordfreq = new LinkedHashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader(cith));

        String str;
        while ((str = br.readLine()) != null) {

            str = str.toLowerCase();
            str = removePunctuations(str);
            String[] words = str.split(" ");

            for (String word : words) {
                if (word.length() == 0) {
                    continue;
                }

                Integer count = wordfreq.get(word);

                if (count == null) {
                    count = 1;
                } else {
                    count++;
                }

                wordfreq.put(word, count);

            }

        }
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.addAll(wordfreq.values());
        double total = 0;
        Collections.sort(results, Collections.reverseOrder());

        for (Integer i : results) {
            total = total + i;
        }
            // System.out.println(total);

            for (Integer j : results.subList(0, 9)) {
                
                for (String word : wordfreq.keySet()) {

                    if (wordfreq.get(word) == j) {

                        double termFrequency = j / total;
                        
                        System.out.println("The word '" + word + "' having the term frequency value of :" + termFrequency);
                    }
                }
            }
        
        br.close();

    }
}
