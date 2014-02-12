package ApiSound;



import java.util.ArrayList;

import javax.sound.sampled.LineUnavailableException;

public class Score extends Playable {

	private static Score score;
	private ArrayList<Playable> sequences;

	private Score() {
		sequences = new ArrayList<Playable>();
	}
	
	public static Score getInstance() {
		if(score == null) score = new Score();
		return score;
	}
	
	public void add(Sequence seq) {
		sequences.add(seq);
	}
	
	@Override
	public void play() throws LineUnavailableException {
		for(Playable s : sequences) {
			s.play();
		}		
	}
	
	
}
