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
	
	public Player(double x, double y) {
		super(x, y, false);
		// TODO Auto-generated constructor stub
//hi
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
		unused += passed;
		double before = x;
		if (unused > 1000/speed) {
			unused -= 1000/speed;
			if(rightKeyDown && !leftKeyDown) {
				x += 1;
			}
			if(!rightKeyDown && leftKeyDown) {
				x -= 1;
			}
		}
		if(x - before == 0) {
		} else {
		}
	}
	
}
