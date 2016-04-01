package editor;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MapEditor extends JPanel implements MouseListener, ActionListener, MouseMotionListener {

	final int maxHeight = 100;
	final static int tileSize = 100;
	
	int[][] starterMap = 
		{
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
				{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}
		};
	
	int[][] map;
	HashMap<Integer, Image> key;
	JTextField text = new JTextField(8);
	ImageIcon selectedTile;
	int selTile;

	public MapEditor() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("map"));
			List<List<Integer>> listMap = new ArrayList<List<Integer>>();
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				ArrayList<Integer> nums = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreTokens()) {
					nums.add(Integer.parseInt(st.nextToken()));
				}
				listMap.add(nums);
			}
			
			map = fromList(listMap);
		} catch (Exception e) {
			map = starterMap;
		}
		JFrame f = new JFrame();
		SideBar s = new SideBar();
		
		key = getKey();
		
		text.addActionListener(this);
		add(text);
		addMouseMotionListener(this);
		addMouseListener(this);	
	}
	
	public static int[][] fromList(List<List<Integer>> l){
		int[][] ret = new int[l.size()][l.get(0).size()];
		for(int i = 0; i < l.size(); i++) {
				for(int j = 0; j < l.get(0).size(); j++) {
					ret[i][j] = l.get(i).get(j);
				}
		}
		return ret;
	}
	
	public static HashMap<Integer, Image> getKey() {
		HashMap<Integer, Image> key = new HashMap<Integer, Image>();
		key.put(0, new ImageIcon("images/1.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT));
		key.put(1, (new ImageIcon("images/2.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(2, (new ImageIcon("images/3.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(3, (new ImageIcon("images/4.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(4, (new ImageIcon("images/5.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(5, (new ImageIcon("images/6.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(6, (new ImageIcon("images/7.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(7, (new ImageIcon("images/8.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(8, (new ImageIcon("images/9.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(9, (new ImageIcon("images/10.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		
		key.put(10, (new ImageIcon("images/11.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(11, (new ImageIcon("images/12.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(12, (new ImageIcon("images/13.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(13, (new ImageIcon("images/14.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(14, (new ImageIcon("images/15.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
		key.put(15, (new ImageIcon("images/16.png").getImage().getScaledInstance(tileSize, tileSize, Image.SCALE_DEFAULT)));
	
		
		return key;
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MapEditor m = new MapEditor();
		m.setSize(new Dimension(500, 400));
		f.add(m);
		f.setSize(new Dimension(500, 400));
		f.setVisible(true);
	}

	@Override
	public void paintComponent(Graphics g) {
		for(int x = 0; x < map[0].length - 1; x++) {
			for(int y = 0; y < map.length - 1; y++) {
				g.drawImage(key.get(map[y][x]), x*tileSize, y*tileSize, this);
			}
		}
		if(selectedTile != null) {
			int i = (int) MouseInfo.getPointerInfo().getLocation().getX() - (int) this.getLocationOnScreen().getX();
			int v = (int) MouseInfo.getPointerInfo().getLocation().getY() - (int) this.getLocationOnScreen().getY();

			g.drawImage(selectedTile.getImage(), i - 15, v - 15, this);

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		int x = (int) (MouseInfo.getPointerInfo().getLocation().getX() - (int) this.getLocationOnScreen().getX())/tileSize;
		int y = (int) (MouseInfo.getPointerInfo().getLocation().getY() - (int) this.getLocationOnScreen().getY())/tileSize;        
		map[y][x] = selTile;
		repaint();
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
	public void actionPerformed(ActionEvent e) {
		System.out.println("Got an action");
		if(e.getSource().equals(text)) {
			if(text.getText().equals("save")) {
				try {
				 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("map")));
				 for(int i = 0; i < map.length; i++) {
					 for(int y = 0; y < map[i].length; y++) {
					 out.print(map[i][y] + " ");
					 out.flush();
					 }
					 out.println();
					 out.flush();
				 }
				 out.flush();
				 out.close();
				} catch(Exception aak) {
					
				}
				 text.setText("");
			} else {
				System.out.println("Got a text action");
				selectedTile = new ImageIcon(key.get(Integer.parseInt(text.getText())));
				selTile = Integer.parseInt(text.getText());
				text.setText("");
				//System.out.println(key.get(Integer.parseInt(text.getText())));
			}
		}
		repaint();

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		repaint();

	}

}
