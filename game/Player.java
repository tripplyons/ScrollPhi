package game;

import sprite.Sprite;

public class Player extends Sprite {

	public float x;
	public float y;
	
	public Player(float x, float y) {
		super(x, y);
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub
	}
	double density;
	double bounciness;
	double stickitude;
	
	
}
