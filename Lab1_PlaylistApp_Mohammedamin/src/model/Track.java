

package model;

/**
 *
 * @author mohammedaminA
 */
public class Track {
    private final int trackId;
    private String trackTitle;
    private String trackArtist;
    private int trackLength;
    
    private static int lastAllocatedTrackId = 0;
    
    public Track() {
        this.trackId = ++lastAllocatedTrackId;
    }
    
    public Track(String trackTitle, String trackArtist, int trackLength) {
        this.trackId = ++lastAllocatedTrackId;
        this.trackTitle = trackTitle;
        this.trackArtist = trackArtist;
        this.trackLength = trackLength;
    }
    
     
    public Track(int trackId, String trackTitle, String trackArtist, int trackLength) {
        
    
        if (trackId > lastAllocatedTrackId){
            lastAllocatedTrackId = trackId;
            this.trackTitle = trackTitle;
            this.trackArtist = trackArtist;
            this.trackLength = trackLength;
            this.trackId=trackId;
                                        }
        else    {
        this.trackId = ++lastAllocatedTrackId;
        this.trackTitle = trackTitle;
        this.trackArtist = trackArtist;    
               }
    
   
    }
    
    public int getTrackId() {
        return this.trackId;
    }
    
   public String getTrackArtist(){
        return this.trackArtist;
    }
   public void setTrackArtist( String trackArtist){
        this.trackArtist= trackArtist;
    }
    public String getTrackTitle() {
        return this.trackTitle;
    }
    
    public void setTrackTitle(String trackTitle) {
        this.trackTitle = trackTitle;
    }
    
    
    public int getTrackLength(){
        return this.trackLength;
    }

    public void  setTrackLength(int trackLength){
         this.trackLength=trackLength;
    }
    
    
    private int getTrackLengthMinutes() {
        return this.trackLength/60;
    }
    
    
    private int getTrackLengthSeconds() {
        return this.trackLength % 60;
    }
    
    
    public String toString() {
        return "\nId: " + Integer.toString(this.trackId) +
                " Title: " + this.trackTitle +
                " Artist: " + this.trackArtist +
                " Length: " + Integer.toString(getTrackLengthMinutes()) + ":" + Integer.toString(getTrackLengthSeconds()) + "\n";
    }
}

