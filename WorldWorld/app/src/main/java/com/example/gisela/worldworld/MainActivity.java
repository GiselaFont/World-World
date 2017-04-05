package com.example.gisela.worldworld;


import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer play;
    private Button endButton;
    private HorizontalScrollView hsv;
    private boolean end = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void playSound(View view)
    {
        String tag = view.getTag().toString();
        AssetFileDescriptor openassets;

        try
        {
            //open audio file from Assets folder
            openassets = getAssets().openFd(tag);

            play = new MediaPlayer();
            play.setDataSource(openassets.getFileDescriptor(),openassets.getStartOffset(),openassets.getLength());
            play.prepare();
            play.start();


        } // end try
        catch (IOException e)
        {
            System.out.print(e.toString());
        } // end catch


    }

    public void openStore(View view)
    {
        //get tag from xml layout
        String tag = view.getTag().toString();
        Intent itemsActivity = new Intent(this, DisplayItems.class);
        Bundle b = new Bundle();
        b.putString("cat",tag);
        itemsActivity.putExtras(b);
        startActivity(itemsActivity);
        //finish();
    }

    public void openInterior(View view)
    {
        String tag = view.getTag().toString();
        Intent interiorActivity = new Intent(this, Interior.class);
        Bundle b = new Bundle();
        b.putString("cat",tag);
        interiorActivity.putExtras(b);
        startActivity(interiorActivity);
        //finish();
    }

    public void openHouse (View view)
    {
        playSound(view);
        Intent houseInterior = new Intent(this, Interior.class);
        startActivity(houseInterior);
    }

    public void openQuiz (View view)
    {
        Intent quizActivity = new Intent(this, Quiz.class);
        Bundle b = new Bundle();
        b.putString("cat", "Animals/dogs");
        quizActivity.putExtras(b);
        startActivity(quizActivity);
    }

    //Scroll to the end or the beginning
    public void scrollEnd (View View)
    {

        if(!end)
        {
            hsv = (HorizontalScrollView) findViewById(R.id.horizontal_scroll);
            hsv.scrollTo((int)hsv.getScrollX() + 40000, (int)hsv.getScrollY());
            end = true;
        }
        else
        {
            hsv = (HorizontalScrollView) findViewById(R.id.horizontal_scroll);
            hsv.scrollTo((int)hsv.getScrollX() - 40000, (int)hsv.getScrollY());
            end = false;
        }

    }

}
