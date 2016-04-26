package game;

import java.awt.event.KeyEvent;

import javax.swing.SwingUtilities;

import physics.PhysObj;
import sprite.Sprite;

public class Player extends PhysObj {

	
	int density;
	int bounciness;
	int stickitude;
	
	public Player(float x, float y) {
		super(x, y, false);
		// TODO Auto-generated constructor stub

		//SwingUtilities.invokeLater(new runny());
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			 x+=10;
		} else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			 x-=10;
		} else if(e.getKeyCode() == KeyEvent.VK_UP) {
			 
		} else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			 
		}
		
	}
	
	
	public class runny implements Runnable {

		@Override
		public void run() {
			//y += 9.8;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			SwingUtilities.invokeLater(new runny());
			
		}
		
	}
}
