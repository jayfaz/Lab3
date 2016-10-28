package lab3;

public class MyArrayList implements MyList{

	private Object[] array;
	
	
	public MyArrayList() {
		array = new Object[10];
	}
	
	@Override
	public int size() {
		return array.length;
	}
	
	@Override
	public boolean add(int index, Object t) {
		if(array[size()-1] != null) {
			Object[] resizeArray;
			resizeArray = new Object[size()*2];
			for(int i = 0; i < size(); i++) {
				resizeArray[i] = array[i];
			}
			array = resizeArray;
		}
		if(array[index] == null && index >= 0 || index < size()) {
			array[index] = t;
		}
		
		return false;
	}

	@Override
	public boolean add(Object o) {
		if(array[size()-1] != null) {
			Object[] resizeArray;
			resizeArray = new Object[size()*2];
			for(int i = 0; i < size(); i++) {
				resizeArray[i] = array[i];
			}
			array = resizeArray;
		}
		for(int i = 0; i < size(); i++) {
			if(array[i] == null) {
				array[i] = o;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean clear() {
		array = new Object[size()];
		return true;
	}

	@Override
	public boolean contains(Object o) {
		for(int i = 0; i < size(); i++) {
			if(array[i] == o) {
				return true;	
			}
		}
		return false;
	}

	@Override
	public Object get(int index) {
		if(index < 1 || index > size()) {
			System.out.println("Not a valid index");
			return null;
		} else {
			return array[index -1];
		}
	}

	@Override
	public int indexOf(Object o) {
		for(int i = 0; i < size(); i++) {
			if(array[i] == o) {
				return i;
			}
		}
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if(size() < 0) {
			return true;
		}
		return false;
	}

	@Override
	public Object remove(int index) {
		if(array[index] != null) {
			array[index] = null;
			for(int i = index; i < size() - 1; i++) {
				array[i] = array[i + 1];
			}
		}
		array[size() -1] = null;
		return array[index];
	}

	@Override
	public Object remove(Object o) {
		int index = 0;
		for(int i = 0; size() < 0; i++) {
			if(array[i] == o) {
				index = i;
				array[i] = null;
				
			}
		}
		return array[index];
	}

	@Override
	public boolean set(int index, Object element) {
		if(size() > index) {
			array[index] = element;
			return true;
		}
		return false;
	}

	@Override
	public MyList subList(int fromIndex, int toIndex) {
		if(fromIndex < 0 || fromIndex > size() && toIndex < 1 || toIndex > size()) {
			return null;
		}
		MyList currentList = new MyArrayList();
		for(int i = fromIndex; i < toIndex; i++) {
			currentList.add(array[i]);
		}
		return currentList;
	}

	@Override
	public Object[] toArray() {
		return array;
	}

	@Override
	public boolean swap(int position1, int position2) {
		Object placeHolder;
		if((position1 < size() && position2 < size()) && position1 >= 0 && position2 >= 0) {
			placeHolder = array[position1];
			array[position1] = array[position2];
			array[position2] = placeHolder;
			return true;
		}
		return false;
	}

	@Override
	public boolean shift(int positions) {
		if(positions < size() && positions > 0) {
			Object[] array2 = new Object[size()];
			for(int i = 0; i < (size()-positions); i++) {
				array2[i + positions] = array[i];
			}
			int counter = 0;
			for(int i = (size()-positions); i < size(); i++) {
				array2[counter] = array[i];
				counter++;
			}
			array = array2;
			return true;
		} else if(positions < 0 && Math.abs(positions) < size()) {
			Object[] array2 = new Object[size()];
			int counter = 0;
			for(int i = Math.abs(positions); i < size(); i++) {
				array2[counter] = array[i];
			}
			for(int i = 0; i < positions; i++) {
				array2[size() - Math.abs(positions)] = array[i];
			}
			array = array2;
			return true;
		} else {
			return false;
		}
	}
	
	
}
