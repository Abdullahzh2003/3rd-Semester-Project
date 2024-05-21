import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class ObjectOfGame {

    ObjectOfGame(int x1, int y1) {
        this.x = x1;
        this.y = y1;
    }

    ObjectOfGame(int x1, int y1, double s) {
        this.x = x1;
        this.y = y1;
        this.speedX = s;
    }

    protected int x;
    protected int height;
    protected int width;
    protected int y;
    protected double speedX;
    protected int speedY;
    protected Image Image;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setImage(Image image) {
        this.Image = image;
    }

    public Image getImage() {
        return Image;
    }

    public void tick() {
        // Implementation of the tick method
    }

    public void render(Graphics g, ImageObserver a) {
        // Implementation of the render method
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

}