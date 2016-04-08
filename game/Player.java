package game;

import sprite.Sprite;

public class Player extends Sprite {
	int density;
	int bounciness;
	int stickitude;
	public Player(float x, float y, boolean scrolling) {
		super(x, y, scrolling);
	}
}
