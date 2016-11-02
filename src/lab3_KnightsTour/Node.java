package lab3_KnightsTour;


public class Node { 
    Node next; 
    Object o;

    public Node(Object o) { 
        next = null;
        this.o = o;
    } 

    public Node(Node next, Object o) { 
        this.next = next; 
        this.o = o;
    }
    
    public Node next() {
    	return next;
    }
    
    public Object getObject() {
    	return o;
    }
    
    public void setObject(Object o) {
    	this.o = o;
    }

    public void setNext(Node n) {
    	next = n;
    }
    
    public Node removeNextNode(Node n) {
    	next = n.next().next();
    	return next;
    }
}
