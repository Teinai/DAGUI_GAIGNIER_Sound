package ApiSound;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Lucas
 */
public abstract class Playable {
    
    public abstract void play() throws LineUnavailableException;
    
}

