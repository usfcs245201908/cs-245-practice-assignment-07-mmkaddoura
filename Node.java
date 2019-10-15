public class Node<T>{

	T data;
	Node next;

	public Node(T data){
		this.data=data;
		next=null;
	}

	public void setData(T data){
		this.data=data;
	}

	public void setNext(Node next){
		this.next=next;
	}

	public T getData(){
		return data;
	}

	public Node getNext(){
		return next;
	}
}