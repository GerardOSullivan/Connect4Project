package Connect4;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Audio {

    //John helped me with the audio :) I also got some help from this video https://www.youtube.com/watch?v=TErboGLHZGA&ab_channel=MaxO%27Didily 25/11/20

    /*****************************************************
     *    Title:  Installing audio
     *    Author: N/A
     *    Site owner/sponsor:  John Brosnan
     *    Date: 25/11/20
     *    Code version: N/A
     *    Availability:  Lecture
     (Accessed 25 November 2020)
     *    Modified:  Code refactored (Identifiers renamed)
     *****************************************************/

    /*****************************************************
     *    Title:  Installing audio
     *    Author: N/A
     *    Site owner/sponsor: Max O'Diddly, Youtube
     *    Date: 25/11/20
     *    Code version: N/A
     *    Availability:  https://www.youtube.com/watch?v=TErboGLHZGA&ab_channel=MaxO%27Didily
     (Accessed 25 November 2020)
     *    Modified:  Code refactored (Identifiers renamed)
     *****************************************************/

    public static void playAudio(String path){
        try{
                File musicPath = new File(path);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip audioClip = AudioSystem.getClip();
                audioClip.open(audioInput);
                audioClip.start();

                if(path.equals("Connect4\\Sounds\\BackgroundMusic.wav"))
                {
                    audioClip.loop(Clip.LOOP_CONTINUOUSLY);
                }

        }
        catch(Exception e)
        {
            System.out.println("The audio file " + path + " could not be played!");
        }

    }
}
