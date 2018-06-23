package afficher;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import vivant.*;
public class Fenetre extends JFrame {
    public Fenetre(String titre,int width, int height) {
        this.setTitle(titre); // titre
        this.setSize(width,height); // taille
        this.setLocationRelativeTo(null); // placement au centre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //fermeture quand on clique sur fermer
    }
}