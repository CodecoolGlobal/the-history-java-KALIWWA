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

        for (int i = 0; i < tempWordsList.size(); i++) {
            wordsLinkedList.add(tempWordsList.get(i));
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
        // when 1st match, create new iterator, and using it check fromWords to current,
// maybe cut new list with matched words


//        in line 75, at last element on fromWords -> fromWordsListIterator.next() is null
//        List<String> tempArrayList = new ArrayList<>();
//        List<String> fromWordsLinkedList = new LinkedList<String>(Arrays.asList(fromWords));
//        List<String> toWordsLinkedList = new LinkedList<String>(Arrays.asList(toWords));
//        ListIterator<String> wordsListIterator = wordsLinkedList.listIterator();
//        ListIterator<String> fromWordsListIterator = fromWordsLinkedList.listIterator();
//        ListIterator<String> toWordsListIterator = toWordsLinkedList.listIterator();
//
//        while (wordsListIterator.hasNext()) {
//            ListIterator<String> lastDiffIterator = wordsListIterator;
//            if (wordsListIterator.next().equals(fromWordsListIterator.next())) {
//                while (fromWordsListIterator.hasNext()) {
//                    if (fromWordsListIterator.next().isEmpty()) {
//                        System.out.println("I'm in");
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
