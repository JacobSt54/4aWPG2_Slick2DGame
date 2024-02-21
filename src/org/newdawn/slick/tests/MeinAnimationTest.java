package org.newdawn.slick.tests;

import org.newdawn.slick.*;

/**
 * A test for basic animation rendering
 *
 * @author kevin
 */
public class MeinAnimationTest extends BasicGame {
	/** The animation loaded */
	private Animation animation;
	private Animation animationLinks;
	private Animation animationRechts;

	private Image bild1;
	private int animationX = 0;
	private int animationY=0;

	/** The limited animation loaded */
	private GameContainer container;
	/** Start limited counter */
	private int start = 5000;

	/**
	 * Create a new image rendering test
	 */
	public MeinAnimationTest() {
		super("Animation Test");
	}

	/**
	 * @see BasicGame#init(GameContainer)
	 */
	public void init(GameContainer container) throws SlickException {
		this.container = container;

		//bild1 = new Image("");
		SpriteSheet sheet = new SpriteSheet("testdata/homeranim.png", 36, 65);
		animation = new Animation();
		for (int i=0;i<8;i++) {
			animation.addFrame(sheet.getSprite(i,0), 150);
		}
/*		for (int i=0;i<8;i++) {
			animationLinks.addFrame(sheet.getSprite(i,0), 150);
			animationLinks.addFrame(bild1,100);
		}*/
		container.getGraphics().setBackground(new Color(0.4f,0.6f,0.6f));
	}

	/**
	 * @see BasicGame#render(GameContainer, Graphics)
	 */
	public void render(GameContainer container, Graphics g) {
		//g.scale(-1,1);
		animation.draw(animationX,animationY);

	}

	/**
	 * @see BasicGame#update(GameContainer, int)
	 */
	public void update(GameContainer container, int delta) {
		if (start >= 0) {
			start -= delta;
		}
		if (container.getInput().isKeyDown(Input.KEY_A)) {
		   animationX=(int) (delta/3)+animationX;
		}
	}

	/**
	 * Entry point to our test
	 *
	 * @param argv The arguments to pass into the test
	 */
	public static void main(String[] argv) {
		try {
			AppGameContainer container = new AppGameContainer(new MeinAnimationTest());
			container.setDisplayMode(800,600,false);
			container.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see BasicGame#keyPressed(int, char)
	 */
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			container.exit();
		}
		if(key == Input.KEY_W) {
			animationY++;
		}
		if(key == Input.KEY_D) {
			animationX++;
		}

	}

}
