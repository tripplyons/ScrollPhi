package physics;

import game.ScrollPhi;
import sprite.Sprite;

// 1 tile = 1m
// 1period = 1sec

public class PhysObj extends Sprite {
	public float[] rotMatrix;
	public int mass = 1;
	public float frecquency = 1/2;
	public PhysObj(float x, float y, boolean scrolling) {
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
		System.out.println(x + ", " + y);
		if(map[(int) x/ScrollPhi.TILESIZE][(int) y/ScrollPhi.TILESIZE] == 0) {
			return false;
		}
		System.out.println("Collided with something");
		return true;
	}
}
