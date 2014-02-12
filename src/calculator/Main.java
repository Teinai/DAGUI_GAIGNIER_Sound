package calculator;

import java.io.FileReader;
import java.util.ArrayList;

import java_cup.runtime.ComplexSymbolFactory;
import ApiSound.Sequence;
import ApiSound.SoundFactory;
import ApiSound.Tone;



public class Main {

	static public void main(String argv[]) { 		
    try {
    	/*ArrayList<Tone> tones = new ArrayList<Tone>();
    	tones.add(SoundFactory.createTone(SoundFactory.Tones.DO, 2));
    	tones.add(new Tone(SoundFactory.Tones.RE, 3));
    	tones.add(new Tone(SoundFactory.Tones.MI, 4));
    	Sequence seq = SoundFactory.createSequence(120, tones);    	
		SoundFactory.getScore().add(seq);
		SoundFactory.getScore().play();*/
    	String name;
    	if (argv.length == 1) {
    		name = argv[0];
    	} else {
    		name = "test.txt";
    	}
    	ComplexSymbolFactory csf = new ComplexSymbolFactory ();
    	Lexer l = new Lexer(new FileReader(name));
    	l.setSymbolFactory(csf);
    	Parser p = new Parser(l, csf);
    	p.parse();  
    } catch (Exception e) {
    	e.printStackTrace();
    }
  }
}


