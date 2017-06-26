package com.example.gisela.worldworld;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.IOException;

public class Interior extends AppCompatActivity {

    private String cat;
    MainActivity main;
    MediaPlayer play;

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
        if(cat.contains("toys"))
        {
            setContentView(R.layout.activity_toys_interior);
        }
        else if(cat.contains("dogs"))
        {
            setContentView(R.layout.activity_dogs_interior);
        }
        else if(cat.contains("bakery"))
        {
            setContentView(R.layout.activity_bakery_interior);
        }
        else if(cat.contains("job"))
        {
            setContentView(R.layout.activity_job_interior);
        }
        else if(cat.contains("vehicle"))
        {
            setContentView(R.layout.activity_vehicle_interior);
        }
        else if(cat.contains("sports"))
        {
            setContentView(R.layout.activity_sports_interior);
        }
        else if(cat.contains("cloth"))
        {
            setContentView(R.layout.activity_clothes_interior);
        }
        else if(cat.contains("groceries"))
        {
            setContentView(R.layout.activity_groceries_interior);
        }
        else if(cat.contains("music"))
        {
            setContentView(R.layout.activity_music_interior);
        }
        else if(cat.contains("hair"))
        {
            setContentView(R.layout.activity_hair_interior);
        }
        else if(cat.contains("tools"))
        {
            setContentView(R.layout.activity_tools_interior);
        }
        else if(cat.contains("zoo"))
        {
            if(cat.contains("birds"))
            {
                setContentView(R.layout.activity_zoo_birds_interior);
            }
            else if(cat.contains("water"))
            {
                setContentView(R.layout.activity_zoo_water_interior);
            }
            else if(cat.contains("dino"))
            {
                setContentView(R.layout.activity_zoo_dinosaurs_interior);
            }
            else if(cat.contains("meat"))
            {
                setContentView(R.layout.activity_zoo_meat_interior);
            }
            else if(cat.contains("monkey"))
            {
                setContentView(R.layout.activity_zoo_monkeys_interior);
            }
            else if(cat.contains("reptiles"))
            {
                setContentView(R.layout.activity_zoo_reptiles_interior);
            }
            else if(cat.contains("plant"))
            {
                setContentView(R.layout.activity_zoo_plant_interior);
            }
            else
            {
                setContentView(R.layout.activity_zoo_interior);
            }
        }
        else if(cat.contains("plant"))
        {
            setContentView(R.layout.activity_plant_interior);
        }
        else if(cat.contains("farm"))
        {
            setContentView(R.layout.activity_farm_interior);
        }
        else if(cat.contains("school"))
        {
            setContentView(R.layout.activity_school_interior);
        }
        else if(cat.contains("health"))
        {
            setContentView(R.layout.activity_medical_interior);
        }
        else if(cat.contains("restaurant"))
        {
            setContentView(R.layout.activity_restaurant_interior);
        }
        else if(cat.contains("things"))
        {
            setContentView(R.layout.activity_peopledo_interior);
        }
        else if(cat.contains("people"))
        {
            setContentView(R.layout.activity_people_interior);
        }
        else if(cat.contains("hats"))
        {
            setContentView(R.layout.activity_hats_interior);
        }
        else if(cat.contains("shoes"))
        {
            setContentView(R.layout.activity_shoes_interior);
        }
        else if(cat.contains("wares"))
        {
            setContentView(R.layout.activity_housewares_interior);
        }
        else if(cat.contains("ocean"))
        {
            setContentView(R.layout.activity_ocean_creatures_interior);
        }
        else if(cat.contains("wild"))
        {
            setContentView(R.layout.activity_wild_animals_interior);
        }
        else if(cat.contains("places"))
        {
            setContentView(R.layout.activity_places_interior);
        }
        else if(cat.contains("weather"))
        {
            setContentView(R.layout.activity_sky_interior);
        }
        else if(cat.contains("creatures"))
        {
            setContentView(R.layout.activity_beach_interior);
        }
        else if(cat.contains("enchanted"))
        {
            setContentView(R.layout.activity_enchanted_interior);
        }
        else if(cat.contains("gear"))
        {
            setContentView(R.layout.activity_gear_interior);
        }
        else if(cat.contains("pediatrician"))
        {
            setContentView(R.layout.activity_pediatrician_interior);
        }
        else if(cat.contains("park"))
        {
            if(cat.equals("park1"))
            {
                setContentView(R.layout.activity_park_1);
            }
            else if(cat.equals("park2"))
            {
                setContentView(R.layout.activity_park_2);
            }
            else if(cat.equals("park3"))
            {
                setContentView(R.layout.activity_park_3);
            }
            else
            {
                setContentView(R.layout.activity_park_interior);
            }
        }
        else if(cat.equals("building7"))
        {
            setContentView(R.layout.activity_building7);
        }
        else
        {
            setContentView(R.layout.activity_house_interior);
        }

        play = new MediaPlayer();

    }

    public void openCategory(View view)
    {
        String tag = view.getTag().toString();
        String cat = Parse(tag); //get cat
        playCategorySound(cat);
        Intent itemsActivity = new Intent(this, DisplayItems.class);
        Bundle b = new Bundle();
        b.putString("cat",tag);
        itemsActivity.putExtras(b);
        startActivity(itemsActivity);
    }

    public void playSound(View view)
    {
        String tag = view.getTag().toString();
        AssetFileDescriptor openassets;

        if(!play.isPlaying())
        {
            try
            {
                play.reset();
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



    }

    public void openInterior(View view)
    {
        String tag = view.getTag().toString();
        playCategorySound(cat);
        Intent interiorActivity = new Intent(this, Interior.class);
        Bundle b = new Bundle();
        b.putString("cat",tag);
        interiorActivity.putExtras(b);
        startActivity(interiorActivity);
        //finish();
    }

    public void goHome (View view)
    {
        Intent home = new Intent(Interior.this, MainActivity.class);
        startActivity(home);
    }

    public void goBack(View view)
    {
        finish();
    }

    public void openQuiz (View view)
    {
        String tag = view.getTag().toString();
        Intent quizActivity = new Intent(Interior.this, Quiz.class);
        Bundle b = new Bundle();
        b.putString("cat", tag);
        quizActivity.putExtras(b);
        startActivity(quizActivity);

    }

    public String Parse(String tag)
    {
        String[] path = tag.split("/");
        return path[path.length-1];
    }

    public void playCategorySound(String cat)
    {
        AssetFileDescriptor openassets;

        if(!play.isPlaying())
        {
            try
            {
                play.reset();
                //open audio file from Assets folder
                openassets = getAssets().openFd("xtra/HEADINGS/00" + cat + ".mp3");

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


}
