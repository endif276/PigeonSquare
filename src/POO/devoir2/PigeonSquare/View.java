package POO.devoir2.PigeonSquare;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class View extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  final int DEFAULT_HEIGHT_FENETRE = 500;
    private  final int DEFAULT_WIDTH_FENETRE = 650;
	static JPanel panneau = new JPanel();	   
    JPanel contentPane;


    static ArrayList<Graphics> foodListView = new ArrayList<>();
    
    static ThreadGroup groupePigeon = new ThreadGroup("pigeon");
    static ThreadGroup groupeHumain = new ThreadGroup("humain");
    
    static Pigeon p1;
    static Pigeon p2;
    static Pigeon p3;
    
    
    static MouseListener mouse = new MouseListener() {
      	
      	@Override
      	public void mouseReleased(MouseEvent e) {
      		// TODO Auto-generated method stub
      		
      	}
      	
      	@Override
      	public void mousePressed(MouseEvent e) {
      		// TODO Auto-generated method stub
      		
      	}
      	
      	@Override
      	public void mouseExited(MouseEvent e) {
      		// TODO Auto-generated method stub
      		
      	}
      	
      	@Override
      	public void mouseEntered(MouseEvent e) {
      		// TODO Auto-generated method stub
      		
      	}
      	
      	@Override
      	public void mouseClicked(MouseEvent e) {

         
      		Food food = new Food(panneau,e.getX() - 5, e.getY() - 30);
      		food.start();


      	}
      };
    
    
      
    public View() {
      this.setSize(DEFAULT_WIDTH_FENETRE,DEFAULT_HEIGHT_FENETRE);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       contentPane = (JPanel) this.getContentPane();
       contentPane.add(panneau);
       this.setVisible(true);
       this.addMouseListener(mouse);
       
       p1 = new Pigeon(panneau,groupePigeon, "pigeon");
       p1.start();
       p2 = new Pigeon(panneau,groupePigeon, "pigeon");
       p2.start();
       p3 = new Pigeon(panneau,groupePigeon, "pigeon");
       p3.start();
       
       

       
       
       Timer t = new Timer();
   	
   		TimerTask tk = new TimerTask() {
	    	
	    	public void run() { //Génère un humain
	    		
		        
		        Human bonhomme1 = new Human(panneau, groupeHumain, "humain");
			       
		        bonhomme1.start();	
	    		
	    	
	    	try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	           
	            e.printStackTrace();
	        }
	    	}
	    	
	    };


 
  t.schedule(tk, 1000,7000); //Programme la génération d'un humain toute les 7sec
  
       
      }
    
    static void addFoodPigeon(Food food) {

    }

    public void addFood() {
//    	foodList.addFoodList();
    }
    
}
