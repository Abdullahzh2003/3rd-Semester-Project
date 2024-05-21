
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Bird extends ObjectOfGame {


    Bird(int x,int y,Image I){
        super(x,y);

        Image=I;
        width=Image.getWidth(null);
        height=Image.getHeight(null);
        speedY=2;
    }
    public  void tick(){
        if(speedY<3){
            speedY+=2;
        }

        this.y=this.y+speedY;

    }
    public void jump(){
        speedY+=-20;

    }


    public void render(Graphics g, ImageObserver a){
        g.drawImage(Image,x,y,a);
    }
}
