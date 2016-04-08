package sprite;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Sprite {

	public float x;
	protected float y;
	protected int width;
	protected int height;
	protected boolean vis;
	protected Image image;
	protected boolean scrolling;

	public Sprite(float x, float y, boolean scrolling) {
		this.x = x;
		this.y = y;
		vis = true;
		this.scrolling = scrolling;
	}

	protected void getImageDimensions() {
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	protected void loadImage(String imageName) {
		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
		getImageDimensions();
	}

	protected Image getImage() {
		return image;
	}

	protected float getX() {
		return x;
	}

	protected float getY() {
		return y;
	}

	protected boolean isVisible() {
		return vis;
	}

	protected void setVisible(Boolean visible) {
		vis = visible;
	}

	protected Rectangle getBounds() {
		return new Rectangle(Math.round(x), Math.round(y), width, height);
	}
	
	public void draw(Graphics g, Point offset) {
		g.drawImage(this.image, offset.x, offset.y, null);
	}
}
