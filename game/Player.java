package game;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import physics.PhysObj;
import sprite.Sprite;

public class Player extends PhysObj {

	boolean upKeyDown = false;
	boolean leftKeyDown = false;
	boolean rightKeyDown = false;
	int density;
	int bounciness;
	int stickitude;
	int speed = 300;
	int unused = 0;
	
	public Player(float x, float y) {
		super(x, y, false);
		// TODO Auto-generated constructor stub

		//SwingUtilities.invokeLater(new runny());
	}

	public void keyDown(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightKeyDown = true;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftKeyDown = true;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			upKeyDown = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rightKeyDown = false;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			leftKeyDown = false;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			upKeyDown = false;
		}
	}
	
	public void update(long passed) {
		int move = 0;
		float divpassed = passed / 1000;
		unused += passed % speed;
		if (unused > 1000 / speed) {
			unused -= 1000 / speed;
			if(rightKeyDown && !leftKeyDown) {
				x += 1;
			}
			if(!rightKeyDown && leftKeyDown) {
				x -= 1;
			}
		}
	}
	
	@Override
	public boolean collidesWithMap(int[][] map) {
		if(map[(int) 300/ScrollPhi.TILESIZE -(int) y/ScrollPhi.TILESIZE + height][(int) 500/ScrollPhi.TILESIZE - (int) y/ScrollPhi.TILESIZE] == 0) {
		return false;
		} 
		return true;
	}
}
