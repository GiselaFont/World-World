package com.example.gisela.worldworld;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Interior extends AppCompatActivity {
    private String cat;
    MainActivity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //get value of the tag (press button)
        Bundle b = getIntent().getExtras();
        if(b != null)
        {
            cat = b.getString("cat");
        }
        //check which store interior we need to display
        if(cat.equals("toys"))
        {
            setContentView(R.layout.activity_toys_interior);
        }
        else if(cat.equals("dogs"))
        {
            setContentView(R.layout.activity_bakery_interior);
        }
        else if(cat.equals("bakery"))
        {
            setContentView(R.layout.activity_bakery_interior);
        }
        else if(cat.equals("job"))
        {
            setContentView(R.layout.activity_job_interior);
        }
        else if(cat.equals("vehicle"))
        {
            setContentView(R.layout.activity_vehicle_interior);
        }
        else if(cat.equals("sports"))
        {
            setContentView(R.layout.activity_sports_interior);
        }
        else if(cat.equals("clothes"))
        {
            setContentView(R.layout.activity_clothes_interior);
        }
        else if(cat.equals("groceries"))
        {
            setContentView(R.layout.activity_groceries_interior);
        }
        else if(cat.equals("music"))
        {
            setContentView(R.layout.activity_music_interior);
        }
        else if(cat.equals("hair"))
        {
            setContentView(R.layout.activity_hair_interior);
        }
        else if(cat.equals("tools"))
        {
            setContentView(R.layout.activity_tools_interior);
        }
        else if(cat.equals("plant"))
        {
            setContentView(R.layout.activity_plant_interior);
        }
        else if(cat.equals("zoo"))
        {
            setContentView(R.layout.activity_zoo_interior);
        }
        else
        {
            setContentView(R.layout.activity_house_interior);
        }

    }

    public void openCategory(View view)
    {
        String tag = view.getTag().toString();
        Intent itemsActivity = new Intent(this, DisplayItems.class);
        Bundle b = new Bundle();
        b.putString("cat",tag);
        itemsActivity.putExtras(b);
        startActivity(itemsActivity);
    }

}
