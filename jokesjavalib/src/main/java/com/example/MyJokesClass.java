package com.example;

import java.util.ArrayList;
import java.util.Random;

public class MyJokesClass {

    ArrayList<String> jokeList;
    private Random randomGenerator;

    public MyJokesClass(){
        jokeList = new ArrayList<String>();
        jokeList.add("Joke 1");
        jokeList.add("Joke 2");
        jokeList.add("Joke 3");
        jokeList.add("Joke 4");
        jokeList.add("Joke 5");
        randomGenerator = new Random();

    }

    public String getJoke(){
        int index = randomGenerator.nextInt(jokeList.size());
        return jokeList.get(index);
    }
}
