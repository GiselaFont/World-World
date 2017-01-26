package com.example.gisela.worldworld;


import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Intent houseInteriorActivity;
    MediaPlayer stairs;
    MediaPlayer door;
    MediaPlayer clown_balloons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void playStairs(View view)
    {
        stairs = MediaPlayer.create(this, R.raw.stairs);
        stairs.start();
    }

    public void playDoor(View view)
    {
        door = MediaPlayer.create(this, R.raw.door);
        door.start();
        houseInteriorActivity = new Intent(this, AnimalsDogs.class);
        startActivity(houseInteriorActivity);

    }

    public void playClownBalloons(View view)
    {
        clown_balloons = MediaPlayer.create(this, R.raw.clown_balloons);
        clown_balloons.start();
    }


}
