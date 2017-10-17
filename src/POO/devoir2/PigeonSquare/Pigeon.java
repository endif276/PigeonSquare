package POO.devoir2.PigeonSquare;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;

import javax.swing.JPanel;
 
public class Pigeon extends Thread implements Element{
     
    int lower = 5;
    int higher = 30;
    int lower2 = 0;
    int higher2 = 500;
    int lower3 = 1;
    int higher3 = 5;
 
    
    Food ClosestFood;
 
    private JPanel panneau;
    Graphics pigeonDraw;
    
    
    private int x =(int)(Math.random() * (higher2-lower2));
    private int y = (int)(Math.random() * (higher2-lower2));
    private int dx  =(int)(Math.random() * (higher3-lower3))+1;
    private int dy  =(int)(Math.random() * (higher3-lower3))+1;
 

    private  final int taille =30;
    
    public Pigeon(JPanel panneau, ThreadGroup groupePigeon, String nom){
        super(groupePigeon,nom);
        this.panneau=panneau;
        dessine();
       
 
    }
 
    public void dessine() {
    	//Dessine le Pigeon
        Graphics surface = panneau.getGraphics(); // récupère les ressources graphiques
        surface.fillOval(x, y, taille, taille); // pour permettre le tracé des dessins
        surface.dispose();  // libère les ressources graphiques pour d'autres applications
    }
 
    public void deplace() {
    	//Deplace le Pigeon
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
    
    public void moveToFood() {
    	//Rapproche le pigeon de sa nourriture
    	
        Graphics surface = panneau.getGraphics();
        surface.setXORMode(panneau.getBackground());
        surface.fillOval(x, y, taille, taille);   // efface l'ancien tracé grâce
    	
        if(x<ClosestFood.getX()) x += dx;
        else x-=dx;
        
        if((Math.abs(x-ClosestFood.getX())<2) && Math.abs(y-ClosestFood.getY())<2) {
        	ClosestFood.remove();
        	
        }
        
        if(y<ClosestFood.getY()) y += dy;
        else y-=dy;   
        
        
        surface.fillOval(x, y, taille, taille); // trace le nouvel emplacement de la balle
        surface.dispose();
    	
    	
    }
    
    
    public void run() {
       
            dessine();
            while (!interrupted()) {
                
            	Iterator<Human> it = Element.lh.iterator();
            	Human Humain;
            	
            	while(it.hasNext()) {
            		
            		
            		
            		
            		while(!lock.tryLock());
            		try {
            		Humain = (Human)it.next();
            		
            		
            		
            	
            		while((Math.abs(this.x - Humain.getX())< 100) && (Math.abs(this.y - Humain.getY())<100)) {
            			
            			
            			deplace();

            		sleep(20);
            	}
            		}catch(Exception e) {
                		
                		
                	}finally {
                		
                		lock.unlock();
                		
                	}
            	}
            	
                if(foodListEatable()) {
                	
         
                	
                	this.ClosestFood = lookClosestFood();
    	        	moveToFood();
    	        	try {
						sleep(20);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}

    	        }
            	
            
            }
            	
            	
         
    }
    
    
    
	public Food lookClosestFood() {
		//chercher la nourriture la plus proche

		Food ClosestFood = null;
		while(!lock2.tryLock());
		if(foodListEatable()) {
		int distMin = 5000;
		int xMin = 5000;
		int yMin = 5000;
		
		for(int i = 0; i < foodList.size(); i++) {
			int xTemp = foodList.get(i).getX();
			int yTemp = foodList.get(i).getY();
			
			int distTemp = Math.abs(xTemp -x) + Math.abs(yTemp - y);
			if((distTemp < distMin) && foodList.get(i).isEatable()) {
				distMin = distTemp;
				xMin = xTemp;
				yMin = yTemp;
				ClosestFood = foodList.get(i);
			}
	//	xFood = xMin - 10;
	//	yFood = yMin;
		}
		
		
		}
		
		lock2.unlock();
		
		return ClosestFood;
	}

	public boolean foodListEatable() {
		//Cherche si il y a de la nourriture mangeable
		
		try {
		for(int i = 0; i < foodList.size(); i++) {
			if(foodList.get(i).isEatable()) return true;
		}}catch(NullPointerException e) {
			
		}
		return false;
	}
	
	public JPanel getPanneau() {
		return panneau;
	}

	public void setPanneau(JPanel panneau) {
		this.panneau = panneau;
	}

	public Graphics getPigeonDraw() {
		return pigeonDraw;
	}

	public void setPigeonDraw(Graphics pigeonDraw) {
		this.pigeonDraw = pigeonDraw;
	}


 
 
}