package game;

import sprite.Sprite;

public class Player extends Sprite {

	public float x;
	public float y;
	
	int density;
	int bounciness;
	int stickitude;
	
	public Player(float x, float y) {
		super(x, y, false);
		this.x = x;
		this.y = y;
		// TODO Auto-generated constructor stub

	}
}
