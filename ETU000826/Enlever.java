package listener;
import objet.*; // Objet
import javax.swing.*; // JComboBox
import java.util.*; // vector
import java.awt.*; // actionListener
import java.awt.event.*;


public class Enlever implements ActionListener {
    Vector liste;
    JComboBox listeCateg;
    Objet o;
    
    public Enlever(Vector liste,JComboBox categ) { // constructeur
        this.liste = liste;
        this.listeCateg = categ;
        o = new Objet(liste);
    }

    public void actionPerformed(ActionEvent e) {
        o.enlever(this.listeCateg.getSelectedItem().toString());
    }
}