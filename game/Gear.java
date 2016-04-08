package game;

import java.util.ArrayList;

public class Gear {

	ArrayList<String> methods = new ArrayList<String>();
	Player p;
	
	public Gear() {
		methods.add("BouncyBoots");
		methods.add("StickyBoots");
		methods.add("LightHelm");
		methods.add("WeightPlate");
		methods.add("HeliumHelm");
		methods.add("WaveWGloves");
		
	}
	
	public void bouncyBoots(Gear g) {
		p.bounciness += 10;
	}
	
	public void stickyBoots(Gear g) {
		p.stickitude += 10;
	}
	
	public void heliumHelm(Gear g) {
		p.density -= 10;
	}
	
	public void weightPlate(Gear g) {
		p.density += 15;
	}
	
	public void waveGloves(Gear g) {
		
	}
	
	public void IfeelLikeWeWereGoingToDoSomethingWithTime(Gear g) {
		
	}
}


