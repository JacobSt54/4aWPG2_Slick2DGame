package at.jst.game.objects;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.Random;

public class MeinUfo extends SpielObjekt{
    private float acceleration = 0.005f;
    private float geschwindigkeit =2;
    private Rectangle shape;
    public MeinUfo(int x, int y, Image image) {
        super(x, y, image);
        setRandomPosition();
        setRandomAcceleration();
        shape = new Rectangle(x,y,image.getWidth(),image.getHeight());
    }

    @Override
    public void draw(Graphics g) {
        this.getImage().drawCentered(this.getX(),this.getY());
    }

    @Override
    public Shape getShape() { return shape;    }

    @Override
    public void update(int delta) {
        this.geschwindigkeit = (delta * this.acceleration + geschwindigkeit);
        if (this.getY() > (768+this.getHeight())){
            this.setRandomPosition();
        }
        this.setY(getY()+(int) this.geschwindigkeit);
        shape.setCenterX(this.getX());
        shape.setCenterY(this.getY());
    }

    public void setRandomPosition() {
        Random r = new Random();
        int ry =0;
        int rx =0;
        rx = r.nextInt(1024-this.getWidth()+1-0) +(this.getWidth()/2);
        ry = r.nextInt(300+1+this.getHeight()+this.getHeight());
        this.setY(-ry);
        this.setX(rx);
        this.setRandomAcceleration();
    }
    private void setRandomAcceleration(){
        Random r = new Random();
        this.geschwindigkeit = r.nextInt(4-1)+1;
    }
}
