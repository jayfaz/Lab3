package lab3_KnightsTour;
import java.util.ArrayList;

public class MyStack {
	
	private ArrayList<Integer> list;
	
	public MyStack() {
		list = new ArrayList<Integer>();
	}
	
	public void push(Integer o) {
		list.add(o);
	}
	
	public Integer pop() {
		return list.remove(list.size()-1); //pops off the top 
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public int size() {
		return list.size();
	}

}
