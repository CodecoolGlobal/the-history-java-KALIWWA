package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] tempArray = text.trim().split("\\s+");
        int newArrayLength = wordsArray.length + tempArray.length;
        String[] concatArray = new String[newArrayLength];
        for (int i = 0; i < wordsArray.length; i++) {
            concatArray[i] = wordsArray[i];
        }
        for (int i = 0; i < tempArray.length; i++) {
            concatArray[i + wordsArray.length] = tempArray[i];
        }
        wordsArray = concatArray;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        List<String> tempList = new ArrayList<>();
        for (String s : wordsArray) {
            if (!s.equals(wordToBeRemoved)) {
                tempList.add(s);
            }
        }
        wordsArray = tempList.toArray(new String[0]);
    }

    @Override
    public int size() {
        int counter = 0;
        for (String ignored : wordsArray) {
            counter++;
        }
        return counter;
    }

    @Override
    public void clear() {
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        List<String> tempList = new ArrayList<>();
        for (String s : wordsArray) {
            if (!s.equals(from)) {
                tempList.add(s);
            } else {
                tempList.add(to);
            }
        }
        wordsArray = tempList.toArray(new String[0]);
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
