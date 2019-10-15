public class LinkedList<T> implements List<T> {
	
	private Node head;
	private int size;

	public LinkedList(){
		head=null;
		size=0;
	}

	public void add(T item){
		if(head==null){
			head=new Node(item);
			size++;
		}
		else{
			Node prev=head;
			while(prev.next != null)
				prev=prev.next;
			Node curr = new Node(item);
			prev.next=curr;
			size++;
		}
	}

	public void add(int pos, T item){
		if(pos>size||pos<0)
			throw new RuntimeException("Invalid position");
		if(pos==0){
			Node curr = new Node(item);
			curr.setNext(head);
			head=curr;
			size++;
		}
		else{
			Node curr = new Node(item);
			Node prev = head;
			for(int i=0; i<pos-1; i++)
				prev=prev.next;
			curr.next=prev.next;
			prev.next=curr;
			size++;
		}
	}

	public int size(){
		return size;
	}

	public T remove(int pos){
		if(pos>size-1||pos<0)
			throw new RuntimeException("Invalid position");

		Node<T> curr=head;

		if(pos==0){
			head=head.getNext();
		} else{
			Node prev = null;
			for(int i=0; i<pos; i++) {
				prev = curr;
				curr = prev.getNext();
			}
			prev.setNext(curr.getNext());
		}
		size--;
		return curr.getData();
	}

	public T get(int pos){
		Node<T> curr = head;
		for(int i=0; i<pos; i++)
			curr = curr.next;

		return curr.getData();
	}
}