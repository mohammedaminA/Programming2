/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package playlistappstarter;

/**
 *
 * @author mga
 */
public class PlaylistAppStarter {

    public static void run() {        
        System.out.println("PlaylistApp\n========\n\n");
        
        PlaylistController playlistController = new PlaylistController();  
        
        playlistController.run();
        
        System.out.println("Thank you for using PlaylistApp. Good bye.\n");        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PlaylistAppStarter playlistApp = new PlaylistAppStarter();
        playlistApp.run();
    }
    
}
