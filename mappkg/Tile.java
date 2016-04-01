package mappkg;

import sprite.Sprite;

public class Tile extends Sprite {

	boolean passable;
	public Tile(String imgpath, boolean passable) {
		super(0,0);
		loadImage(imgpath);
		this.passable = passable;
	}

}
