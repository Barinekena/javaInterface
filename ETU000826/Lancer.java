package listener;
import java.awt.event.*;
import javax.swing.*;
import afficher.*;  

public class Lancer implements ActionListener {
    Animation anim;
    Timer timer = new Timer(10,this);

    public Timer getTimer() {
        return this.timer;
    }

    public Lancer(Animation a) { // constructeur
        this.anim = a;
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            timer.start();
        } else {
            this.anim.repaint();
        }
    }
}