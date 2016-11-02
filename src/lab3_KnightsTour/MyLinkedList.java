package lab3_KnightsTour;

public class MyLinkedList implements MyList {

	private Node head;
	private Node tail;
	private int size;

	public MyLinkedList() {
		head = null;
		tail = null;
	}

	public MyLinkedList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

	public MyLinkedList(Node head, Node tail, int size) {
		this.head = head;
		this.tail = tail;
		this.size = size;
	}

	public boolean add(int index, Object t) { 
		if (index == size()) {
			add(t);
			return true;
		}
		Node currentNode = head;
		Node theNode;
		Node toConnect;
		if (!(indexInList(index))) {
			return false;
		} else {
			if (index == 0) {
				head = new Node(t);
				head.setNext(currentNode);
				size++;
				return true;
			} else {
				for (int i = 1; i < index; i++) {
					currentNode = currentNode.next();
				}
				toConnect = currentNode.next();
				currentNode.setNext(new Node(t));
				theNode = currentNode.next();
				theNode.setNext(toConnect);
				size++;
				return true;
			}
		}
	}

	public boolean add(Object o) {
		if (head == null) {
			head = new Node(o);
			tail = head;
			size++;
			return true;
		} else {
			tail.setNext(new Node(o));
			tail = tail.next();
			size++;
			return true;
		}
	}

	public boolean clear() {
		head = null;
		tail = null;
		size = 0;
		return true;
	}

	public boolean contains(Object o) {
		Node currentNode = head;
		for (int i = 0; i < size(); i++) {
			if (currentNode.getObject().equals(o)) {
				return true;
			}
			currentNode = currentNode.next();
		}
		return false;
	}

	public Object get(int index) {
		if (!(indexInList(index))) {
			return null;
		} else {
			Node currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next();
			}
			return currentNode.getObject();
		}
	}

	public int indexOf(Object o) {
		int counter = 0;
		Node currentNode = head;
		do {
			if (currentNode.getObject().equals(o)) {
				return counter;
			} else {
				currentNode = currentNode.next();
				counter++;
			}
		} while (currentNode != null);
		return -1;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public Object remove(int index) {
		Node currentNode = head;
		if (index == size - 1) {
			for (int i = 0; i < size - 2; i++) {
				currentNode = currentNode.next();
			}
			Node oldTail = currentNode.next();
			tail = currentNode;
			tail.setNext(null);
			size--;
			return oldTail;
		}
		if (!(indexInList(index))) {
			return null;
		}
		if (index == 0) {
			head = head.next();
			size--;
			return currentNode;
		}
		for (int i = 1; i < index; i++) {
			currentNode = currentNode.next();
		}
		Object toRemove = currentNode.next().getObject();
		currentNode = currentNode.removeNextNode(currentNode);
		size--;
		return toRemove;
	}

	public Object remove(Object o) {
		Node currentNode = head;
		if (currentNode.getObject().equals(o)) {
			head = head.next();
			size--;
			return currentNode;
		}
		do {
			if (currentNode.next().getObject().equals(o)) {
				currentNode = currentNode.removeNextNode(currentNode);
				size--;
				return currentNode;
			} else {
				currentNode = currentNode.next();
			}
		} while (currentNode.next() != null);
		return null;
	}

	public boolean set(int index, Object element) {
		if (!(indexInList(index))) {
			return false;
		}
		Node currentNode = head;
		for (int i = 0; i < index; i++) {
			currentNode = currentNode.next();
		}
		currentNode.setObject(element);
		return true;
	}

	public int size() {
		return size;
	}

	public MyList subList(int fromIndex, int toIndex) { // head then toIndex-1 
		Node newHead = null;
		Node newTail = null;
		if (indexInList(fromIndex) && indexInList(toIndex-1)) {
			Node currentNode = head;
			for (int i = 0; i < toIndex; i++) {
				if (i == fromIndex) {
					newHead = currentNode;
				}
				currentNode = currentNode.next();
			}
			newTail = currentNode;
			return new MyLinkedList(newHead, newTail, toIndex - fromIndex);
		}
		return null;
	}

	public Object[] toArray() {
		Object[] array = new Object[size];
		Node currentNode = head;
		for (int i = 0; i < size; i++) {
			array[i] = currentNode;
			currentNode = currentNode.next();
		}
		return array;
	}

	public boolean swap(int position1, int position2) { 
		if(position1 > position2) {
			int temp = position1;
			position1 = position2;
			position2 = temp;
		}
		if(indexInList(position1) && indexInList(position2)) {
			Node currentNode = head;
			Node tempNode1 = null;
			Object data1;
			for(int i = 0; i < position2; i++) {
				if(i == position1) {
					tempNode1 = currentNode;
				}
				currentNode = currentNode.next();
			}
			data1 = tempNode1.getObject();
			tempNode1.setObject(currentNode.getObject());
			currentNode.setObject(data1);
			return true;
		}
		return false;
	}

	public boolean shift(int positions) { // positions - size for negative
		   if(positions < 0) {
		      for(int i = 0; i < Math.abs(positions); i++) {
		         Node temp1 = head;
		         head = head.next();
		         temp1.setNext(null);
		         tail.setNext(temp1);
		         tail = temp1;
		      }
		      return true;
		   }
		   else if(positions > 0) {
		      for(int i = 0; i < (size - positions); i++) {
		         Node temp2 = head;
		         head = head.next();
		         temp2.setNext(null);
		         tail.setNext(temp2);
		         tail = temp2;
		      }
		      return true;
		   } else {
		      return false;
		   }
		}

	public boolean indexInList(int index) {
		if (index < 0 || index >= size) {
			return false;
		} else {
			return true;
		}
	}

}