package Connect4;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.awt.*;
import java.io.File;

public class Audio {

    //John helped me with the audio :) I also got some help from this video https://www.youtube.com/watch?v=TErboGLHZGA&ab_channel=MaxO%27Didily 25/11/20
    public static void playAudio(String path){
        try{
                File musicPath = new File(path);
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip audioClip = AudioSystem.getClip();
                audioClip.open(audioInput);
                audioClip.start();

                if(path=="C:\\Users\\Gerard\\IdeaProjects\\Connect4Project\\Connect4\\Sounds\\BackgroundMusic.wav")
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
