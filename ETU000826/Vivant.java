package vivant;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Vivant {
    String nom;
    int sexe, x, y;
    boolean vie;
    Date dateNaissance = new Date();

    // GET...

    public String getNom() {
        return nom;
    }

    public int getSexe() {
        return sexe;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }
    
    public int getAge() {
        Date jour = new Date();
        int result = jour.getYear() - this.dateNaissance.getYear();
        return result;
    }
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getVie() {
        return this.vie;
    }
    
    // SET...

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDateNaissance(Date date) {
        Date jour = new Date();
        int diff = jour.getYear()-this.dateNaissance.getYear();
        if(diff<0 || diff>100) {
            System.out.println("Date invalide");
            return; 
        }
        this.dateNaissance=date;
    }
    
    
    public void setVie(Boolean vie) {
        this.vie = vie;
    }

    void setSexe() {
        Random rand = new Random();
        int r = rand.nextInt();
        if(r % 2 == 0) {
            this.sexe = 0;           
        } else {
            this.sexe = 1;
        }
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }

    // CONSTRUCTEUR

    public Vivant(String nom,Date dateNaissance) {
        setNom(nom);
        setDateNaissance(dateNaissance);
        setSexe();
        Random r = new Random();
        int x = Math.abs(r.nextInt() % 500); 
        int y = Math.abs(r.nextInt() % 500); 
        setX(x);
        setY(y);
        setVie(true);
    }

    public Vivant() {}

}