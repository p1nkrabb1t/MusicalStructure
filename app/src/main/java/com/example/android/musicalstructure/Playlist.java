package com.example.android.musicalstructure;

/**
 * Created by Ha3el on 15/04/2018.
 */

/**
 * Displays brief playlist summary
 */
public class Playlist {

    // Integer value
    private int mImageResourceId;

    // String value
    private String mPlaylistName;

    // String value
    private String mGenre;

    // String value
    private String mTracks;

    // String value
    private String mPlaylistLength;


    /**
     * Constructs a new object containing image, name, genre, number of tracks and length
     */
    public Playlist(String PlaylistName, String Genre, String Tracks, String PlaylistLength) {
        mPlaylistName = PlaylistName;
        mGenre = Genre;
        mTracks = Tracks;
        mPlaylistLength = PlaylistLength;
    }

    /**
     * Constructs a new object containing image, name, genre, number of tracks and length
     */
    public Playlist(int ImageResourceId, String PlaylistName, String Genre, String Tracks, String PlaylistLength) {
        mImageResourceId = ImageResourceId;
        mPlaylistName = PlaylistName;
        mGenre = Genre;
        mTracks = Tracks;
        mPlaylistLength = PlaylistLength;
    }

    // Get the image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

    //get the playlist name
    public String getPlaylistName() {
        return mPlaylistName;
    }

    //allow user to name the playlist
    public void setPlaylistName(String PlaylistName) {
        mPlaylistName = PlaylistName;
    }

    //get the music genre
    public String getGenre() {
        return ("Genre: " + mGenre);
    }

    //allow user to set the genre
    public void setGenre(String Genre) {
        mGenre = Genre;
    }

    //get the number of tracks
    public String getTracks() {
        return ("Tracks: " + mTracks);
    }

    //get the duration
    public String getPlaylistLength() {
        return ("Length: " + mPlaylistLength);
    }


}
