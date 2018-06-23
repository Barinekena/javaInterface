package animal;
import java.util.*;
import vivant.*;
public class Chat extends Animal {
    int fft;

    public int getFft() {
        return this.fft;
    }

    void setFft(int fft) {
        this.fft = fft;
    } 

    public Chat(String nom,Date dateNaissance,int fft) {
        super(nom,dateNaissance);
        setFft(fft);
    }
}