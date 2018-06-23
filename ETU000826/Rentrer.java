package listener;
import java.awt.event.*;
import javax.swing.*;
import objet.*;
import java.util.*;
import maison.*;

public class Rentrer implements ActionListener {
    JComboBox maison;
    JComboBox categ;
    Vector liste;
    Maison[] listMais;
    Objet o;
    
    public Rentrer(Vector liste,Maison[] listMaison,JComboBox maison,JComboBox categ) { // constructeur
        this.categ = categ;
        this.maison = maison;
        this.liste = liste;
        this.listMais = listMaison;
        o = new Objet(liste);
    }

    public void actionPerformed(ActionEvent e) {
        o.rentrer(listMais,this.maison.getSelectedItem().toString(),this.categ.getSelectedItem().toString());
    }
}