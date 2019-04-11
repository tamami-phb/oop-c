package util;

import java.io.*;
import javax.sound.sampled.*;

public class MyPlayer {

    private AudioInputStream ais;
    private Clip clip;
    private String filePath;

    public MyPlayer(String filePath) throws
            UnsupportedAudioFileException,
            LineUnavailableException, IOException {
        ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
        this.filePath = filePath;
    }

    public void play() {
        clip.start();
    }

    public void pause() {}

    public void resume() {}

    public void restart() {}

    public void stop() throws LineUnavailableException, IOException,
            UnsupportedAudioFileException {
        clip.stop();
        clip.close();
        reset();
    }

    public void reset() throws LineUnavailableException, IOException,
            UnsupportedAudioFileException {
        ais = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

}