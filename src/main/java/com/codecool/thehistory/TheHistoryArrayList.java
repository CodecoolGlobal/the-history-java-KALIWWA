package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
       List<String> tempWordsArrayList = Arrays.asList(text.trim().split("\\s+"));
        for (int i = 0; i < tempWordsArrayList.size(); i++) {
            wordsArrayList.add(tempWordsArrayList.get(i));
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
