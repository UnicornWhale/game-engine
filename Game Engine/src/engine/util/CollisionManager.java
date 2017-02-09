package engine.util;

import java.util.ArrayList;
import java.util.Collection;

public class CollisionManager {
	ArrayList<Collidable> entities = new ArrayList<Collidable>();

	public CollisionManager() {
		
	}
	
	/**
	 * Adds all given entities to the collision manager
	 * @param collection
	 */
	public void addEntities(Collection<Collidable> collection) {
		for(Collidable collidable : collection) {
			entities.add(collidable);
		}
	}
	
	/**
	 * Adds the given entity to the collision manager
	 * @param c
	 */
	public void addEntity(Collidable c) {
		entities.add(c);
	}
	
	/**
	 * Checks all collidable entities and returns an ArrayList
	 * of 2 dimensional arrays containing every pair of collidables
	 * that are currently intersecting.
	 * 
	 * @return
	 */
	public ArrayList<Collidable[]> checkCollisions() {
		ArrayList<Collidable[]> collisions = new ArrayList<Collidable[]>();
		
		for(int a = 0; a < entities.size() - 1; a++) {
			for(int b = a + 1; b < entities.size(); b++) {
				Collidable[] current = new Collidable[2];
				current[0] = entities.get(a);
				current[1] = entities.get(b);
				
				if(entities.get(a).getHitbox().intersects(entities.get(b).getHitbox())) {
					collisions.add(current);
				}
			}
		}
		
		return collisions;
	}
	
	/**
	 * Performs all the same checks as checkCollisions, but also
	 * automatically calls every colliding object's onHit method
	 * and passes them the entities they are currently colliding
	 * with.
	 */
	public void performCollisions() {
		for(Collidable[] current : checkCollisions()) {
			current[0].onHit(current[1]);
			current[1].onHit(current[0]);
		}
	}
}
