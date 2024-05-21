import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class enemy extends ObjectOfGame{

    enemy(int x1, int y1) {
        super(x1, y1);
        this.Image= new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\enemy2.gif").getImage();
        this.height=Image.getHeight(null);
        this.width=Image.getWidth(null);
    }
    public void tickup(){
        this.x-=9;
        this.y-=5;
    }
    public void tickdown(){
        this.x-=9;
        this.y+=3;
    }
    public void tick(){
        this.x-=9;
    }
    public void render(Graphics g, ImageObserver a){
        g.drawImage(Image,x,y,a);
    }


}
