package engine.util;

import java.awt.Rectangle;

public class Hitbox extends Rectangle {
	private static final long serialVersionUID = 1L;
	int x, y, width, height;
	boolean bluebox;
	
	public Hitbox(int x, int y, int width, int height, boolean bluebox) {
		super(x, y, width, height);
	}
}
