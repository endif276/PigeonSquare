package testPigeon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.math.MathContext;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Pigeon extends Thread{
	JPanel panneau;
	Graphics pigeonDraw;
	int taille = 40;
	int x = (int)( Math.random() * 300);
	int y = (int)( Math.random() * 300);
	private int dx = 1;
    private int dy = 1;
    ArrayList<Food> foodList;
    
    int xFood;
    int yFood;
//	Thread t1;
//	Thread t2;
//	ThreadGroup tg;
//	
	
	public Pigeon(JPanel panneau) {
		this.panneau = panneau;
		foodList = new ArrayList<>();
//		foodList = new ArrayList<>();
		
		
//		t1 = new Thread(tg, new Runnable() {
//		    public void run() {
//			System.out.println("Hello from t1");
//		    }
//		}, "t1");
//
//		t2 = new Thread(tg, new Runnable() {
//		    public void run() {
//			System.out.println("Hello from t2");
//		    }
//		}, "t2");		
	}
	
	 public void dessine() {
	        pigeonDraw = panneau.getGraphics(); // récupère les ressources graphiques
	        pigeonDraw.setColor(Color.BLUE);
	        pigeonDraw.fillOval(x, y, taille, taille);	       
	        pigeonDraw.dispose();  // libère les ressources graphiques pour d'autres applications 	        
	    }
	 
	 public void déplace() {
	        pigeonDraw = panneau.getGraphics();
	        pigeonDraw.setXORMode(panneau.getBackground());
	        pigeonDraw.setColor(Color.BLUE);
	        pigeonDraw.fillOval(x, y, taille, taille);   // efface l'ancien tracé grâce
	        if(x<xFood) x += dx;
	        else x-=dx;
	        
	        if(y<yFood) y += dy;
	        else y-=dy;                         // à la fonction XOR
	        Dimension dim = panneau.getSize(); // dimension du panneau
//	        if (x<1) {
//	            x=1; dx = -dx;
//	        }
//	        if (x+taille >= dim.width ) {
//	            x = dim.width - taille; dx = -dx;
//	        }
//	        if (y<1) {
//	            y=1; dy = -dy; }
//	 
//	        if (y+taille >= dim.height ) {
//	            y = dim.height - taille; dy = -dy;
//	        }
	        pigeonDraw.fillOval(x, y, taille, taille); // trace le nouvel emplacement de la balle
	        pigeonDraw.dispose();
	    }
	
	public void run(){
//		System.out.print(panneau.getGraphics());
//		panneau.getGraphics();
		dessine();
        pigeonDraw.setXORMode(panneau.getBackground());

		while (!interrupted() || !(x==xFood && y==yFood)) {
		  lookClosestFood(foodList);
          déplace(); 
          try {
			sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          pigeonDraw.setColor(Color.BLUE);
      }
	        }
	
	public void lookClosestFood(ArrayList<Food> foodList) {
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
			}
		xFood = xMin - 10;
		yFood = yMin;
		}
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

	public ArrayList<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(ArrayList<Food> foodList) {
		this.foodList = foodList;
	}

	
	
	}

