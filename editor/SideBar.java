package editor;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SideBar extends JScrollPane {

	ArrayList<Image> images = new ArrayList<Image>();

	public SideBar() {

		HashMap<Integer, Image> key = MapEditor.getKey();
		for(int i = 0; i < key.size(); i++) {
			images.add(key.get(i));
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		for(int i = 0; i < images.size(); i++) {
			ImageIcon image = new ImageIcon(images.get(i));

			g.drawImage(image.getImage(), (i%2)*50, (i/2)*50, this);
		}
	}
}
