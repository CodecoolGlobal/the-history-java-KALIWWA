package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        List<String> tempWordsList = Arrays.asList(text.trim().split("\\s+"));

        for (String word : tempWordsList) {
            wordsLinkedList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        Iterator<String> iterator = wordsLinkedList.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equals(wordToBeRemoved)) {
                iterator.remove();
            }
        }
    }

    @Override
    public int size() {
        int counter = 0;
        for (String ignored : wordsLinkedList) {
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
        List<String> stringLinkedList = new LinkedList<>();
        int currentIndex = 0;

        while (currentIndex < wordsLinkedList.size()) {
            if (currentIndex + fromWords.length <= wordsLinkedList.size()
                    && Arrays.equals(wordsLinkedList.subList(currentIndex, currentIndex + fromWords.length).toArray(), fromWords)) {
                stringLinkedList.addAll(Arrays.asList(toWords));
                currentIndex = currentIndex + fromWords.length;
            } else {
                ListIterator iterator = wordsLinkedList.listIterator(currentIndex);
                stringLinkedList.add((String) iterator.next());
                currentIndex++;
            }
        }
        wordsLinkedList = stringLinkedList;

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
