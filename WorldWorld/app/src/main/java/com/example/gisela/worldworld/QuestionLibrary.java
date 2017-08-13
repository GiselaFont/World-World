package com.example.gisela.worldworld;

import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;

/**
 * Created by Gisela on 1/19/17.
 */

public class QuestionLibrary {
    private MediaPlayer question;
    private Drawable choice1;
    private Drawable choice2;
    private Drawable choice3;
    private Drawable choice4;
    private Drawable answer;

    public QuestionLibrary(MediaPlayer question, Drawable choice1, Drawable choice2, Drawable choice3, Drawable choice4, Drawable answer){
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    public MediaPlayer getQuestion() {
         return question;
     }

    public Drawable getChoice1(){
        return choice1;
    }

    public Drawable getChoice2(){
        return choice2;
    }

    public Drawable getChoice3(){
        return choice3;
    }

    public Drawable getChoice4(){
        return choice4;
    }

    public Drawable getAnswer(){
        return answer;
    }
}
