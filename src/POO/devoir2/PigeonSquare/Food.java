package POO.devoir2.PigeonSquare;


import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Food extends Thread implements Element{
	JPanel panneau;
	int x;
	int y;
	int taille = 10;
	String foodName = "0";
	Graphics foodDraw;
	boolean eatable;
	
	public Food(JPanel panneau, int x, int y) {
		this.panneau = panneau;
		this.eatable = true;
		this.x = x;
		this.y = y;
		
		Element.foodList.add(this);


	}
	
	 public void dessine() {
	        foodDraw = panneau.getGraphics(); // récupère les ressources graphiques
	        foodDraw.setColor(Color.GREEN);
	        foodDraw.fillOval(x, y, taille, taille); // pour permettre le tracé des dessins
	        foodDraw.dispose();  // libère les ressources graphiques pour d'autres applications
	        
	    }
	 
	 public void run(){
		
		 dessine();		
		 foodDraw.setColor(Color.GREEN);
		 try {
			sleep(4000); // Attend 4 sec
			if (eatable){
			foodDraw = panneau.getGraphics();
			foodDraw.fillOval(x, y, taille, taille);
			 foodDraw.setColor(Color.BLACK);
			 foodDraw.dispose();
			 setEatable(false);//Deviens non comestible
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	        }
	 
	


	public Graphics getFoodDraw() {
		return foodDraw;
	}

	public void setFoodDraw(Graphics foodDraw) {
		this.foodDraw = foodDraw;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isEatable() {
		return eatable;
	}

	public void setEatable(boolean eatable) {
		this.eatable = eatable;
	}

	public void remove() {
		setEatable(false);//Deviens non comestible
		 Graphics surface = panneau.getGraphics();
	        surface.setXORMode(panneau.getBackground());
	        surface.fillOval(x, y, taille, taille);   // efface l'ancien tracé grâce
		Element.foodList.remove(this);
		
	}

	

}
