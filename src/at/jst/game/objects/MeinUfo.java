package at.jst.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public class MeinUfo extends SpielObjekt{
    public MeinUfo(int x, int y, Image image) {
        super(x, y, image);
    }

    @Override
    public void draw(Graphics g) {
        this.getImage().drawCentered(this.getX(),this.getY());
    }

    @Override
    public Shape getShape() {
        return null;
    }

    @Override
    public void update(int delta) {
        if (this.getY() > (768+this.getHeight())){
            this.setY(-this.getHeight());
        }
        this.setY(getY()+4);
    }
}
