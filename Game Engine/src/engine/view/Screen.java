package engine.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import engine.Game;
import engine.util.Sprite;

public class Screen extends JPanel {
	private static final long serialVersionUID = 1L;
	Game parent;
	ArrayList<PaintCommand> commands = new ArrayList<PaintCommand>();
	private boolean fpsCounter = false;

	public Screen(Game parent) {
		this.parent = parent;
	}
	
	public void setFpsCounter(boolean b) {
		fpsCounter = b;
	}

	public synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(PaintCommand c : commands) {
			c.paint(g);
		}
		
		if(fpsCounter) {
			g.setColor(Color.black);
			g.drawString(parent.FPS + "", 20, 20);
		}
		
		commands.clear();
	}

	/**
	 * Paints the given sprite onto the screen at the sprites position.
	 * @param s
	 */
	public synchronized void paint(Sprite s) {
		commands.add(s);
	}

	/**
	 * Paints the given image onto the screen at the specified x and y.
	 * Uses the images native size.
	 * @param image
	 * @param x
	 * @param y
	 */
	public synchronized void paint(Image image, int x, int y) {
		paint(image, x, y, image.getWidth(null), image.getHeight(null));
	}

	/**
	 * Paints the given image onto the screen at the specified x and y. 
	 * Uses the given image width and height;
	 * @param image
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public synchronized void paint(final Image image, final int x, final int y, final int width, final int height) {
		commands.add(new PaintCommand() {
			public void paint(Graphics g) {
				g.drawImage(image, x, y, width, height, null);
			}
		});
	}

	/**
	 * Fills a solid rectangle of the given color at the given x and y of the given dimensions.
	 * @param color
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public synchronized void paint(final Color color, final int x, final int y, final int width, final int height) {
		commands.add(new PaintCommand() {
			public void paint(Graphics g) {
				g.setColor(color);
				g.fillRect(x, y, width, height);
			}
		});
	}
}
