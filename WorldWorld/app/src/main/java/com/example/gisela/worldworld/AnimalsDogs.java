package com.example.gisela.worldworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gisela on 1/21/17.
 */

public class AnimalsDogs extends AppCompatActivity{

    private RecyclerView mrecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals_dogs);

        mrecyclerView = (RecyclerView) findViewById(R.id.drawerList);
        adapter = new MyAdapter(getApplicationContext(),getData());
        mrecyclerView.setAdapter(adapter);

        mLinearLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLinearLayoutManager);

    }

    public static List<Item> getData()
    {
        Item current;
        List<Item> data=new ArrayList<>();
        int[] icons = {R.drawable.animals_dogs_beagle, R.drawable.animals_dogs_bloodhound, R.drawable.animals_dogs_boxer,
                R.drawable.animals_dogs_bulldog, R.drawable.animals_dogs_chihuahua, R.drawable.animals_dogs_cockerspaniel,
                R.drawable.animals_dogs_collie, R.drawable.animals_dogs_dachshund, R.drawable.animals_dogs_germanshepherd,
                R.drawable.animals_dogs_greyhound, R.drawable.animals_dogs_labrador, R.drawable.animals_dogs_poodle,
                R.drawable.animals_dogs_saintbernard};
        String[] titles = {"Beagle","Bloohound","Boxer", "Bulldog", "Chihuahua", "Cokerspaniel", "Collie", "Dachshund", "GermanShepherd",
        "Greyhound", "Labrador", "Poodle", "Saint Bernard"};

        for(int i=0; i<titles.length && i<icons.length; i++)
        {
            current = new Item(icons[i],titles[i]);
            data.add(current);
        }

        return  data;


    }


}
