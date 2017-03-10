package com.example.gisela.worldworld;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gisela on 1/21/17.
 */

public class DisplayItems extends AppCompatActivity implements MyAdapter.ClickListener{

    private List<String> fileNameList;
    private RecyclerView mrecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MyAdapter adapter;
    private String cat;
    MediaPlayer play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_dogs);

        //get value of the tag (press button)
        Bundle b = getIntent().getExtras();
        if(b != null)
        {
            cat = b.getString("cat");
        }

        //recycler view code and get data
        mrecyclerView = (RecyclerView) findViewById(R.id.drawerList);
        adapter = new MyAdapter(getApplicationContext(),getData());
        adapter.setClickListener(this);
        mrecyclerView.setAdapter(adapter);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLinearLayoutManager);


    }

    public List<Item> getData()
    {

        Item current;
        List<Item> data=new ArrayList<>();
        Drawable image;

        AssetManager assets = getAssets(); // get app's AssetManager
        InputStream stream; // used to read in flag images
        fileNameList = new ArrayList<String>();

        try
        {
            //get all the path of the files inside Animals folder
            String[] path = assets.list(cat);
            String tmp;

            for(int i = 0; i < path.length; i++)
            {
                tmp = path[i];
                path[i] = path[i].replace(".png", " ");

                //add name of the image to the list
                fileNameList.add(path[i]);
                // load the asset as a Drawable and display on the Image and TextView
                stream = assets.open(cat + "/" + tmp);
                image = Drawable.createFromStream(stream, null);
                current = new Item(image, fileNameList.get(i));
                data.add(current);

            }


        } // end try
        catch (IOException e)
        {
            System.out.print(e.toString());
        } // end catch

        return  data;


    }


    @Override
    public void itemClicked(View view, int position) {

        AssetManager assets = getAssets(); // get app's AssetManager
        AssetFileDescriptor openassets;

        try
        {
            //get all the path of the files inside Animals folder
            String[] path = assets.list(cat + "/sounds");
            // get an InputStream to the asset representing the next item
            //provide access to the file
            openassets = getAssets().openFd(cat + "/sounds/" + path[position]);

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
}
