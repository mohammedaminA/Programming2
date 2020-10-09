/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlistappstarter;

import model.Track;

/**
 *
 * @author mga
 */
public class TrackTest {
    
     /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Track track1 = new Track();
        System.out.print(track1);
        
        Track track2 = new Track("O Valencia!", "The Decemberists", 327);
        System.out.println(track2);
        
        Track track3 = new Track(3, "Abacab", "Genesis", 489);
        System.out.println(track3);
        
        Track track4 = new Track("At Seventeen", "Janis Ian", 198);
        System.out.println(track4);
        
        System.out.println("Track 4 ID:" + Integer.toString(track4.getTrackId()));
        
        System.out.println("Track 4 Title: " + track4.getTrackTitle());
        track4.setTrackTitle("Tangled Up In Blue");
        System.out.println("Track 4 Title: " + track4.getTrackTitle());
        
        System.out.println("Track 4 Artist: " + track4.getTrackArtist());
        track4.setTrackArtist("Bob Dylan");
        System.out.println("Track 4 Artist: " + track4.getTrackArtist());        

        System.out.println("Track 4 Length: " + track4.getTrackLength());
        track4.setTrackLength(359);
        System.out.println("Track 4 Length: " + Integer.toString(track4.getTrackLength()));        
    }
}
