/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlistappstarter;

import java.util.ArrayList;
import model.Playlist;
import model.Track;

/**
 *
 * @author mga
 */
public class PlaylistTest {
     /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Playlist playlist1 = new Playlist();
        System.out.print(playlist1);
        
        Playlist playlist2 = new Playlist("The Decemberists", "MLG");
        System.out.println(playlist2);
        
        Track track1 = new Track(1, "Abacab", "Genesis", 489);
        Track track2 = new Track(2, "Watcher Of The Skies", "Genesis", 532);
        Track track3 = new Track(3, "Sign Your Life Away", "Genesis", 432);      
        
        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track1);
        tracks.add(track2);
        tracks.add(track3);
        
        Playlist playlist3 = new Playlist("Genesis", "LPK", tracks);
        System.out.println(playlist3);   

        System.out.println("Playlist 3 Name: " + playlist3.getPlaylistName());
        playlist3.setPlaylistName("Genesis Solo");
        System.out.println("Playlist 3 Name: " + playlist3.getPlaylistName());
        
        System.out.println("Playlist 3 Author: " + playlist3.getPlaylistAuthor());
        playlist3.setPlaylistAuthor("MLG");
        System.out.println("Playlist 3 Author: " + playlist3.getPlaylistAuthor());
        
        System.out.println("Playlist 3 Tracks: " + playlist3.getPlaylistTracks());
        Track track4 = new Track(4, "In The Air Tonight", "Phil Collins", 289);
        Track track5 = new Track(5, "A Curious Feeling", "Tony Banks", 532);
        Track track6 = new Track(6, "Biko", "Peter Gabriel", 632);      
        
        ArrayList<Track> tracks2 = new ArrayList<>();
        tracks2.add(track4);
        tracks2.add(track5);
        tracks2.add(track6);        
        playlist3.setPlaylistTracks(tracks2);
        System.out.println("Playlist 3 Tracks: " + playlist3.getPlaylistTracks());
        
        Track track7 = new Track(7, "Cats And Rats In The Neighbourhood", "Mike Rutherford", 242);
        playlist3.addTrackToPlaylist(track7);
        System.out.println(playlist3);       
        
        playlist3.removeTrackFromPlaylist(5);
        System.out.println(playlist3);           
    }    
}
