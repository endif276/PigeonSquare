package POO.devoir2.PigeonSquare;

public abstract class PanElement implements Element{
	int lower = 5;
    int higher = 30;
    int lower2 = 0;
    int higher2 = 500;
    int lower3 = 1;
    int higher3 = 5;
    
    
    private int x =(int)(Math.random() * (higher2-lower2));
    private int y = (int)(Math.random() * (higher2-lower2));
    private int dx  =(int)(Math.random() * (higher3-lower3));
    private int dy  =(int)(Math.random() * (higher3-lower3));
}
