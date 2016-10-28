package lab3;

public class MyStack {
	
	private MyLinkedList list;
	private int size;
	
	public MyStack() {
		list = new MyLinkedList();
	}
	
	public void push(Object o) {
		list.add(o);
	}
	
	public Integer pop() {
		return (Integer)list.remove(size-1);
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

}
