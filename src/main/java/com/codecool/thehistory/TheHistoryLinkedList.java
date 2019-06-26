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
                listIterator.set(to);
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        List<String> tempArrayList = new ArrayList<>();
        List<String> fromWordsArrayList = new ArrayList<>(Arrays.asList(fromWords));
        List<String> toWordsArrayList = new ArrayList<>(Arrays.asList(toWords));
        ListIterator<String> wordsListIterator = wordsLinkedList.listIterator();
        ListIterator<String> fromWordsListIterator = fromWordsArrayList.listIterator();
        int iterNumber = 0;
        String lastDiffWord = null;
        String nextDiffWord = null;

        boolean forward = true;
//        while (wordsListIterator.hasNext()) {
//            if (wordsListIterator.next().equals(fromWordsArrayList.get(0))) {
//                lastDiffWord = wordsListIterator.previous();
//                while (fromWordsListIterator.hasNext()) {
//                    iterNumber++;
//                    if (!wordsListIterator.next().equals(fromWordsListIterator.next())) {
//
//                        forward = false;
//                        for (int i = 0; i < iterNumber; i++) {
//                            wordsListIterator.previous();
//                        }
//                        wordsListIterator.next().equals(toWordsArrayList.get(0));
//                        forward = true;
//                        for (int i = 0; i < toWordsArrayList.size() - 1; i++) {
//                            wordsListIterator.next();
//                        }
//                    }
//                }
//            }
//        }
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
