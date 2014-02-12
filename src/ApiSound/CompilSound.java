/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ApiSound;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Lucas
 */
public class CompilSound {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //SoundFactory.DEFAULT_SCALE = 5;
        Sequence sequence = new Sequence(480);
        Sequence sequence2 = new Sequence(260);
        Sequence sequence3 = new Sequence(260);
        sequence2.add(new Tone(SoundFactory.Tones.SOL));
        sequence2.add(new Tone(SoundFactory.Tones.SOL));
        sequence2.add(new Tone(SoundFactory.Tones.SOL));
        sequence2.add(new Tone(SoundFactory.Tones.LA));
        sequence2.add(new Tone(SoundFactory.Tones.SI, 2));
        sequence2.add(new Tone(SoundFactory.Tones.LA, 2));
        sequence2.add(new Tone(SoundFactory.Tones.SOL));
        sequence2.add(new Tone(SoundFactory.Tones.SI));
        sequence2.add(new Tone(SoundFactory.Tones.LA));
        sequence2.add(new Tone(SoundFactory.Tones.LA));
        sequence2.add(new Tone(SoundFactory.Tones.SOL, 3));
        sequence2.add(new Tone(SoundFactory.Tones.SILENCE));
        
        sequence3.add(new Tone(SoundFactory.Tones.LA));
        sequence3.add(new Tone(SoundFactory.Tones.LA));
        sequence3.add(new Tone(SoundFactory.Tones.LA));
        sequence3.add(new Tone(SoundFactory.Tones.LA));
        sequence3.add(new Tone(SoundFactory.Tones.MI, 2));
        sequence3.add(new Tone(SoundFactory.Tones.MI, 2));
        sequence3.add(new Tone(SoundFactory.Tones.LA));
        sequence3.add(new Tone(SoundFactory.Tones.SOL));
        sequence3.add(new Tone(SoundFactory.Tones.FAD));
        sequence3.add(new Tone(SoundFactory.Tones.MI));
        sequence3.add(new Tone(SoundFactory.Tones.RE, 4));

        sequence.add(sequence2);
        sequence.add(sequence2);
        sequence.add(sequence3);
        sequence.add(sequence2);
        
        System.out.println("Coucou");
        try {
            sequence.play();
        } catch (LineUnavailableException ex) {
            System.out.println("Exception !");
            Logger.getLogger(CompilSound.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
