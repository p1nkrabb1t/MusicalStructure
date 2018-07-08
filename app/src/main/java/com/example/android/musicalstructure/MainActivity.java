package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an array of playlists
        final ArrayList<Playlist> playlistsAvailable = new ArrayList<>();
        playlistsAvailable.add(new Playlist(R.drawable.image1, "Playlist 1", "Trance", "10", "30:00"));
        playlistsAvailable.add(new Playlist(R.drawable.image2, "Playlist 2", "House", "10", "30:00"));
        playlistsAvailable.add(new Playlist(R.drawable.image3, "Playlist 3", "Electro", "10", "30:00"));
        playlistsAvailable.add(new Playlist(R.drawable.image4, "Playlist 4", "Techno", "10", "30:00"));


        PlaylistAdapter adapter = new PlaylistAdapter(this, playlistsAvailable);

        GridView gridView = (GridView) findViewById(R.id.gv_playlists);

        gridView.setAdapter(adapter);
        final int numPlaylists = playlistsAvailable.size();

        // Set a click listener on the playlist item
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent i = new Intent(MainActivity.this, NowPlayingActivity.class);
                i.putExtra("KEY_PLAYLIST", position);
                i.putExtra("KEY_NUM_PLAYLISTS", numPlaylists);
                startActivity(i);
            }
        });

    }

}