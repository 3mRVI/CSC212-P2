// CLASS: PhaseTwo.java

// CSC212 Data structures - Project phase II

// Fall 2023

// EDIT DATE:

// 

// TEAM:

// O.Y.A

// AUTHORS:

// Yazeed Aljarwan(443105683) Omar Alotabi (443101535) Abdullah Aldawood, (443105732) 

// ***/
public class Node<T> {
	public T data;
	public Node<T> next;
	public Node<T> previous;
	
	public Node (){
		data = null;
		next = null;
		previous = null;
	}
	
	public Node (T data){
		this.data = data;
		next = null;
		previous = null;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}

	public Node<T> getPrevious() {
		return previous;
	}

	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	
	
}
