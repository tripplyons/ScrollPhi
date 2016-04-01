package sprite;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.ImageObserver;

public class ScrollingSprite extends Sprite {
	public ScrollingSprite(int x, int y) {
		super(x, y);
	}
	
	public void draw(Graphics g, Point offset) {
		g.drawImage(this.image, offset.x, offset.y, null);
	}
}
