package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        String[] tempWordsArrayList = text.trim().split("\\s+");
        Collections.addAll(wordsArrayList, tempWordsArrayList);
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
        for (String word : wordsArrayList) {
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
//        List<String> tempArrayList = new ArrayList<>();
//        List<String> fromWordsArrayList = new ArrayList<>(Arrays.asList(fromWords));
//        ListIterator<String> wordsListIterator = wordsArrayList.listIterator();
//        ListIterator<String> fromWordsListIterator = fromWordsArrayList.listIterator();
//
//        boolean forward = true;
//        while (wordsListIterator.hasNext()) {
//            if (wordsListIterator.next().equals(fromWordsArrayList.get(0))) {
//                String lastDiffWord = wordsListIterator.previous();
//                while (fromWordsListIterator.hasNext()) {
//                    if (!wordsListIterator.next().equals(fromWordsListIterator.next())) {
//                        lastDiffWord
//                    }
//                }
//            }
//        }
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
