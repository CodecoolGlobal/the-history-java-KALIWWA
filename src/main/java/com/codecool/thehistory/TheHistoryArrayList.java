package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] tempWordsArrayList = text.trim().split("\\s+");
        for (String word : tempWordsArrayList) {
            wordsArrayList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        List<String> temp = new ArrayList<>();
        for (String word : wordsArrayList) {
            if (!word.equals(wordToBeRemoved)) {
                temp.add(word);
            }
        }
        wordsArrayList = temp;
    }

    @Override
    public int size() {
        int counter = 0;
        for (String ignore : wordsArrayList) {
            counter++;
        }
        return counter;
    }

    @Override
    public void clear() {
        Iterator<String> iterator = wordsArrayList.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    @Override
    public void replaceOneWord(String from, String to) {
        List<String> temp = new ArrayList<>();
        for (String word : wordsArrayList) {
            if (!word.equals(from)) {
                temp.add(word);
            } else {
                temp.add(to);
            }
        }
        wordsArrayList = temp;
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        List<String> stringArrayList = new ArrayList<>();

        int currentIndex = 0;
        while (currentIndex < wordsArrayList.size()) {
            if (currentIndex + fromWords.length <= wordsArrayList.size() && Arrays.equals(fromWords, wordsArrayList.subList(currentIndex, currentIndex + fromWords.length).toArray())) {
                stringArrayList.addAll(Arrays.asList(toWords));
                currentIndex = currentIndex + fromWords.length;
            } else {
                stringArrayList.add(wordsArrayList.get(currentIndex));
                currentIndex++;
            }
        }
        wordsArrayList = stringArrayList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
