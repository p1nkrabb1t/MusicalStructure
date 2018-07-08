package com.example.android.musicalstructure;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.Image;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Chronometer;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class NowPlayingActivity extends AppCompatActivity {
    Chronometer elapsed;
    ArrayList<Track> tracklist;
    int playlistChosen;
    Track now;
    boolean playing = false;
    int drawableID = R.drawable.button_play;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Bundle bundle = getIntent().getExtras();
        playlistChosen = bundle.getInt("KEY_PLAYLIST");


        switch (playlistChosen) {
            case 0:
                playlist1();
                loadAdapter();
                break;

            case 1:
                playlist2();
                loadAdapter();
                break;

            case 2:
                playlist3();
                loadAdapter();
                break;

            case 3:
                back();
                break;

        }

    }


    public void loadAdapter() {
        final TracklistAdapter adapter = new TracklistAdapter(this, tracklist);
        ListView listView = (ListView) findViewById(R.id.lv_current_tracklist);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                now = tracklist.get(position);
                playing = true;
                drawableID = R.drawable.button_pause;

            }
        });


    }

    // Create an array of tracks for playlist 1
    public void playlist1() {
        tracklist = new ArrayList<>();

        if (playing) {
            drawableID = R.drawable.button_pause;
        } else {
            drawableID = R.drawable.button_play;
        }

        tracklist.add(new Track("1", "Adagio", "Tiesto", "3:00", drawableID));
        tracklist.add(new Track("2", "For An Angel", "Paul Van Dyk", "3:00", drawableID));
        tracklist.add(new Track("3", "Cafe Del Mar", "Energy 52", "3:00", drawableID));
        tracklist.add(new Track("4", "Big Sky", "John O'Callaghan", "3:00", drawableID));
    }

    // Create an array of tracks for playlist 2
    public void playlist2() {
        tracklist = new ArrayList<>();

        tracklist.add(new Track("1", "House Music", "Eddie Amador", "3:00", drawableID));
        tracklist.add(new Track("2", "I Don't Want Nobody Baby", "Tom Novy", "3:00", drawableID));
        tracklist.add(new Track("3", "Hideaway", "Kiesza", "3:00", drawableID));
        tracklist.add(new Track("4", "Infinity", "Infinity Ink", "3:00", drawableID));
    }

    // Create an array of tracks for playlist 3
    public void playlist3() {
        tracklist = new ArrayList<>();

        tracklist.add(new Track("1", "Riverside", "Sidney Samson", "3:00", drawableID));
        tracklist.add(new Track("2", "Freaks", "The Creeps", "3:00", drawableID));
        tracklist.add(new Track("3", "Let Me Think About it", "Fedde Le Grand", "3:00", drawableID));
        tracklist.add(new Track("4", "Ghosts n Stuff", "Deadmau5", "3:00", drawableID));
    }


    public void back() {
        Toast.makeText(this, "playlist is empty. Please choose another", LENGTH_LONG).show();
        Intent i = new Intent(NowPlayingActivity.this, MainActivity.class);
        startActivity(i);
    }


}
