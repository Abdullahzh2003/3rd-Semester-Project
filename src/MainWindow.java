import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    MainWindow(int Width,int height,Setup Game){
        JFrame frame=new JFrame();
        frame.setResizable(false);
        frame.add(Game);
        frame.setTitle("AZ Haider Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width,height);
//        frame.setMaximumSize(new Dimension(Width, height));
//        frame.setPreferredSize(new Dimension(Width, height));
//        frame.setMinimumSize(new Dimension(Width, height));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

}