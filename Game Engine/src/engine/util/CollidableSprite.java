package engine.util;

import java.awt.Image;

public class CollidableSprite extends Sprite implements Collidable{
	Hitbox hitbox;

	public CollidableSprite(Image image, double x, double y, int width, int height) {
		super(image, x, y, width, height);
		hitbox = new Hitbox((int)x, (int)y, width, height, true);
	}

	public Hitbox getHitbox() {
		return hitbox;
	}

	/**
	 * This method is called whenever some other collidable
	 * collides with this object. The passed collidable is the
	 * collidable that is currently intersecting this one.
	 */
	public void onHit(Collidable c) {
		
	}

	/**
	 * Adds deltaX to x and deltaY to y.
	 * Automatically updates hitbox.
	 * @param deltaX
	 * @param deltaY
	 */
	public void move(double deltaX, double deltaY) {
		x += deltaX;
		y += deltaY;

		//Update hitbox with new location
		hitbox = new Hitbox((int)x, (int)y, width, height, true);
	}
}
