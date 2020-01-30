package com.owen.scott.programs.chapter14;

import com.owen.scott.annotations.Completed;

import java.util.Random;

@Completed
public class RandomSentences implements Runnable {
    private static final String[] ARTICLES = {"the", "a", "one", "some", "any"};
    private static final String[] NOUNS = {"boy", "girl", "dog", "town", "car"};
    private static final String[] VERBS = {"drove", "jumped", "ran", "walked", "skipped"};
    private static final String[] PREPOSITIONS = {"to", "from", "over", "under", "on"};
    private static final byte WORD_OPTIONS_COUNT = 5;
    private static final int SENTENCE_COUNT = 20;

    @Override
    public void run() {
        for (int i = 0; i < SENTENCE_COUNT; i++) {
            System.out.println(genSentence());
        }
    }

    private String genSentence() {
        //article, noun, verb, preposition, article, noun
        Random rand = new Random();
        String first = ARTICLES[rand.nextInt(WORD_OPTIONS_COUNT)];
        String second = NOUNS[rand.nextInt(WORD_OPTIONS_COUNT)];
        String third = VERBS[rand.nextInt(WORD_OPTIONS_COUNT)];
        String fourth = PREPOSITIONS[rand.nextInt(WORD_OPTIONS_COUNT)];
        String fifth = ARTICLES[rand.nextInt(WORD_OPTIONS_COUNT)];
        String sixth = NOUNS[rand.nextInt(WORD_OPTIONS_COUNT)];
        return first.substring(0, 1).toUpperCase() + first.substring(1) + " " + second + " " + third + " " + fourth + " " + fifth + " " + sixth + ".";
    }
}
