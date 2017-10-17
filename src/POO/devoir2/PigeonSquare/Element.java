package POO.devoir2.PigeonSquare;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public interface Element {
	
	static ArrayList<Human> lh=new ArrayList<Human>(); //Liste d'humain
	static ArrayList<Food> foodList=new ArrayList<Food>();//Liste de nourriture
	Lock lock = new ReentrantLock(); //Lock d'accès aux humains
	Lock lock2 = new ReentrantLock();// Lock d'accès aux élément food

}
