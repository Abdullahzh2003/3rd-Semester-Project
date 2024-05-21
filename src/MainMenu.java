import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainMenu extends JFrame implements ActionListener {
//        ImageIcon background;


    private ImageIcon background;
   private JPanel panel;

    private JButton startGame = new JButton();
    JButton exit = new JButton();

    MainMenu() {
        background=new ImageIcon("C:\\\\Users\\\\okara\\\\Downloads\\\\3rd Semester Project\\\\src\\\\asset For project\\\\final2.png");
        JLabel label=new JLabel(background);
        label.setBounds(0,0,600,445);
        this.add(label);

        startGame.addActionListener(this);
        exit.addActionListener(this);
//
//        JPanel panel = new JPanel();

         panel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        startGame.setBounds(210, 250, 180, 90);


        panel.setOpaque(false);
        panel.setLayout(null);
        panel.add(startGame);
        panel.add(exit);

        add(panel);

        panel.setBounds(00,100,600,150);
        exit.setBounds(205, 360, 175, 100);
        exit.setOpaque(false);
        startGame.setOpaque(false);
        panel.add(exit);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setSize(600, 460);
        setVisible(true);
        startGame.requestFocus();
        setLocationRelativeTo(null);
        exit.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==startGame) {
            Setup Game = null;
            try {
                Game = new Setup();
            } catch (UnsupportedAudioFileException ex) {
                throw new RuntimeException(ex);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (LineUnavailableException ex) {
                throw new RuntimeException(ex);
            }
            new MainWindow(700, 500, Game);
        }
        if(e.getActionCommand().equals("Confirm")){

            dispose();

        }
        else if (e.getSource()==exit) {

            dispose(); // Close the JFrame
        }
    }


}
