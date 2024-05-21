import javax.sound.sampled.*;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.io.*;
import java.util.Random;

public class Setup extends JPanel implements ActionListener {
  private Bird bird;
    private ObstacleGroup obstacleGroup;
    private Image Background ;
    private Timer time;
    private boolean Running=false ;
    private Graphics g;
   private  Image background1;
   private Image background2;
    private boolean danger=false;
    private int Highscore=0;
    private  Boolean flag=true;
    private boolean superPower=false;
    boolean ak=false;
    private DataOfUser d1;
    private Image b1,b2;
    private boolean pause=false;
    private boolean playedOnce=false;
    private Audio jump;
  private  Audio die;

  private enemy e1;
  private  boolean made=false;
  private int flagE;


    Setup() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        jump=new Audio("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\jumpAz.wav");
        die=new Audio("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\die1.wav");
         b1=new ImageIcon("C:\\Users\\okara\\Downloads\\3rd Semester Project\\src\\asset For project\\bird5.gif").getImage();
        b2=new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\birdR5.gif").getImage();
        d1=new DataOfUser(Highscore);
        background1 =new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\b2.jpg").getImage();
        background2 =new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\dangerB.jpg").getImage();
    Background =new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\b1.jpg").getImage();

        // Specify the path to the audio file

        // Start playing the audio
        setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        time = new Timer(5, this);
        time.start();

    }


//    Background=Background.getScaledInstance(700,500,Image.SCALE_SMOOTH);


    @Override
    public void paint(Graphics g){

//        Graphics2D g2 = (Graphics2D) g;

        if(danger) {
            g.setColor(Color.white);
            g.drawImage(background2, 0, 0, null);
        }
        else if(!superPower){
            g.setColor(Color.BLACK);

        g.drawImage(Background, 0, 0, null);}
        else{
            g.setColor(Color.white);
            g.drawImage(background1,0,0,null);
        }
        g.setFont(new Font("Arial", 1, 14));
        if(Running) {
            g.drawString("Highest Score:" + Highscore, 550, 20);
            g.setFont(new Font("Arial", 2, 13));
            if (!pause) {


                g.setFont(new Font("Arial", 1, 15));
                g.drawString("Enter SHIFT to pause", 250, 20);

            } else {
                g.setFont(new Font("Arial", 2, 20));
                g.drawString("Press Enter to resume", 250, 250);
            }

            bird.render(g, this);
            if((obstacleGroup.getPoint()<30 ) || ((obstacleGroup.getPoint()>37) && (obstacleGroup.getPoint()<60)) ||(( obstacleGroup.getPoint()>67)  && (obstacleGroup.getPoint()<90 )) || obstacleGroup.getPoint()>97){

            obstacleGroup.render(g, null);
                if(obstacleGroup.getObstacles().get(0).getX()<15 ){
                    g.setFont(new Font("Arial", 1, 15));
                    g.drawString("+1",this.bird.getX(),this.bird.getY());
                }}
            if(((obstacleGroup.getPoint()>=30 && obstacleGroup.getPoint()<=37) ||(obstacleGroup.getPoint()>=60 && obstacleGroup.getPoint()<=67)|| (obstacleGroup.getPoint()>=90 && obstacleGroup.getPoint()<=97))){
                g.setFont(new Font("Arial", 1, 20));
                ak=!ak;
                if(ak){
                g.drawString("Danger Mode ON",250,400);}
                if(obstacleGroup.getPoint()%30!=0 && e1.getX()>10){

                e1.render(g,this);
                    if(e1.getX()<15 ||e1.getX()>700 && obstacleGroup.getPoint()%30!=0 ){
                        g.setFont(new Font("Arial", 1, 15));
                        g.drawString("+1",this.bird.getX(),this.bird.getY());
                    }}

            }

            g.setFont(new Font("Arial", 1, 13));
            g.drawString("Your Score:" + obstacleGroup.getPoint(), 5, 20);
            if (superPower) {

                obstacleGroup.setSuper1(true);
                g.setFont(new Font("Arial", 1, 20));
                g.drawString("SUPER POWER ACTIVE ", 250, 400);

            } else if (((obstacleGroup.getPoint() - 4) % 10 == 0 || ((obstacleGroup.getPoint() - 5) % 10 == 0) )&& this.obstacleGroup.getPoint() != 4 && this.obstacleGroup.getPoint() != 5 && (this.obstacleGroup.getPoint()%10==0 && this.obstacleGroup.getPoint()!=0 && (obstacleGroup.getPoint()<30 ||( obstacleGroup.getPoint()>37) && (obstacleGroup.getPoint()<60 ) ||((obstacleGroup.getPoint()>67)  && (obstacleGroup.getPoint()<90  ))|| obstacleGroup.getPoint()>97) )) {
                ak = !ak;
                if (ak) {
                    g.setFont(new Font("Arial", 1, 18));
                    g.drawString("SUPER POWER DE-ACTIVATING ", 200, 400);
                }
            }
        }
        else{
            if(playedOnce){
            g.setFont(new Font("Arial", 1, 25));
            g.drawString("Your Score: "+obstacleGroup.getPoint(),250,100);}
                    if(!flag) {
                        g.setFont(new Font("Arial", 1, 14));
                        g.drawString("Enter 1 to Select this bird", 100, 200);
                        g.drawImage(b1, 300, 200, null);
                        g.drawString("Enter 2 to Select this bird", 100, 300);
                        g.drawImage(b2, 300, 300, null);

                    }
                    else{
            g.setFont(new Font("Arial", 1, 20));
            g.drawString("Press Enter to Start the Game", 700 / 2 - 150, 500 / 2);}

        }

        g.setFont(new Font("Arial", 2, 13));
        g.drawString("By: Abdullah Zain Haider (SP22-BCS-004)",400,450);

    }
    public void CheckDown() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(this.obstacleGroup.getPoint()%10==0 && this.obstacleGroup.getPoint()!=0 && (obstacleGroup.getPoint()<30 ||( obstacleGroup.getPoint()>37) && (obstacleGroup.getPoint()<60 ) ||((obstacleGroup.getPoint()>67)  && (obstacleGroup.getPoint()<90  ))|| obstacleGroup.getPoint()>97) ){

            superPower=true;
        }
        if(bird.getY()<0 || bird.getY()>500-32){

         GameOver();
        }

    }
    public void restart() throws IOException, ClassNotFoundException {
        this.Running=true;
//        this.bird=new Bird(700/2 -150,500/2 -150);
        this.obstacleGroup=new ObstacleGroup();
        superPower=false;

        FileInputStream file = new FileInputStream("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\HighScoreData.txt");
        ObjectInputStream object= new ObjectInputStream(file);

        DataOfUser d1=(DataOfUser) object.readObject();

        Highscore=d1.getScore();

    }
    public void GameOver() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
        playedOnce=true;
        Running=false;
        flag=true;
        made=false;
        die.start();
        d1.setScore(obstacleGroup.getPoint());
        if(obstacleGroup.getPoint()>Highscore){
            try {
                FileOutputStream fileOut = new FileOutputStream("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\HighScoreData.txt");
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

                objectOut.writeObject(d1);

                objectOut.close();
                fileOut.close();
            } catch (IOException e) {
                System.out.println("dsjdfjs");
                e.printStackTrace();
            }


        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!pause){
        if(Running){
            this.bird.tick();
        if((obstacleGroup.getPoint()<30 ||( obstacleGroup.getPoint()>37) && (obstacleGroup.getPoint()<60 ) ||((obstacleGroup.getPoint()>67)  && (obstacleGroup.getPoint()<90  ))|| obstacleGroup.getPoint()>97)) {
            danger =false;
            this.obstacleGroup.TickBunch();

            try {
                checkCollision();
            } catch (InterruptedException | UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }

           }
            else{
                danger=true;
                if(((obstacleGroup.getPoint()>=30 && obstacleGroup.getPoint()<=37) ||(obstacleGroup.getPoint()>=60 && obstacleGroup.getPoint()<=67)|| (obstacleGroup.getPoint()>=90 && obstacleGroup.getPoint()<=97)) && made==false){
                    Random r1=new Random();

                    int p=r1.nextInt(3);
                    if(p==0){

                         e1=new enemy(900,-100);

                        flagE=0;
                    }
                    else if(p==1) {

                        e1=new enemy(900,600);

                       flagE=1;
                    }
                    else{
                        e1=new enemy(900,200);

                        flagE=2;
                    }
                    made=true;

                }
                if(made){
//

                   if(flagE==0){
                       e1.tickdown();
                       if(e1.getX()<=0){
                           made=false;
                           this.obstacleGroup.increment();
                       }
                   }
                   else if(flagE==1){
                       e1.tickup();

                       if(e1.getX()<=0){
                           made=false;
                           this.obstacleGroup.increment();
                       }
                   }
                   else{
                       e1.tick();

                       if(e1.getX()<=0){
                           made=false;
                           this.obstacleGroup.increment();
                       }

                   }
                    try {
                        if(obstacleGroup.getPoint()%30!=0){
                        checkCollisionE();}
                    } catch (UnsupportedAudioFileException ex) {
                        throw new RuntimeException(ex);
                    } catch (LineUnavailableException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
            if(((this.obstacleGroup.getPoint()-4)%10==0  && this.obstacleGroup.getPoint()!=4)  && (obstacleGroup.getPoint()<30 ||( obstacleGroup.getPoint()>37) && (obstacleGroup.getPoint()<60 ) ||((obstacleGroup.getPoint()>67)  && (obstacleGroup.getPoint()<90  ))|| obstacleGroup.getPoint()>97)){

                superPower=false;
            }
            try {
                CheckDown();
            } catch (InterruptedException | UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
                throw new RuntimeException(ex);
            }
        }



        repaint();
        }
    }

public void checkCollision() throws InterruptedException, UnsupportedAudioFileException, LineUnavailableException, IOException {
    Rectangle r1=bird.getBounds();
        for(int i=0;i<obstacleGroup.getObstacles().size();i++){


        Rectangle r2=obstacleGroup.getObstacles().get(i).getBounds();
        if(r2.intersects(r1)) {
//hit.start();
            GameOver();
        }
}
}
    private class GameKeyAdapter extends KeyAdapter {


        @Override
        public void keyPressed(KeyEvent e) {
            if(!Running || pause){
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {

            flag=false;
            pause=false;
            }}
            if(Running){
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {


                jump.start();

                bird.jump();

            }}

            if (e.getKeyCode() == KeyEvent.VK_SHIFT) {
                pause=true;

            }
            if(!Running){
            if(e.getKeyCode() == KeyEvent.VK_1) {

                bird=new Bird(700/2 -150,500/2 -150,b1);
                flag=true;
                try {
                    restart();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_2) {

                bird=new Bird(700/2 -150,500/2 -150,b2);
                flag=true;
                try {
                    Running=true;
                    restart();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }}

        }

        @Override
        public void keyReleased(KeyEvent e) {

            }
        }
    public void   checkCollisionE() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        Rectangle r1=e1.getBounds();



            Rectangle r2=bird.getBounds();
            if(r2.intersects(r1)) {

                GameOver();
            }
        }

    }


