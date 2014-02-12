package ApiSound;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Lucas
 */
public class Tone extends Note {

    private SoundFactory.Tones tone;
    
    public Tone(SoundFactory.Tones tone) {
        this(tone, 1);
    }
    
    public Tone(SoundFactory.Tones tone, double duration) {
        super(duration);
        this.tone = tone;
    }
    
    @Override
    public void play() throws LineUnavailableException {
        SoundFactory.sound(tone, duration);
    }
    
}
