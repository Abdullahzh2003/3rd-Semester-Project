import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Obstacle extends ObjectOfGame{

    boolean super2=false;

    Obstacle(int x,int y,double s){
        super(x,y,s);
        Image =new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\TubeBody0.jpg").getImage();
        this.width=Image.getWidth(null);
        this.height=Image.getHeight(null);

    }
    public void superPower(){
        if(this.getY()<250){
            this.y-=5;
        }
     if(this.getY()>250){
            this.y+=5;
        }
    }

    @Override
    public void tick() {

        if(super2){
            x-=3;
        }
        else{
            x-=speedX;
        }
    }

    @Override
    public void render(Graphics g, ImageObserver a) {
        g.drawImage(Image,x,y,a);

    }
}
