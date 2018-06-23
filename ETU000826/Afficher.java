package afficher;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import listener.*;
import maison.*;
import animal.*;
import vivant.*;
import objet.*;
public class Afficher {
    public static void main(String[] args)throws Exception {
        Date a,b,c;
        a = new Date(100,10,12);
        b = new Date(112,9,17);
        c = new Date(113,5,1);
        Personne titi,tata,tutu;
        titi = new Personne("titi",a);
        tata = new Personne("tata",a);
        tutu = new Personne("tutu",a);
        Chien toto,tete,tita,milou;
        toto = new Chien("alika1",b,3);
        tete = new Chien("alika2",b,4);
        tita = new Chien("alika3",b,5);
        milou = new Chien("alika4",b,3);
        Chat mimi,totoK,mlay,minou,chuchu,chacha;
        chacha = new Chat("chacha",c,6);
        chuchu = new Chat("chuchu",c,3);
        mimi = new Chat("mimi",c,7);
        totoK = new Chat("totoK",c,5);
        mlay = new Chat("mlay",c,3);
        minou = new Chat("minou",c,4);
        int[] xCentre = {350,350,350,350,350};
        int[] yCentre = {350,350,350,350,350};
        Maison m = new Maison("Centre",xCentre,yCentre);
        m.setVivant(titi);
        m.setVivant(tata);
        m.setVivant(tutu);

        m.setVivant(toto);
        m.setVivant(tete);
        m.setVivant(tita);
        m.setVivant(milou);

        m.setVivant(chacha);
        m.setVivant(chuchu);
        m.setVivant(mimi);
        m.setVivant(totoK);
        m.setVivant(mlay);
        m.setVivant(minou);
        m.setVivant(new Chat("renfort",a,8));
        m.setVivant(new Chat("renfort",a,8));
        m.setVivant(new Chat("renfort",a,8));
        m.setVivant(new Chat("renfort",a,8));
        m.setVivant(new Chat("renfort",a,8));
        m.setVivant(new Chat("renfort",a,8));
        m.setVivant(new Chat("renfort",a,8));
        // DEBUT DU PROGRAMME EN FENETRE
        
        // LISTE MAISON

        int[] xp = {100,110,110,90,90};
        int[] yp = {100,105,115,115,105};
        int[] xg = {600,610,610,590,590};
        int[] yg = {400,405,415,415,405};
        Maison[] listMaison = new Maison[4];
        listMaison[0] = new Maison("maison 1",xp,yp);
        listMaison[1] = new Maison("maison 2",xg,yp);
        listMaison[2] = new Maison("maison 3",xp,yg);
        listMaison[3] = new Maison("maison 4",xg,yg);

        // DECLARATION FENTRE ET ANIMATION

        Fenetre fenetre = new Fenetre("Window",700,600); // width et height
        fenetre.setLayout(new BorderLayout());
        Animation principal = new Animation(m.getVivantVector(),listMaison);

        // COMBOBOX

        String[] listCateg = {"Personne","Chat","Chien"};
        String[] listeMaison = {"maison 1","maison 2","maison 3","maison 4"};
        JComboBox categ,maison;
        categ = new JComboBox(listCateg);
        maison = new JComboBox(listeMaison);
        
        // LES BOUTONS ET LES LISTENER 

        JPanel bas = new JPanel();
        Lancer l = new Lancer(principal);
        JButton lancer,arreter,enlever,reinitialiser,rentrer;
        lancer = new JButton("Lancer");
        arreter = new JButton("Arreter");
        enlever = new JButton("Enlever");
        rentrer = new JButton("Rentrer");
        reinitialiser = new JButton("Reinitialiser");
        bas.add(reinitialiser);
            reinitialiser.addActionListener(new Reinit(m.getVivantVector()));
        bas.add(lancer);
            lancer.addActionListener(l);
        bas.add(arreter);
            arreter.addActionListener(new Arreter(principal,l.getTimer()));
        bas.add(enlever);
            enlever.addActionListener(new Enlever(m.getVivantVector(),categ));
        bas.add(rentrer);
            rentrer.addActionListener(new Rentrer(m.getVivantVector(),listMaison,categ,maison));
        bas.add(maison);
        bas.add(categ);

        // AJOUT DES JPANEL

        fenetre.getContentPane().add(principal,BorderLayout.CENTER);
        fenetre.getContentPane().add(bas,BorderLayout.SOUTH);
        
        // VISIBILITE DE LA FENETRE

        fenetre.setVisible(true); 

        // FIN
    }
}