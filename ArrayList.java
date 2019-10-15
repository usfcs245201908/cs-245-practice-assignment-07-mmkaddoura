public class ArrayList<T> implements List<T> {

	private int size;
	private T[] a;

	public ArrayList(){
		size=0;
		a = (T[]) new Object[10];
	}

	private void growArray(){
		T[] a2 = (T[]) new Object[a.length*2];
		for(int i=0;i<a.length;i++) {
			a2[i]=a[i];
		}

		a=a2;
	}

	public int size(){
		return this.size;
	}

	public void add(T item){
		if (size==a.length)
			growArray();
		a[size++]=item;
	}

	public void add(int pos, T item){
		if (pos<0||pos>a.length)
			throw new RuntimeException("Invalid position");
		if (size==a.length)
			growArray();
		for (int i=size-1; i>=pos; i--)
			a[i]=a[i-1];
		a[pos]=item;
		size++;
	}

	public T get(int pos){
		if (pos<0||pos>a.length)
			throw new RuntimeException("Invalid position");
		return a[pos];
	}

	public T remove(int pos){
		if (pos<0||pos>a.length)
			throw new RuntimeException("Invalid position");
		T item = a[pos];
		for(int i=pos; i<a.length-1; i++)
			a[i]=a[i+1];
		size--;
		return item;
	}
}