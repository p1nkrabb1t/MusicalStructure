package com.example.android.musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class NowPlayingActivity extends AppCompatActivity {
    ArrayList<Track> tracklist;
    int playlistChosen;
    int numPlaylists;
    Track now;
    boolean playing = false;
    int drawableID = R.drawable.button_play;
    String name;
    String genre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Bundle bundle = getIntent().getExtras();
        playlistChosen = bundle.getInt("KEY_PLAYLIST");
        numPlaylists = bundle.getInt("KEY_NUM_PLAYLISTS");
        setTracklist();
        setTitle();

        Button back = findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                back();
            }
        });
        Button next = findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                playlistChosen = (playlistChosen + 1);
                if (playlistChosen < numPlaylists) {

                } else {
                    playlistChosen = 0;
                    Toast.makeText(NowPlayingActivity.this, R.string.end_of_playlists, Toast.LENGTH_LONG).show();
                }
                setTracklist();
                setTitle();
            }

        });
    }

    public void setTracklist() {
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
                Toast.makeText(this, R.string.empty_playlist, LENGTH_LONG).show();
                back();
                break;

        }
    }

    public void loadAdapter() {
        final TracklistAdapter adapter = new TracklistAdapter(this, tracklist);
        adapter.notifyDataSetChanged();
        ListView listView = findViewById(R.id.lv_current_tracklist);
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

    public void setTitle() {
        TextView titleTextView = findViewById(R.id.tv_current_playlist);
        titleTextView.setText(getString(R.string.title_now_playing, name, genre));
    }

    // Create an array of tracks for playlist 1
    public void playlist1() {
        name = "Playlist 1";
        genre = getString(R.string.genre_trance);

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
        name = "Playlist 2";
        genre = getString(R.string.genre_house);
        tracklist = new ArrayList<>();

        tracklist.add(new Track("1", "House Music", "Eddie Amador", "3:00", drawableID));
        tracklist.add(new Track("2", "I Don't Want Nobody Baby", "Tom Novy", "3:00", drawableID));
        tracklist.add(new Track("3", "Hideaway", "Kiesza", "3:00", drawableID));
        tracklist.add(new Track("4", "Infinity", "Infinity Ink", "3:00", drawableID));
    }

    // Create an array of tracks for playlist 3
    public void playlist3() {
        name = "Playlist 3";
        genre = getString(R.string.genre_electro);
        tracklist = new ArrayList<>();

        tracklist.add(new Track("1", "Riverside", "Sidney Samson", "3:00", drawableID));
        tracklist.add(new Track("2", "Freaks", "The Creeps", "3:00", drawableID));
        tracklist.add(new Track("3", "Let Me Think About it", "Fedde Le Grand", "3:00", drawableID));
        tracklist.add(new Track("4", "Ghosts n Stuff", "Deadmau5", "3:00", drawableID));
    }


    public void back() {
        Intent i = new Intent(NowPlayingActivity.this, MainActivity.class);
        startActivity(i);
    }

}
