package engine.util;

import java.awt.Image;

public class Projectile extends CollidableSprite {

	public Projectile(Image image, int x, int y, int width, int height) {
		super(image, x, y, width, height);
		this.hitbox.bluebox = false;
	}
	
	public void onHit(Collidable c) {
		
	}
}
