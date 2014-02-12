package ApiSound;


import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Lucas
 */
public abstract class Note extends Playable {
    
    protected double duration;
    
    /**
     * Default constructor setting the Note duration to 1.
     */
    public Note() {
        duration = 1;
    }
    
    /**
     * Constructor used when the duration of the note is not the base time 
     * mesure of the score.
     * 
     * @param duration relative duration of the Note within a score.
     */
    public Note(double duration) {
        this.duration = duration;
    }
    
    /**
     * 
     * @return Duration of the Note.
     */
    public double getDuration() {
        return duration;
    }
    
    @Override
    public abstract void play() throws LineUnavailableException;
    
}
