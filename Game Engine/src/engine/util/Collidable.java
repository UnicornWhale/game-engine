package engine.util;

public interface Collidable {
	public Hitbox getHitbox();
	public void onHit(Collidable c);
}
