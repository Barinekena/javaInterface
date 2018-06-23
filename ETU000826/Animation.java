package afficher;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import vivant.*;
import animal.*;
import objet.*;
import maison.*;

public class Animation extends JPanel {
    Vector liste;
    Maison[] listMais;
    Objet o;

    public Animation(Vector liste,Maison[] listMais) {
        this.listMais = listMais;
        this.liste = liste;
        o = new Objet(liste);
        this.setSize(700,520);
    }
    
    public void paintComponent(Graphics g) {
        Vivant vI;
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        for(int i=0;i<liste.size();i++) {
            // System.out.println("reinitialiser");
            vI = (Vivant)(liste.get(i));
            o.enVie(vI,5); // tuer ou pas
            o.dessiner(vI,g);
            o.deplacer(vI,this.getWidth(), this.getHeight());
        }
        g.setColor(Color.black);
        for (int i = 0; i < this.listMais.length; i++) {
            g.fillPolygon(this.listMais[i].getX(),this.listMais[i].getY(),5);
        }
    }
}