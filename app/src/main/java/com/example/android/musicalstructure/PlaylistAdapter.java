package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ha3el on 15/04/2018.
 */

public class PlaylistAdapter extends ArrayAdapter<Playlist> {

    public PlaylistAdapter(Activity context, ArrayList<Playlist> playlistsAvailable) {
        super(context, 0, playlistsAvailable);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.playlist_item, parent, false);
        }
        // Get the playlist object located at this position in the list
        Playlist currentPlaylist = getItem(position);

        // Find and update the ImageView in the playlist_item.xml layout with the image ID
        ImageView playlistImageView = listItemView.findViewById(R.id.image);
        playlistImageView.setImageResource(currentPlaylist.getImageResourceId());

        // Find and update the TextView in the playlist_item.xml layout with the ID playlist_name
        TextView playlistNameTextView = (TextView) listItemView.findViewById(R.id.playlist_name);
        playlistNameTextView.setText(currentPlaylist.getPlaylistName());

        // Find and update the TextView in the playlist_item.xml layout with the ID Genre
        TextView genreTextView = (TextView) listItemView.findViewById(R.id.genre);
        genreTextView.setText(currentPlaylist.getGenre());

        // Find and update the TextView in the playlist_item.xml layout with the ID num_tracks
        TextView tracksTextView = (TextView) listItemView.findViewById(R.id.num_tracks);
        tracksTextView.setText(currentPlaylist.getTracks());

        // Find and update the TextView in the playlist_item.xml layout with the ID playlist_length
        TextView lengthTextView = (TextView) listItemView.findViewById(R.id.playlist_length);
        lengthTextView.setText(currentPlaylist.getPlaylistLength());



        return listItemView;
    }
}
