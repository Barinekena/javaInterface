package animal;
import java.util.*;
import vivant.*;
public class Chien extends Animal {
    int agr;

    public int getAgr() {
        return this.agr;
    }

    void setAgr(int agr) {
        this.agr=agr;
    }

    public Chien(String nom,Date dateNaissance,int agr) {
        super(nom,dateNaissance);
        setAgr(agr);
    }
}