package POO.devoir2.PigeonSquare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Human extends Thread implements Element{
    private JPanel panneau;
  
    
	int lower = 5;
    int higher = 30;
    int lower2 = 0;
    int higher2 = 500;
    int lower3 = 1;
    int higher3 = 5;
  
    
    
    private int x =2;
    private int y = (int)(Math.random() * (higher2-lower2));
    private int dx  =(int)(Math.random() * (higher3-lower3));
    private int dy  =(int)(Math.random() * (higher3-lower3));
	
    private  final int taille =100;
    
    
	public Human(JPanel panneau, ThreadGroup groupe, String nom) {
		 
		        super(groupe,nom);
		        this.panneau=panneau;
		        
		       
		 
		    }
		 
		    public void dessine() {
		        Graphics surface = panneau.getGraphics(); // récupère les ressources graphiques
		       
		        surface.fillOval(x, y, taille, taille); // pour permettre le tracé des dessins
		        
		        surface.dispose();  // libère les ressources graphiques pour d'autres applications
		    
	}
		    
		    public void run() {
		        try {
		            dessine();
		            while (!interrupted()) {
		                deplace(); 
		                sleep(20);
		            }
		        }
		        catch (InterruptedException e) {}
		        Graphics surface = panneau.getGraphics();
		        surface.setXORMode(panneau.getBackground());
		        surface.fillOval(x, y, taille, taille);
		    }
		     
		    

		    public void deplace() {
		        Graphics surface = panneau.getGraphics();
		        surface.setXORMode(panneau.getBackground());
		        surface.fillOval(x, y, taille, taille);   // efface l'ancien tracé grâce
		        
		        x += dx; y += dy;                         // à la fonction XOR
		        Dimension dim = panneau.getSize(); // dimension du panneau
		        if ((x<1) || (y<1) ||(x+taille >= dim.width) || (y+taille >= dim.height) ) {
		        	 surface.setXORMode(panneau.getBackground());
				     surface.fillOval(x, y, taille, taille);
				
				     surface.dispose();
				     
				     this.interrupt();
				     Element.lh.remove(this);
				     return;
		        }
	
		        surface.fillOval(x, y, taille, taille); // trace le nouvel emplacement de la balle
		      
		        Element.lh.remove(this);
		        Element.lh.add(this);
		        surface.dispose();
		    }

			public int getX() {
			
				return x;
			}

			public int getY() {
			
				return y;
			}
		    
}
