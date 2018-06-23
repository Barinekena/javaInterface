package listener;
import java.awt.event.*;
import javax.swing.*;
import afficher.*;
import objet.*;
import java.util.*;

public class Reinit implements ActionListener {
    Objet o;

    public Reinit(Vector liste) { // constructeur
        this.o = new Objet(liste);
    }
    public void actionPerformed(ActionEvent e) {
        o.reinit();
    }
}