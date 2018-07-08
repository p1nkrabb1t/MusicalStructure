package com.example.android.musicalstructure;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Ha3el on 17/04/2018.
 */

public class Track {

    // String value
    private String mTrackNum;

    // String value
    private String mTrackName;

    // String value
    private String mArtist;

    // String value
    private String mTrackLength;

    // Integer value
    private int mDrawableId;

    // String value
    private String mPlaylistName;

    // String value
    private String mGenre;


    /**
     * Constructs a new track object
     */
    public Track(String TrackNum, String TrackName, String Artist, String TrackLength, int DrawableId) {
        mTrackNum = TrackNum;
        mTrackName = TrackName;
        mArtist = Artist;
        mTrackLength = TrackLength;
        mDrawableId = DrawableId;
    }


    //get the track number
    public String getTrackNum() {
        return mTrackNum;
    }

    //get the track name
    public String getTrackName() {
        return mTrackName;
    }

    //get the artist name
    public String getArtist() {
        return mArtist;
    }

    //get the track length
    public String getTrackLength() {
        return ("Length: " + mTrackLength);
    }

    //Get the image resource ID
    public int getDrawableID() {
        return mDrawableId;
    }


    //allow user to name the playlist
    public void setPlaylistName(String PlaylistName) {
        mPlaylistName = PlaylistName;
    }

    //allow user to set the genre
    public void setGenre(String Genre) {
        mGenre = Genre;
    }


}