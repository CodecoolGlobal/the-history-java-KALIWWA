package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.List;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        String[] tempArray = text.trim().split("\\s+");
        wordsArray = tempArray.clone();
        System.arraycopy(tempArray, 0, wordsArray, 0, tempArray.length);


        //TODO: Splits the incoming text to words and adds the words to the container of the
        //      implementing class
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
        for (String s : wordsArray) {
            counter++;
        }
        return counter;
    }

    @Override
    public void clear() {
        for (int i = 0; i < wordsArray.length; i++) {
            wordsArray[i] = "";
        }
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
        //TODO: check the TheHistory interface for more information
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
