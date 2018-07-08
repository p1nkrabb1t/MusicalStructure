package com.example.android.musicalstructure;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ha3el on 17/04/2018.
 */

public class TracklistAdapter extends ArrayAdapter<Track> {

    public String trackNamePlaying;

    public TracklistAdapter(Activity context, ArrayList<Track> tracklist) {
        super(context, 0, tracklist);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.tracklist_item, parent, false);
        }


        // Get the tracklist object located at this position in the list
        Track currentTrack = getItem(position);


        // Find and update the TextView in the tracklist_item.xml layout with the track number
        TextView trackNumTextView = (TextView) listItemView.findViewById(R.id.tv_track_num);
        trackNumTextView.setText(currentTrack.getTrackNum());
        trackNamePlaying = currentTrack.getTrackNum();


        // Find and update the TextView in the tracklist_item.xml layout with the track name
        TextView trackNameTextView = (TextView) listItemView.findViewById(R.id.tv_track_name);
        trackNameTextView.setText(currentTrack.getTrackName());

        // Find and update the TextView in the tracklist_item.xml layout with the artist name
        TextView artistNameTextView = (TextView) listItemView.findViewById(R.id.tv_artist);
        artistNameTextView.setText(currentTrack.getArtist());

        // Find and update the TextView in the tracklist_item.xml layout with the track length
        TextView trackLengthTextView = (TextView) listItemView.findViewById(R.id.tv_track_length);
        trackLengthTextView.setText(currentTrack.getTrackLength());

        // Find and update the ButtonView in the tracklist_item.xml layout with a play/pause image
        final ImageView playPauseButton = listItemView.findViewById(R.id.btn_track);
        playPauseButton.setBackgroundResource(currentTrack.getDrawableID());


//        // Set a click listener on the track item play/pause button
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            Boolean playing = false;

            // The code in this method will be executed when the button View is clicked on.
            @Override
            public void onClick(View view) {
                if (!playing) {

                    playPauseButton.setBackgroundResource(R.drawable.button_pause);
                    playing = true;
                } else if (playing) {

                    playPauseButton.setBackgroundResource(R.drawable.button_play);
                    playing = false;
                }
            }


        });


        return listItemView;
    }

}
