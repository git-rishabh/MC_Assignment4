package com.example.rishabh.testapp1;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Task {

    private int mId;
    private String mTitle;
    private String mDescription;
   // private boolean mSolved;

    public Task() {
        Random rand = new Random();
        mId = rand.nextInt(100000);
    }
    public Task(String title,String d) {
       // mId = id;
        Random rand = new Random();
        mId = rand.nextInt(100000);
        mTitle=title;
        mDescription=d;
    }

    public Task(int id,String title,String d) {
        // mId = id;
        //Random rand = new Random();
        mId = id;
        mTitle=title;
        mDescription=d;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }


}
