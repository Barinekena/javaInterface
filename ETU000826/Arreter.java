package listener;
import java.awt.event.*;
import javax.swing.*;
import afficher.*;

public class Arreter implements ActionListener {
    Animation anim;
    Timer timer;
    public Arreter(Animation a,Timer timer) { // constructeur
        this.anim = a;
        this.timer = timer;
    }
    public void actionPerformed(ActionEvent e) {
        timer.stop();
    }
}