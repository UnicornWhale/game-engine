package engine;

import java.awt.Toolkit;

import javax.swing.JFrame;

import engine.controller.Input;
import engine.view.Screen;

public class Game extends JFrame {
	private static final long serialVersionUID = 1L;
	protected boolean running = true;
	public Screen screen;
	public Input input = new Input(this);
	public double deltaTime = 0.0;
	public int FPS = 0;
	
	public Game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setFocusable(true);
		screen = new Screen(this);
		add(screen);
		addKeyListener(input);
		addMouseListener(input);
		addMouseMotionListener(input);
		setSize(Toolkit.getDefaultToolkit().getScreenSize());
		setUndecorated(true);
		setVisible(true);
	}
	
	/**
	 * Game.init: Called once when the game starts to run
	 */
	public void init() {
		
	}
	
	/**
	 * Game.run: Backend function used to implement the game loop.
	 * Do not manually call this function.
	 */
	public void run() {
		double oldTime = System.currentTimeMillis();
		double newTime = System.currentTimeMillis();
			
		while(running) {
			oldTime = newTime;
			newTime = System.currentTimeMillis();
			
			deltaTime = newTime - oldTime;
			FPS = (int)(1000.0 / deltaTime);
			
			update();
			screen.repaint();
			
			try {
				Thread.sleep(20);
			} catch(Exception e) {
				System.out.println("Failed to sleep");
			}
		}
	}
	
	/**
	 * Game.update: Called automatically once every cycle in the game loop.
	 * Followed up with a refresh of the screen. Do all game logic
	 * and draw commands here.
	 */
	public void update() {
		
	}
	
	/**
	 * Called once when the game ends. This occurs when Game.running
	 * is set to false. Use to perform any necessary cleanup and/or
	 * saving that needs to be done before the game closes.
	 */
	public void end() {
		
	}
	
	/**
	 * Game.keyPressed: Called automatically whenever a key is pressed.
	 * @param keycode: The KeyEvent code of the key pressed.
	 */
	public void keyPressed(int keycode) {
		
	}

	/**
	 * Game.keyReleased: Called automatically whenever a key is released.
	 * @param keycode: The KeyEvent code of the key released.
	 */
	public void keyReleased(int keycode) {
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.init();
		game.run();
		game.end();
		System.exit(0);
	}
}
