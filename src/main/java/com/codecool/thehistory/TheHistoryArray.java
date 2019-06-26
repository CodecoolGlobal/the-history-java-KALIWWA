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
        wordsArray = Stream.concat(Arrays.stream(wordsArray), Arrays.stream(tempArray))
                .toArray(String[]::new);
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
        wordsArray = new String[0];
//        for (int i = 0; i < wordsArray.length; i++) {
//            wordsArray[i] = "";
//        }
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
//        String fromWordsString = String.join(" ", fromWords);
//        String toWordsString = String.join(" ", toWords);
//
//        String regex = "\\b" + fromWordsString + "\\b";
//        String wordArrayAsString =
//                String
//                        .join(" ", wordsArray)
//                        .replaceAll(regex, toWordsString);
//
//        wordsArray = wordArrayAsString.split(" ");
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
