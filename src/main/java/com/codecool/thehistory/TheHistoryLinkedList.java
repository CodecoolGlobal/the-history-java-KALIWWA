package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        String[] tempWordsArrayList = text.trim().split("\\s+");
        wordsLinkedList.addAll(Arrays.asList(tempWordsArrayList));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        wordsLinkedList.removeIf(s -> s.equals(wordToBeRemoved));
    }

    @Override
    public int size() {
        int counter = 0;
        for (String s : wordsLinkedList) {
            counter++;
        }
        return counter;
    }

    @Override
    public void clear() {
        ListIterator<String> listIterator = wordsLinkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.remove();
        }
    }

    @Override
    public void replaceOneWord(String from, String to) {
        ListIterator<String> listIterator = wordsLinkedList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().equals(from)) {
                listIterator.remove();
                listIterator.add(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
