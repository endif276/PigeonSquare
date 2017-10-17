package testPigeon;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
//    Food foodList = new Food();
    static ArrayList<Food> foodList = new ArrayList<>();
    static ArrayList<Graphics> foodListView = new ArrayList<>();
    
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
      		// TODO Auto-generated method stub
//      		Graphics foodView = panneau.getGraphics(); // récupère les ressources graphiques
//      		System.out.print(foodView);
//      		foodView.setColor(Color.GREEN);
//            foodView.fillOval(e.getX() - 5, e.getY() - 30, 10, 10); // pour permettre le tracé des dessins
//            foodView.dispose();
//            
            
            
      		Food food = new Food(panneau,e.getX() - 5, e.getY() - 30);
      		food.start();
//      		food.setFoodDraw(panneau.getGraphics());
//      		food.getFoodDraw().setColor(Color.GREEN);
//            food.getFoodDraw().fillOval(e.getX() - 5, e.getY() - 30, 10, 10); // pour permettre le tracé des dessins
//            food.getFoodDraw().dispose();
            foodList.add(food);
            System.out.print(foodList);
            addFoodPigeon(food);
      	}
      };
    
    
      
    public View() {
      this.setSize(DEFAULT_WIDTH_FENETRE,DEFAULT_HEIGHT_FENETRE);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       contentPane = (JPanel) this.getContentPane();
       contentPane.add(panneau);
       this.setVisible(true);
       this.addMouseListener(mouse);
       
       p1 = new Pigeon(panneau);
       p1.start();
       p2 = new Pigeon(panneau);
       p2.start();
       p3 = new Pigeon(panneau);
       p3.start();
       
       
//       foodList = new Food();
       
      }
    
    static void addFoodPigeon(Food food) {
    		p1.getFoodList().add(food);
    		p2.getFoodList().add(food);
    		p3.getFoodList().add(food);
    }

    public void addFood() {
//    	foodList.addFoodList();
    }
    
}
