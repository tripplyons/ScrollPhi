package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import physics.PhysObj;

public class ScrollPhi extends JPanel implements KeyListener, MouseListener {

	static int[][] map = new int[1000][1000];
	static Player player;
	HashMap<Integer, Image> imageKey = new HashMap<Integer, Image>();
	public static int TILESIZE = 128;
	static JFrame frame;
	static int SCREEN_WIDTH = 500;
	static int SCREEN_HEIGHT = 500;
	static double GRAVITY = 9.8;
	static long currentTime;
	static ArrayList<PhysObj> objects = new ArrayList<PhysObj>();
	Image playerImage = new ImageIcon("Foot.png").getImage().getScaledInstance(50, 80, Image.SCALE_DEFAULT);          

	public static void main(String[] args) {
		frame = new JFrame();
		ScrollPhi s = new ScrollPhi();
		player = new Player(0f, 0f);
		frame.add(s);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		s.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.pack();
		frame.addKeyListener(s);
		frame.addMouseListener(s);
		frame.setVisible(true);
		currentTime = System.currentTimeMillis();
		while(true) {
			long current = System.currentTimeMillis();
			long passed = current - currentTime;
			
			for(PhysObj p : objects) {
				if(! p.collidesWithMap(map)) {
				double k = p.getY() + GRAVITY;
				System.out.println(p.y);
				System.out.println("K is " + k);
				p.setY(k);
				}
				p.update(passed);
			}
			if(! player.collidesWithMap(map)) {
			double k = player.getY() + GRAVITY;
			System.out.println(player.y);
			System.out.println("K is " + k);
			player.setY(k);
			}
			player.update(passed);
			
			currentTime = current;
		}
	}

	public ScrollPhi() {
		loadMap();
		for(int i = 0; i < 10; i++) {
		}

		

	}

	public void loadMap() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("map"));
			int y = -1;
			while(true) {
				y++;
				String line = br.readLine();
				if(line == null) break;
				StringTokenizer st = new StringTokenizer(line, " ");
				for(int i = 0; st.hasMoreTokens(); i++) {
					map[y][i] = Integer.parseInt(st.nextToken()) + 1;
				}
				
			}
		} catch (Exception e) {
			
		}
		for(int i = 0; i < 18; i++) {
			imageKey.put(i, new ImageIcon("images/"+ i + ".png").getImage());
		}
	}
					
	@Override
	public void paintComponent(Graphics g) {
		paintMap(g);
		paintSprites(g);
		g.drawImage(playerImage ,(int)  500, (int) 300, this);
	}

	public void paintMap(Graphics g) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				g.drawImage(imageKey.get(map[j][i]), i*TILESIZE - (int) player.x + 375, j*TILESIZE - (int) player.y + 375, this);
			}
		}
	}

	public void paintSprites(Graphics g) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		player.keyDown(e);
		repaint();

	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.keyReleased(e);
		repaint();
	}
}
