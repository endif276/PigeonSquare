import java.awt.Dimension;
import java.awt.Graphics;
 
import javax.swing.JPanel;
 
public class Pigeon extends Thread{
     
    int lower = 5;
    int higher = 30;
    int lower2 = 0;
    int higher2 = 500;
    int lower3 = 1;
    int higher3 = 5;
 
 
    private JPanel panneau;
    private int x =(int)(Math.random() * (higher2-lower2));
    private int y = (int)(Math.random() * (higher2-lower2));
    private int dx  =(int)(Math.random() * (higher3-lower3));
    private int dy  =(int)(Math.random() * (higher3-lower3));
 
//    private  final int taille =(int)(Math.random() * (higher-lower)) + lower;
    private  final int taille =30;
    
    public Pigeon(JPanel panneau, ThreadGroup groupe, String nom){
        super(groupe,nom);
        this.panneau=panneau;
 
    }
 
    public void dessine() {
        Graphics surface = panneau.getGraphics(); // récupère les ressources graphiques
        surface.fillOval(x, y, taille, taille); // pour permettre le tracé des dessins
        surface.dispose();  // libère les ressources graphiques pour d'autres applications
    }
 
    public void déplace() {
        Graphics surface = panneau.getGraphics();
        surface.setXORMode(panneau.getBackground());
        surface.fillOval(x, y, taille, taille);   // efface l'ancien tracé grâce
        x += dx; y += dy;                         // à la fonction XOR
        Dimension dim = panneau.getSize(); // dimension du panneau
        if (x<1) {
            x=1; dx = -dx;
        }
        if (x+taille >= dim.width ) {
            x = dim.width - taille; dx = -dx;
        }
        if (y<1) {
            y=1; dy = -dy; }
 
        if (y+taille >= dim.height ) {
            y = dim.height - taille; dy = -dy;
        }
        surface.fillOval(x, y, taille, taille); // trace le nouvel emplacement de la balle
        surface.dispose();
    }
    
    
    public void run() {
        try {
            dessine();
            while (!interrupted()) {
//                déplace(); 
                sleep(20);
            }
        }
        catch (InterruptedException e) {}
        Graphics surface = panneau.getGraphics();
        surface.setXORMode(panneau.getBackground());
        surface.fillOval(x, y, taille, taille);
         
    }
 
 
}