package POO.devoir2.PigeonSquare;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;
 
 
 
public class PigeonSquare extends JFrame{
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_HEIGHT_FENETRE = 500;
    private static final int DEFAULT_WIDTH_FENETRE = 650;
//    private static final int DELAY_REFRESH = 25;
    private static final int NB_PIGEONS = 5;
    protected static final int TY_BORD = 5;
     
    static JPanel panneau = new JPanel();
    JPanel contentPane;
    static ThreadGroup groupePigeon = new ThreadGroup("pigeon");
    static ThreadGroup groupeHumain = new ThreadGroup("humain");
    
    static ArrayList<Human> lh = new ArrayList<Human>();
    
    
    
     
    public PigeonSquare() {
//    super("Balles rebondissantes");
    this.setSize(DEFAULT_WIDTH_FENETRE,DEFAULT_HEIGHT_FENETRE);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      
     
     contentPane = (JPanel) this.getContentPane();
     contentPane.add(panneau);
     this.setVisible(true);
     
     
     
     
     
    }
     
     
     
     
     public static void main(String[] args) {
    new PigeonSquare();
    
    double time=0;
    
	    
	    for(int i =0;i<NB_PIGEONS;i++){
	        Pigeon pigeon1 = new Pigeon(panneau, groupePigeon, "pigeon");
	         
	        pigeon1.start();
	        try {
	            Thread.sleep(500);
	        } catch (InterruptedException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	         
	    }
	    
	    
	    
	    Timer t = new Timer();
	    	    	
	    	TimerTask tk = new TimerTask() {
		    	
		    	public void run() {
		    		
			        
			        Human bonhomme1 = new Human(panneau, groupeHumain, "humain");
				       
			        bonhomme1.start();	
		    		
		    	
		    	try {
		            Thread.sleep(500);
		        } catch (InterruptedException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		    	}
		    	
		    };

	
      
       t.schedule(tk, 1000,7000);
       
        
        
    
     }
     
}
     
