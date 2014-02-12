package ApiSound;

import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author Lucas
 */
public class SoundFactory {
    
	public static float SAMPLE_RATE = 8000f;
    public static int DEFAULT_SCALE = 4;
    public static double DFAULT_VOLUME = 1;
    public static int DEFAULT_MSECS = 1000;
    public static boolean USE_DEFAULT = false;
    public static Score score = Score.getInstance();
    public static Sequence sequence = new Sequence();
    public static ArrayList<Tone> toneList = new ArrayList<Tone>();
    
    public enum Tones {
        DO(32.70f, 65.41f, 130.81f, 261.63f, 523.25f, 1046.50f, 2093.00f, 4186.01f),
        DOD(34.65f, 69.30f, 138.59f, 277.18f, 554.37f, 1108.73f, 2217.46f, 4434.92f),
        REB(34.65f, 69.30f, 138.59f, 277.18f, 554.37f, 1108.73f, 2217.46f, 4434.92f),
        RE(36.71f, 73.42f, 146.83f, 293.66f, 587.33f, 1174.66f, 2349.32f, 4698.64f),
        RED(38.89f, 77.78f, 155.56f, 311.13f, 622.25f, 1244.51f, 2489.02f, 4978.03f),
        MIB(38.89f, 77.78f, 155.56f, 311.13f, 622.25f, 1244.51f, 2489.02f, 4978.03f),
        MI(41.20f, 82.41f, 164.81f, 329.63f, 659.26f, 1318.51f, 2637.02f, 5274.04f),
        FA(43.65f, 87.31f, 174.61f, 349.23f, 698.46f, 1396.91f, 2793.83f, 5587.65f),
        FAD(46.25f, 92.50f, 185.00f, 369.99f, 739.99f, 1479.98f, 2959.96f, 5919.91f),
        SOLB(46.25f, 92.50f, 185.00f, 369.99f, 739.99f, 1479.98f, 2959.96f, 5919.91f),
        SOL(49.00f, 98.00f, 196.00f, 392.00f, 783.99f, 1567.98f, 3135.96f, 6271.93f),
        SOLD(51.91f, 103.83f, 207.65f, 415.30f, 830.61f, 1661.22f, 3322.44f, 6644.88f),
        LAB(51.91f, 103.83f, 207.65f, 415.30f, 830.61f, 1661.22f, 3322.44f, 6644.88f),
        LA(55.00f, 110.00f, 220.00f, 440.00f, 880.00f, 1760.00f, 3520.00f, 7040.00f),
        LAD(58.27f, 116.54f, 233.08f, 466.16f, 932.33f, 1864.66f, 3729.31f, 7458.62f),
        SIB(58.27f, 116.54f, 233.08f, 466.16f, 932.33f, 1864.66f, 3729.31f, 7458.62f),
        SI(61.74f, 123.47f, 246.94f, 493.88f, 987.77f, 1975.53f, 3951.07f, 7902.13f),
        SILENCE(0.01f, 0.01f, 0.01f, 0.01f, 0.01f, 0.01f, 0.01f, 0.01f );
        
        private float[] value = new float[8];

        private Tones(float value0, float value1, float value2, float value3, float value4, float value5, float value6, float value7) {
            this.value[0] = value0;
            this.value[1] = value1;
            this.value[2] = value2;
            this.value[3] = value3;
            this.value[4] = value4;
            this.value[5] = value5;
            this.value[6] = value6;
            this.value[7] = value7;
            
        }
        
        protected float getValue(int index){
            return this.value[index];
        }
    }   
    
    public static Score getScore() {
    	return score;
    }
    
    public static Sequence getSequence() {
		return sequence;
	}
    
    public static ArrayList<Tone> createToneList() {
    	toneList = new ArrayList<Tone>();
    	return toneList;
    }
    
    public static ArrayList<Tone> getToneList() {
		return toneList;
	}

	public static Sequence createSequence(int bpm, ArrayList<Tone> tones) {
    	sequence = new Sequence(bpm);
    	for(Tone t : tones) sequence.add(t);
    	return sequence;
    }
	
    public static Tone createTone(Tones hight, float duration) {
    	return new Tone(hight, duration);
    }

	public static void setBPM(int bpm) {
        DEFAULT_MSECS = 60000/bpm;
    }
    
    public static void sound(Tones tone) throws LineUnavailableException {
        SoundFactory.sound(tone, DEFAULT_SCALE, DEFAULT_MSECS, DFAULT_VOLUME);
    }
    
    public static void sound(Tones tone, int scale, int msecs) throws LineUnavailableException {
        sound(tone, scale, msecs, DFAULT_VOLUME);
    }
    
    public static void sound(Tones tone, double duration) throws LineUnavailableException {
        sound(tone, DEFAULT_SCALE, (int) (DEFAULT_MSECS*duration), 1);
    }
    
    public static void sound(Tones tone, int msecs) throws LineUnavailableException {
        SoundFactory.sound(tone, DEFAULT_SCALE, msecs, 1);
    }
    
    public static void sound(Tones note, int scale, int msecs, double vol) throws LineUnavailableException {
        
         float hz = note.getValue(scale);
        
         if (hz <= 0)
             throw new IllegalArgumentException("Frequency <= 0 hz");
         if (msecs <= 0)
             throw new IllegalArgumentException("Duration <= 0 msecs");
         if (vol > 1.0 || vol < 0.0)
             throw new IllegalArgumentException("Volume out of range 0.0 - 1.0");

         byte[] buf = new byte[(int)SAMPLE_RATE * msecs / 1000];

         for (int i=0; i<buf.length; i++) {
             double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
             buf[i] = (byte)(Math.sin(angle) * 127.0 * vol);
         }

         // shape the front and back 10ms of the wave form
         for (int i=0; i < SAMPLE_RATE / 100.0 && i < buf.length / 2; i++) {
             buf[i] = (byte)(buf[i] * i / (SAMPLE_RATE / 100.0));
             buf[buf.length-1-i] =
              (byte)(buf[buf.length-1-i] * i / (SAMPLE_RATE / 100.0));
         }

         AudioFormat af = new AudioFormat(SAMPLE_RATE,8,1,true,false);
        try (SourceDataLine sdl = AudioSystem.getSourceDataLine(af)) {
            sdl.open(af);
            sdl.start();
            sdl.write(buf,0,buf.length);
            sdl.drain();
        }
     }
    
}
