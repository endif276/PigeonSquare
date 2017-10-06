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
    static ThreadGroup groupe = new ThreadGroup("balle");
     
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
    for(int i =0;i<NB_PIGEONS;i++){
        Pigeon pigeon1 = new Pigeon(panneau, groupe, "balle");
         
        pigeon1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
    }
     }
     
}