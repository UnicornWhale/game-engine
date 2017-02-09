package engine.util;

import java.awt.Graphics;
import java.awt.Image;

import engine.view.PaintCommand;

public class Sprite implements PaintCommand {
	protected boolean visible = true;
	protected double x, y;
	protected int width, height;
	Image image;

	public Sprite(Image image, double x, double y, int width, int height) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Utility method used so that you can pass a sprite directly
	 * to the screen for drawing.
	 * @param g
	 */
	public void paint(Graphics g) {
		if(visible) {
			g.drawImage(image, (int)x, (int)y, width, height, null);
		}
	}
	
	/**
	 * Adds deltaX to x and deltaY to y.
	 * @param deltaX
	 * @param deltaY
	 */
	public void move(double deltaX, double deltaY) {
		x += deltaX;
		y += deltaY;
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	public boolean getVisible() {
		return visible;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
}
