
import java.io.File;
import static java.time.Clock.system;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
/*
 *
 * @author Tasmin Karim
 */
public class musicSheet {
    
    void playMusic(String musicLocation)
    {
        
        try
        {
        
            File musicPath = new File(musicLocation);
            
            if(musicPath.exists())
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
             
                
            }
            else
            {
                
                System.out.println("can't fine any file");
            }
            
        }
        
        catch(Exception ex)
        {
            ex.printStackTrace();
        
        }
        
    }
}
