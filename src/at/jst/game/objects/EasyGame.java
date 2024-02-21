package at.jst.game.objects;

import org.newdawn.slick.*;

public class EasyGame extends BasicGame {

    private MeinUfo mUfo;
    private Image background;

    public EasyGame() {
        super("EasyGame");
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new EasyGame());
        container.setDisplayMode(1024, 768, false);
        //container.setClearEachFrame(false);
        container.setMinimumLogicUpdateInterval(25);
        container.setTargetFrameRate(60);
        container.setShowFPS(true);
        container.start();
    }



    @Override
    public void init(GameContainer container) throws SlickException {
        background = new Image("assets/pics/background.png");
        mUfo = new MeinUfo(100,100,new Image("assets/pics/meinufo.png"));

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();

        // Fenster mit ESC sclie?en
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }
        mUfo.update(delta);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        background.draw();
        mUfo.draw(g);

    }




}
