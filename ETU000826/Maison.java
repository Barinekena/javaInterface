package maison;
import java.util.*;
import java.lang.reflect.*;
import vivant.*;
public class Maison {
    String nom;
    Vector vivants = new Vector(10,10);
    int[] x,y;
    
    public String getNom() {
        return this.nom;
    }
    
    
    public int[] getX() {
        return this.x;
    }

    public int[] getY() {
        return this.y;
    }
    
    void setNom(String nom) {
        this.nom = nom;
    }

    void setX(int[] x) {
        this.x = x;
    }
    
    void setY(int[] y) {
        this.y = y;
    }
    
    public void setVivant(Object vivant) {
        this.vivants.add(vivant);
    }
    
    public Vivant[] getVivantObjet() { // liste des vivants -- tableaux
        Vivant[] liste = new Vivant[vivants.size()];
        for(int i=0;i<liste.length;i++) {
            liste[i]= (Vivant)vivants.get(i);
        }
        return liste;
    }
    
    public Vector getVivantVector() { // listes des vivants -- vector
        return this.vivants;
    }
    
    public Maison(String nom,int[] x,int[] y) { // CONSTRUSTEUR
        setNom(nom);
        setX(x);
        setY(y);
    }

    public Vector vivantSexe(int sexe) { // vivant selon le sexe donne 
        Vector result = new Vector(10,10);
        Vivant v = new Vivant();
        for(int i=0;i<vivants.size();i++) {
            v = (Vivant)vivants.get(i);
            if(v.getSexe() == sexe) {
                result.add(vivants.get(i));
            }
        }
        return result;
    }
}