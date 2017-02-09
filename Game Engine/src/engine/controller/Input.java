package engine.controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import engine.Game;

public class Input implements KeyListener, MouseListener, MouseMotionListener {
	private boolean[] keys = new boolean[300];
	Game parent;
	int mouseX = 0, mouseY = 0;
	boolean leftMouseDown = false, rightMouseDown = false;
	
	public Input(Game parent) {
		this.parent = parent;
	}
	
	/**
	 * Returns whether the left mouse button is currently down.
	 * @return
	 */
	public boolean leftMouseDown() {
		return leftMouseDown();
	}

	/**
	 * Returns whether the right mouse button is currently down.
	 * @return
	 */
	public boolean rightMouseDown() {
		return rightMouseDown();
	}
	
	/**
	 * Returns a 2 dimensional array with the mouse x and y
	 * positions.
	 * @return
	 */
	public int[] getMouseXandY() {
		int[] position = new int[2];
		position[0] = mouseX;
		position[1] = mouseY;
		
		return position;
	}
	
	/**
	 * Returns a boolean array with all key values.
	 * Each key is stored with an index of its key value.
	 * @return
	 */
	public boolean[] getKeys() {
		return keys;
	}
	
	/**
	 * Returns a boolean declaring whether or not a specified key
	 * is currently pressed.
	 * @param keycode
	 * @return
	 */
	public boolean key(int keycode) {
		return keys[keycode];
	}

	/**
	 * Called every time a key is pressed. Background function.
	 */
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		parent.keyPressed(e.getKeyCode());
	}

	/**
	 * Called every time a key is released. Background function.
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		parent.keyReleased(e.getKeyCode());
	}

	/**
	 * Called whenever the mouse is clicked. Calls the mousePressed
	 * method of Game.
	 */
	public void mousePressed(MouseEvent e) {
		if(e.isMetaDown()) {
			rightMouseDown = true;
		}
		else {
			leftMouseDown = true;
		}
	}

	/**
	 * Called whenever the mouse is released. Calls the mouseReleased
	 * method of Game.
	 */
	public void mouseReleased(MouseEvent e) {
		if(e.isMetaDown()) {
			rightMouseDown = false;
		}
		else {
			leftMouseDown = false;
		}
	}

	/**
	 * Called whenever the mouse is moved. Calls the mouseMoved
	 * method of Game.
	 */
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void keyTyped(KeyEvent e) {}

	public void mouseDragged(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
}
