package at.jst.game.objects;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.GeomUtil;

import java.util.ArrayList;

public class EasyGame extends BasicGame {

    private MeinUfo mUfo;

    private ArrayList<MeinUfo> mUfoList;
    private Image background;
    private Crusher crusher;
    private Music music;
    private Sound sound;
    private int lautstärke =0;
    private Font font;
    private int hit=0;
    private int miss=0;
    private Sound gameoversound;
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
        font = new AngelCodeFont("testdata/demo2.fnt","testdata/demo2_00.tga");
        background = new Image("assets/pics/background.png");
        mUfoList = new ArrayList<MeinUfo>();
        for(int i=1;i<=10;i++) {
            mUfoList.add(new MeinUfo(100, 100, new Image("assets/pics/meinufo.png")));

        }
        crusher = new Crusher(512,700,new Image("assets/pics/crusher.png"),container.getInput());
        music = new Music("testdata/kirby.ogg", true);
        sound = new Sound("testdata/burp.aif");
        music.loop();
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        Input input = container.getInput();

        // Fenster mit ESC schliessen
        if (input.isKeyPressed(Input.KEY_ESCAPE)) {
            container.exit();
        }

        if (input.isKeyDown(Input.KEY_1)){
            lautstärke = lautstärke +1;
            if (lautstärke >=10 ) lautstärke =10;
            music.setVolume(lautstärke/10.0f);
        }
        if (input.isKeyDown(Input.KEY_2)){
            lautstärke = lautstärke -1;
            if (lautstärke < 1) lautstärke =0;
            music.setVolume(lautstärke/10.0f);
        }

        crusher.update(delta);

        for(MeinUfo u : mUfoList) {
            if (crusher.intersects(u.getShape())) {
                System.out.println("coolide");
                sound.play();
                u.setRandomPosition();
                hit ++;
            }
            if (u.getY()>768){
                miss++;
                u.setRandomPosition();
            }
            u.update(delta);
        }
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        background.draw();
        crusher.draw(g);
        font.drawString(80,5,"hit"+hit ,Color.black);
        font.drawString(80,25,"Miss"+miss ,Color.red);

        for(MeinUfo u : mUfoList)
            u.draw(g);


    }





}
