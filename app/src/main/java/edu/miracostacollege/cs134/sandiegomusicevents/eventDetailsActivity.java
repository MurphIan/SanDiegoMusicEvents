package edu.miracostacollege.cs134.sandiegomusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class eventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventTitleTextView;
    private TextView eventDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details_activity);

        //Lets recieve the intent
        Intent mainIntent = getIntent();

        //Lets extract the artist and details from the intent
        String artist = mainIntent.getStringExtra("Artist");
        String details = mainIntent.getStringExtra("Details");
        String imageName = artist.replaceAll(" ", "") + ".png";

        //Link the Controller with the views
        eventImageView = findViewById(R.id.eventImageView);
        eventTitleTextView = findViewById(R.id.eventTitleTextview);
        eventDetails = findViewById(R.id.eventDetailTextView);

        //Fill the views with information
        eventTitleTextView.setText(artist);
        eventDetails.setText(details);
        //Use the AssetManager to load the correct image
        AssetManager am = getAssets();

        //Define an InputSteam to select image
        try
        {
            InputStream stream = am.open(imageName);
            //Create a drawable object to display
            Drawable eventImage = Drawable.createFromStream(stream, artist);
            eventImageView.setImageDrawable(eventImage);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
