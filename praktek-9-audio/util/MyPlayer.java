package util;

import java.io.*;
import javax.sound.sampled.*;

public class MyPlayer {

    private AudioInputStream ais;
    private Clip clip;

    public MyPlayer(String filePath) {
        ais = AudioSystem.getInputStream(new File(filePath).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(ais);
    }

    public void play() {
        clip.start();
    }

    public void pause() {}

    public void resume() {}

    public void restart() {}

    public void stop() {
        clip.stop();
        clip.close();
    }

}