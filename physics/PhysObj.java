package physics;

import game.ScrollPhi;
import sprite.Sprite;

// 1 tile = 1meter
// 1period = 1sec

public class PhysObj extends Sprite {
	public double[] rotMatrix;
	public int mass = 1;
	public double frecquency = 1/2;
	public PhysObj(double x, double y, boolean scrolling) {
		super(x, y, scrolling);
	}
	
	// Velocity^2 = Acceleration
	public int force(int velocity) {
		return 1/2*this.mass*velocity*velocity;
	}
	
	// -1/2 Kx^2
	public int spring(int stiffness, int position) {
		return -1/2 * stiffness * position * position;
	}
	
	
	public int angularFrec(int omega, int radiusFromOrigin) {
		return radiusFromOrigin;
		
	}
	
	public boolean collidesWithMap(int[][] map) {
		
		if(map[(int) y/ScrollPhi.TILESIZE + height][(int) x/ScrollPhi.TILESIZE] == 0) {
			return false;
		}
		return true;
	}

	public void update(long passed) {
		
	}
}
