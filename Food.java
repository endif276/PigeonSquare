package testPigeon;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Food extends Thread{
	JPanel panneau;
	int x;
	int y;
	String foodName = "0";
	Thread t1;
	Thread t2;
	ThreadGroup tg;
	ArrayList<Thread> foodList;
	Graphics foodDraw;
	boolean eatable;
	
	public Food(JPanel panneau, int x, int y) {
		this.panneau = panneau;
		this.eatable = true;
		this.x = x;
		this.y = y;
//		tg = new ThreadGroup("pigeons");
//		tg = new ThreadGroup("food");
//		t1 = new Thread(tg, new Runnable() {
//		    public void run() {
//			System.out.println("Hello food from t1");
//			try {
//				Thread.sleep(4000);
//				System.out.println("food DEAD from t1");
//				foodDraw.setColor(Color.black);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    }
//		}, "t1");
//		new Thread(tg, new Runnable() {
//		    public void run() {
//			System.out.println("Hello food from tNew");
//			try {
//				Thread.sleep(4000);
//				foodDraw.setColor(Color.black);
//				System.out.println("food DEAD from tNew");
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		    }
//		}, foodName).start();
System.out.print("x : " + x +"\n y : " + y +"\n" );
	}
	
	 public void dessine() {
	        foodDraw = panneau.getGraphics(); // récupère les ressources graphiques
	        foodDraw.setColor(Color.GREEN);
	        foodDraw.fillOval(x, y, 10, 10); // pour permettre le tracé des dessins
	        foodDraw.dispose();  // libère les ressources graphiques pour d'autres applications
	    }
	 
	 public void run(){
		 System.out.print(panneau.getGraphics());
		 dessine();		
		 foodDraw.setColor(Color.GREEN);
		 try {
			sleep(4000);
			System.out.print("test");
			foodDraw = panneau.getGraphics();
			foodDraw.fillOval(x, y, 10, 10);
			 foodDraw.setColor(Color.BLACK);
			 foodDraw.dispose();
			 setEatable(false);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	        }
	 
	
	public void addFoodList() {
		new Thread(tg, new Runnable() {
		    public void run() {
			System.out.println("Hello food from tNew");
			try {
				Thread.sleep(4000);
				System.out.println("food DEAD from tNew");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    }
		}, foodName).start();
		
		Integer intFoodName = new Integer(foodName);
		intFoodName++;
		
		foodName = intFoodName.toString();
		
	}

	public Thread getT1() {
		return t1;
	}

	public void setT1(Thread t1) {
		this.t1 = t1;
	}

	public Thread getT2() {
		return t2;
	}

	public void setT2(Thread t2) {
		this.t2 = t2;
	}

	public ThreadGroup getTg() {
		return tg;
	}

	public void setTg(ThreadGroup tg) {
		this.tg = tg;
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

	

}
