import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ObstacleGroup {
    private List<Obstacle> Obstacle;
    private int base=500;
    private Random random;
    private int point=0;
    private double current_Speed=7;
    private boolean super1=false;

    ObstacleGroup(){
        Obstacle=new ArrayList<>();
        random=new Random();

        MakeBunch();


    }

    public void setSuper1(Boolean flag) {
        this.super1=flag;
    }

    public List<Obstacle> getObstacle() {
        return Obstacle;
    }

    public void MakeBunch() {
        int base1=base;

        int temp = random.nextInt(7) + 2;

        for (int i = 0; i < 15; i++) {

            Obstacle o = new Obstacle(900, base1,current_Speed);


            base1 = o.getY() - o.getHeight();

            if (i < temp || i > temp + 4) {
                if(!super1  || (super1 && !(o.getY()>200 && o.getY()<300))){
                Obstacle.add(o);
            }

        }

    }}
    public void TickBunch() {
        for (int i = 0; i < Obstacle.size(); i++) {
            Obstacle.get(i).tick();
            if((point-4)%10==0){
                super1=false;
            }
            if(super1 && getObstacles().get(i).getX()<450){

                Obstacle.get(i).superPower();
            }


            if (Obstacle.get(i).getX() <= 0) {
                Obstacle.remove(Obstacle.get(i));
            }
        }

        if (Obstacle.isEmpty()) {
            current_Speed+=0.10;

            point += 1;
            MakeBunch();
        }


    }
        public void render(Graphics g, ImageObserver a) {
            for (int i = 0; i < Obstacle.size(); i++) {
                Obstacle.get(i).render(g, a);
            }
        }

    public int getPoint() {
        return point;
    }
            public void increment(){
        this.point+=1;
            }
    // Accessor for obstacles list
    public List<Obstacle> getObstacles() {
        return Obstacle;
    }
    }



