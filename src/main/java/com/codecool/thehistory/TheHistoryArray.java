package com.codecool.thehistory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        int counter = 0;
        for (int i = 0; i < wordsArray.length; ) {
            if (Arrays.equals(Arrays.copyOfRange(wordsArray, i, i + fromWords.length), fromWords)) {
                counter++;
                i = i + fromWords.length;
            } else {
                i++;
            }
        }
        String[] wordsNewArray = new String[wordsArray.length - counter * fromWords.length + counter * toWords.length];

        int i = 0;
        for (int j = 0; j < wordsArray.length; ) {
            if (Arrays.equals(Arrays.copyOfRange(wordsArray, j, j + fromWords.length), fromWords)) {
                System.arraycopy(toWords, 0, wordsNewArray, i, toWords.length);
                i = i + toWords.length;
                j = j + fromWords.length;
            } else {
                System.arraycopy(wordsArray, j, wordsNewArray, i, 1);
                i++;
                j++;
            }
        }
        wordsArray = wordsNewArray;
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
