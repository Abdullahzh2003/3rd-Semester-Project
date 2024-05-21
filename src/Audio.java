import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Audio {
    private Clip clip;
    Audio(String a) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File(a);

        // Create an AudioInputStream from the file
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

        // Create a Clip object
        clip = AudioSystem.getClip();

        // Open the audioInputStream with the clip
        clip.open(audioInputStream);
    }
    public void start(){
        clip.setMicrosecondPosition(0);
        clip.start();
    }

}
