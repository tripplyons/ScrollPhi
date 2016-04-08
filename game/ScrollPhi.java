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
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ScrollPhi extends JPanel implements KeyListener, MouseListener {
	
	int[][] map = new int[1000][1000];
	static Player p;
	HashMap<Integer, Image> imageKey = new HashMap<Integer, Image>();
	int TILESIZE = 50;
	static JFrame frame;
	static int SCREEN_WIDTH = 500;
	static int SCREEN_HEIGHT = 500;
	
	public static void main(String[] args) {
		frame = new JFrame();
		ScrollPhi s = new ScrollPhi();
		p = new Player(50f, 50f);
		frame.add(s);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		s.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.pack();
		frame.addKeyListener(s);
		frame.addMouseListener(s);
		frame.setVisible(true);
		
	}
	
	public ScrollPhi() {
		loadMap();
	}
	
	public void loadMap() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("map"));
			
			for(int i = 0; br.ready(); i++) {
				StringTokenizer s = new StringTokenizer(br.readLine());
				for(int j = 0; s.hasMoreTokens(); j++) {
					map[i][j] = Integer.parseInt(s.nextToken());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 18; i++) {
			imageKey.put(i, new ImageIcon(Integer.toString(i)).getImage());
		}
	}
	
	@Override
	public void paintComponent(Graphics g) {
		paintMap(g);
		paintSprites(g);
	}
	
	public void paintMap(Graphics g) {
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				g.drawImage(imageKey.get(map[i][j]), i*TILESIZE, j*TILESIZE, this);
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
