package com.example.permits_ultimate.sequencers;

public class PlayerSequencer {
    private int currentID;

    private int nextID(){
        return currentID++;
    }

    private int getCurrentID(){
        return currentID;
    }
}