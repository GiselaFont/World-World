package com.example.gisela.worldworld;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Gisela on 2/12/17.
 */

public class Quiz extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary;
    private Random num = new Random();

    private TextView mScoreView;
    private ImageView mImageChoice1;
    private ImageView mImageChoice2;
    private ImageView mImageChoice3;
    private ImageView mImageChoice4;

    private Drawable mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    private String cat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Bundle b = getIntent().getExtras();
        cat = b.getString("cat");

        mScoreView = (TextView) findViewById(R.id.score);
        mImageChoice1 = (ImageView) findViewById(R.id.choice1);
        mImageChoice2 = (ImageView) findViewById(R.id.choice2);
        mImageChoice3 = (ImageView) findViewById(R.id.choice3);
        mImageChoice4 = (ImageView) findViewById(R.id.choice4);

        updateQuestion();
    }

    private void updateQuestion()
    {
        getQuizData(); // get all the possible answers, question and correct answer
        //play sound (question)
        try{

            mQuestionLibrary.getQuestion().prepare();
            mQuestionLibrary.getQuestion().start();
        }
        catch(IOException e){

            System.out.print(e.toString());
        }

        mImageChoice1.setImageDrawable(mQuestionLibrary.getChoice1());
        mImageChoice2.setImageDrawable(mQuestionLibrary.getChoice2());
        mImageChoice3.setImageDrawable(mQuestionLibrary.getChoice3());
        mImageChoice4.setImageDrawable(mQuestionLibrary.getChoice4());

        mAnswer = mQuestionLibrary.getAnswer();
        mQuestionNumber++;
    }

    private void updateScore(int point)
    {
        mScoreView.setText("" + mScore);
    }

    public List<QuestionLibrary> getQuizData()
    {
        MediaPlayer mSoundQuestion;
        List<QuestionLibrary> data = new ArrayList<>();
        Drawable image1;
        Drawable image2;
        Drawable image3;
        Drawable image4;
        int n; //random number
        String correctAnswer;

        AssetManager assets = getAssets(); // get app's AssetManager
        InputStream[] answers = new InputStream[4]; //read in images and store all the answers
        //fileNameList = new ArrayList<String>();
        AssetFileDescriptor openassets;

        try
        {

            //get sound for question
            //get all the path of the files inside Animals folder
            String[] soundpath = assets.list(cat + "/sounds");
            // get an InputStream to the asset representing the next item
            //provide access to the file
            n = num.nextInt(soundpath.length-1);
            openassets = getAssets().openFd(cat + "/sounds/" + soundpath[n]);
            correctAnswer = soundpath[n].replace("mp3", "png");

            mSoundQuestion = new MediaPlayer();
            mSoundQuestion.setDataSource(openassets.getFileDescriptor(),openassets.getStartOffset(),openassets.getLength());

            //get all the paths of the files inside the category folder
            String[] imagepath = assets.list(cat);

            //get all possible answers
            answers[0] = assets.open(cat + "/" + correctAnswer); //load asset

            for(int i = 1; i < answers.length; i++)
            {
                //get image for choice2
                n = num.nextInt(imagepath.length-1);
                answers[i] = assets.open(cat + "/" + imagepath[n]); //load asset
                //avoid duplicates
                if(i == 1)
                {
                    if(answers[3].equals(answers[2]) || answers[3].equals(answers[1]) || answers[3].equals(answers[0]) || answers[2].equals(answers[1]))
                    {
                        answers[3] = assets.open(cat + "/" + imagepath[n+1]); //load asset
                    }
                }

            }
            
            Collections.shuffle(Arrays.asList(answers));

            image1 = Drawable.createFromStream(answers[0], null);
            image2 = Drawable.createFromStream(answers[1], null);
            image3 = Drawable.createFromStream(answers[2], null);
            image4 = Drawable.createFromStream(answers[3], null);

            mQuestionLibrary = new QuestionLibrary(mSoundQuestion, image1, image2, image3, image4, image1);
            data.add(mQuestionLibrary);


        } // end try
        catch (IOException e)
        {
            System.out.print(e.toString());
        } // end catch

        return  data;


    }

    public void checkAnswer(View view)
    {
        ImageView mImageChoice = (ImageView) findViewById(view.getId());

        if(mImageChoice.getDrawable() == mAnswer){
            mScore = mScore + 1;
            updateScore(mScore);
            updateQuestion();
            Toast.makeText(Quiz.this, "correct", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(Quiz.this, "wrong", Toast.LENGTH_LONG).show();
            updateQuestion();
        }
    }



}
