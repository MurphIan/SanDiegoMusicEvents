package edu.miracostacollege.cs134.sandiegomusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.miracostacollege.cs134.sandiegomusicevents.model.MusicEvent;

public class MainActivity extends ListActivity {
    ListView eventListView;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        //extract info we need
        String artist = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        //Lets make the intent
        Intent detailsIntent = new Intent(this, eventDetailsActivity.class);
        detailsIntent.putExtra("Artist", artist);
        detailsIntent.putExtra("Details", details);

        //Start the activity
        startActivity(detailsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //since the layout os being inflated dont set the content view
        //setContentView(R.layout.activity_main);

        eventListView = findViewById(R.id.eventsListView);

        //We want to connect our listView with an ArrayAdapter to fill out the data
        ArrayAdapter<String> eventAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, MusicEvent.titles);

        setListAdapter(eventAdapter);
    }
}
