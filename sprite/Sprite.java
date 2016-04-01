package sprite;


import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Sprite {

	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean vis;
	protected Image image;

	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
		vis = true;
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

	protected int getX() {
		return x;
	}

	protected int getY() {
		return y;
	}

	protected boolean isVisible() {
		return vis;
	}

	protected void setVisible(Boolean visible) {
		vis = visible;
	}

	protected Rectangle getBounds() {
		return new Rectangle(x, y, width, height);
	}
}
