package editor;

import java.awt.Dimension;
import java.awt.Graphics;
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

	int[][] starterMap = 
		{
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
		};
	
	int[][] map;
	HashMap<Integer, String> key;
	JTextField text = new JTextField(8);
	ImageIcon selectedTile;
	int selTile;

	public MapEditor() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/map"));
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
	
	public static HashMap<Integer,  String> getKey() {
		HashMap<Integer, String> key = new HashMap<Integer, String>();
		key.put(0, "src/res/grass.png");
		key.put(1, "src/res/rock.png");
		key.put(2, "src/res/G2R.png");
		key.put(3, "src/res/R2G.png");
		key.put(4, "src/res/G2R2.png");
		key.put(5, "src/res/R2G2.png");
		key.put(6, "src/res/GRCorner1.png");
		key.put(7, "src/res/GRCorner2.png");
		key.put(8, "src/res/GRCorner3.png");
		key.put(9, "src/res/GRCorner4.png");
		
		key.put(10, "src/res/GR2Corner1.png");
		key.put(11, "src/res/GR2Corner2.png");
		key.put(12, "src/res/GR2Corner3.png");
		key.put(13, "src/res/GR2Corner4.png");
		key.put(14,  "src/res/grassWithRock.png");
		key.put(15,  "src/res/rockWithRock.png");
		
		key.put(20, "src/res/pave1.png");
		key.put(21, "src/res/pave2.png");
		key.put(22, "src/res/pave3.png");
		key.put(23, "src/res/pave4.png");
		key.put(24, "src/res/paveEdge1.png");
		key.put(25, "src/res/paveEdge2.png");
		key.put(26, "src/res/paveEdge3.png");
		key.put(27, "src/res/paveEdge4.png");
		key.put(28, "src/res/paveCorner1.png");
		key.put(29, "src/res/paveCorner2.png");
		key.put(30, "src/res/paveCorner3.png");
		key.put(31, "src/res/paveCorner4.png");
		key.put(32, "src/res/paveCorner5.png");
		key.put(33, "src/res/paveCorner6.png");
		key.put(34, "src/res/paveCorner7.png");
		key.put(35, "src/res/paveCorner8.png");
		key.put(36, "src/res/pave5.png");
		
		key.put(40, "src/res/cliff1.png");
		key.put(41, "src/res/cliff2.png");
		
		key.put(42, "src/res/cliffSide1.png");
		key.put(43, "src/res/cliffSide2.png");
		key.put(44, "src/res/cliffSide3.png");
		key.put(45, "src/res/cliffSide4.png");
		key.put(46, "src/res/cliffTop1.png");
		key.put(47, "src/res/cliffTop2.png");
		key.put(48, "src/res/cliffCorner1.png");
		key.put(49, "src/res/cliffCorner2.png");
		key.put(50, "src/res/cliffCorner3.png");
		key.put(51, "src/res/cliffCorner4.png");
		key.put(52, "src/res/cliffRock1.png");
		key.put(53, "src/res/cliffRock2.png");
		
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

				ImageIcon ii = new ImageIcon(key.get(map[y][x]));
				g.drawImage(ii.getImage(), x*40, y*40, this);
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

		int x = (int) (MouseInfo.getPointerInfo().getLocation().getX() - (int) this.getLocationOnScreen().getX())/40;
		int y = (int) (MouseInfo.getPointerInfo().getLocation().getY() - (int) this.getLocationOnScreen().getY())/40;
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
				 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src/map")));
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
