package homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordCounter extends AbstractFile{
    private int currentWordsHashCode;
    private final Map<String, Integer> wordsSortedByCountDesc = new LinkedHashMap<>();

    public WordCounter(File file) {
        super(file);
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void countWords() {
        Map<String, Integer> wordsByCount = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(this.file))) {
            String line;
            while ((line = br.readLine()) != null) {
                for (String word : line.trim().split(" ")) {
                    wordsByCount.merge(word, 1, Integer::sum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortMapByValue(wordsByCount);
    }

    public void sortMapByValue(Map<String, Integer> words) {
        int wordsHashCode = words.hashCode();

        if (wordsSortedByCountDesc.isEmpty() || wordsHashCode != currentWordsHashCode) {
            wordsSortedByCountDesc.clear();

            // Create a list from elements of HashMap
            List<Map.Entry<String, Integer>> list = new LinkedList<>(words.entrySet());

            // Sort the list
            list.sort((w1, w2) -> w2.getValue() - w1.getValue());

            // Put the data from sorted list to the linked hashmap
            for (Map.Entry<String, Integer> element : list) {
                wordsSortedByCountDesc.put(element.getKey(), element.getValue());
            }
            currentWordsHashCode = wordsHashCode;
        }
        printWordsByCount();
    }

    public void printWordsByCount() {
        for (String key : wordsSortedByCountDesc.keySet()) {
            System.out.println(key + " " + wordsSortedByCountDesc.get(key));
        }
    }
}
