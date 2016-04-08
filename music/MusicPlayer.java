package music;

import java.util.ArrayList;
import java.util.HashMap;

import javax.sound.midi.*;

/**
 * A cellular automaton based midi music player
 * Uses even rules 0 through 255 for rules
 */

public class MusicPlayer {

	public static final int NOTE_BITS = 3;
	public static final int NUM_NOTES = 32;
	
	protected boolean[][] layers;
	protected int ruleNum;
	
	protected ArrayList<Integer> notes;
	
	protected HashMap<NoteKey, Boolean> rules;
	
	protected int getNoteNum(boolean[] bits) {
		int val = 0;
		for(int i=0; i<NOTE_BITS; i++) {
			val += (bits[i])?1<<i:0;
		}
		switch (val) {
		case 0:
			val = 0;
			break;
		case 1:
			val = 2;
			break;
		case 2:
			val = 4;
			break;
		case 3:
			val = 5;
			break;
		case 4:
			val = 7;
			break;
		case 5:
			val = 9;
			break;
		case 6:
			val = 11;
			break;
		case 7:
			val = 12;
			break;
		}
		return val+60;
	}
	
	protected boolean[] bitsFromDec(int dec, int bits) {
		boolean[] val = new boolean[bits];
		for (int i = bits-1; i >= 0; i--) {
	        val[bits-i-1] = (dec & (1 << i)) != 0;
	    }
		return val;
	}
	
	protected void generateRules() {
		boolean[] ruleBits = bitsFromDec(ruleNum, 8);
		for(int i=0; i<8; i++) {
			boolean[] bits = bitsFromDec(i, 3);
			System.out.println(bits[0] + " " + bits[1] + " " + bits[2] + ":" + ruleBits[i]);
			rules.put(new NoteKey(bits[0], bits[1], bits[2]), ruleBits[i]);
		}
	}
	
	protected boolean[] genLayer(boolean[] last) {
		System.out.println(last.length);
		boolean[] newLayer = new boolean[last.length];
		for(int i=0; i<last.length; i++) {
			boolean bit1 = i == 0?false:last[i-1];
			boolean bit2 = last[i];
			boolean bit3 = i == last.length-1?false:last[i+1];
			NoteKey bits = new NoteKey(bit1, bit2, bit3);
			
			newLayer[i] = rules.get(bits);
		}
		
		int center = (last.length-1)/2-1;
		boolean[] bits = {
			newLayer[center-1],
			newLayer[center],
			newLayer[center+1]
		};
		notes.add(getNoteNum(bits));
		
		return newLayer;
	}
	
    public MusicPlayer(int seed) {
    	ruleNum = seed*2;
		layers = new boolean[NUM_NOTES][NUM_NOTES*2+1];
		rules = new HashMap<NoteKey, Boolean>();
		
		generateRules();
		
		notes = new ArrayList<Integer>();
		notes.add(62);
		
		layers[0][(NUM_NOTES-1)/2] = true;
		for(int i=1; i<NUM_NOTES; i++) {
			layers[i] = genLayer(layers[i-1]);
		}
	}
	
	public void play() {
      try {
        Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
        midiSynth.open();

        //get and load default instrument and channel lists
        Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
        MidiChannel[] mChannels = midiSynth.getChannels();

        midiSynth.loadInstrument(instr[0]);//load an instrument

        for(int i=0; i<NUM_NOTES; i++) {
            mChannels[0].noteOn(notes.get(i), 100);//On channel 0, play note number 60 with velocity 100 
            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }
            mChannels[0].noteOff(60);//turn of the note
        }
      } catch (MidiUnavailableException e) {}
	}
    
    public static void main(String[] args) {
    	new MusicPlayer(63).play();
    }

}    