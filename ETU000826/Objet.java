package objet;
import java.lang.reflect.*;
import java.util.*;
import java.awt.*;
import vivant.*;
import animal.*;
import maison.*;

public class Objet {
    Vector vivants;

    public Objet(Vector liste) {
        this.vivants = liste;
    }

    String toUpper0(String name) {
        name = name.toUpperCase();
        name = name.replaceFirst(name.substring(1),name.substring(1).toLowerCase());
        return name;
    }

    boolean chercher(String test,Object donne) {
        String indice = donne.toString();
        if(indice.charAt(0) == '%' && test.endsWith(indice.substring(1))) {
            return true;
        } else if(indice.charAt(indice.length() - 1) == '%' && test.startsWith(indice.substring(0,indice.length() - 1))) {
            return true;
        } else if(indice.charAt(0) == '%' && indice.charAt(indice.length() - 1) == '%' && test.contains(indice.substring(1,indice.length() - 1)))  {
            return true;
        } else if(test.compareTo(indice) == 0) {
            return true;
        }
        return false;
    }

    public Vector filtrer(String nA, Object val)throws Exception { // filter selon un attribut String
        String nF = "get" + this.toUpper0(nA);
        String vA = new String(); // valeur de l'attribut
        Vector result = new Vector(10,10);
        Method m=this.vivants.get(0).getClass().getMethod(nF);
        String aR = m.getGenericReturnType().getTypeName(); // type de retour de la fonction 
        if(aR.compareTo("java.lang.String") != 0) {
            System.out.println("L'attribut n'est pas un String , je ne sais pas !");
            return this.vivants;
        }
        for(int i=0;i<this.vivants.size();i++) {
            vA = (String)(m.invoke(this.vivants.get(i)));
            if(chercher(vA,val)) {
                result.add(this.vivants.get(i));
            }
        }
        return result;
    }

    boolean compareObject(Object a, Object b) { // compare 2 String ou int
        boolean result = false;
        String type = a.getClass().getSimpleName();
        if(type.compareTo("String") == 0) {
            String sA = (String)a, sB = (String)b;
            if(sA.compareTo(sB) < 0) {
                return true;
            }
        } else if(type.compareTo("int") == 0 && (int)a < (int)b) {
            return true;
        }
        return result;
    }

    public void trierDecr(String nA)throws Exception { // trier selon un attribut String et int 
        String nF="get" + this.toUpper0(nA); // nom de la fonction 
        Method m=this.vivants.get(0).getClass().getMethod(nF);
        Object avant, apres, temp;
        for(int i=0;i<this.vivants.size();i++) {
            avant = m.invoke(this.vivants.get(i));
            for(int j=i+1;j<this.vivants.size();j++) {
                apres = m.invoke(this.vivants.get(j));
                if(compareObject(avant, apres)) {
                    temp = this.vivants.get(i);
                    this.vivants.add(i,this.vivants.get(j));
                    this.vivants.add(j,temp);
                } 
            }
        }
        // for(Object o : vivant) {
            // System.out.println(m.invoke(o));
            // }
        }
        
        int getCategorie(Object o) {
            String[] tableau = {"Personne","Chien","Chat"};
            for(int i=0;i<tableau.length;i++) {
                if(o.getClass().getSimpleName().compareTo(tableau[i]) == 0) {
                    return i;
                }
            }
            return (-1);
        }
        
        
        public boolean aCote(Vivant cible,Vivant aTester,double rayon) { // test si atester est dans la zone de cible 
            double dx,dy,a;
            dx = ((double)(aTester.getX()) - (double)(cible.getX()));
            dy = (double)(aTester.getY()) - (double)(cible.getY());
            double distance = Math.sqrt(Math.pow(dx,2) + Math.pow(dy,2));
            if(distance < rayon) {
                return true;
            }
            return false;
        }
        
        int getAuTour(Vivant cible,String espece,int rayon) { // compte tout les animaux de type especes autour de cible
            int result = 0;
            Vivant v;
            Boolean esp,cote;
            for(int i=0;i<this.vivants.size();i++) {
                esp = (this.vivants.get(i).getClass().getSimpleName().compareTo(espece) == 0);
                cote = aCote(cible,(Vivant)(this.vivants.get(i)),rayon);
                v = (Vivant)(this.vivants.get(i));
                if(esp && v.getVie() && cote) {
                    result++;
                }
            }
            return result;
        }
        
    public void enVie(Vivant cible,int rayon) { //  tuer ou non l'animal selon la situation
        if(!cible.getVie()) {return;}
        boolean chien,chat,personne,danger;
        chien = (cible instanceof Chien && getAuTour(cible,"Chat",(rayon * 10)) > 2);
        chat = (cible instanceof Chat && getAuTour(cible,"Chien",rayon) > 0);
        if(chien || chat) {
            cible.setVie(false);
            System.out.println(cible.getNom() +" est mort !!!");
        }
    }
    
    public void dessiner(Object ob,Graphics g) {
        int categorie = this.getCategorie(ob);
        Vivant viv = (Vivant)ob;
        if(!viv.getVie()) {return;}
        if(categorie == 0) {
            g.setColor(Color.green); // Personne
            g.fillRect(viv.getX(),viv.getY(),25,25);
        } else if(categorie == 1) {
            g.setColor(Color.blue); // Chien
            g.fillOval(viv.getX(),viv.getY(),25,15);
        } else {
            g.setColor(Color.red); // Chat
            g.fillOval(viv.getX(),viv.getY(),15,15);
        }
    }
    
    public void deplacer(Vivant vivant,int largeur,int hauteur) {
        if(!vivant.getVie()) {return;}
        Random r = new Random();
        int x,y; 
        x = r.nextInt() % 6;
        y = r.nextInt() % 6;
        vivant.setX(vivant.getX() + x);
        vivant.setY(vivant.getY() + y);
        if(vivant.getX() > largeur) {
            vivant.setX(vivant.getX() - 10);
        }
        if(vivant.getY() > hauteur) {
            vivant.setY(vivant.getY() - 10);
        }
        if(vivant.getX() < 1) {
            vivant.setX(vivant.getX() + 10);
        }
        if(vivant.getY() < 1) {
            vivant.setY(vivant.getY() + 10);
        }
    }
    
    public Vector getEspeces(String especes) {
        Vector result = new Vector(10,10);
        for (int i = 0; i < this.vivants.size(); i++) {
            Vivant a = (Vivant)(this.vivants.get(i));
            if(a.getVie() && this.vivants.get(i).getClass().getSimpleName().compareTo(toUpper0(especes)) == 0) {
                result.add(this.vivants.get(i));
            }
        }
        return result;
    }
    
    public void enlever(String enlever) {
        Vector esp = getEspeces(enlever);
        for (int i = 0; i < esp.size(); i++) {
            Vivant a = (Vivant)(esp.get(i));
            if(a.getVie()) {
                a.setVie(false);
                System.out.println(a.getNom() +" est eliminer");
            }
        }
    }
    
    Maison getMaison(Maison[] listMais,String nom) {
        for (int i = 0; i < listMais.length; i++) {
            if(listMais[i].getNom().compareTo(nom) == 0) {
                return listMais[i];
            }
        }
        return listMais[0];
    }
    
    public void rentrer(Maison[] listMais,String categ,String nomMaison) {
        Maison m = getMaison(listMais,nomMaison);
        Vector esp = getEspeces(categ);
        for (int i = 0; i < esp.size(); i++) {
            m.setVivant(esp.get(i));
        }
        enlever(categ);
        return;
    }
    
    public void reinit() {
        Vivant v;
        for (int i = 0; i < this.vivants.size(); i++) {
            v = (Vivant)(this.vivants.get(i));  
            if(!v.getVie()) {
                v.setVie(true);
            }
        }
    }
}