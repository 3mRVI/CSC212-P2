import java.util.*;

public class LinkedList <T extends Comparable<T>>{
	public Node<T> head;
	public Node<T> current;
	
	public LinkedList () {
		head=current=null;
		
	}
	public boolean isEmpty() {
		return head == null;
	}
	public boolean first() {
		return current.previous == null;
	}
	public boolean last() {
		return current.next == null;
	}
	public void findFirst() {
		current = head;
	}
	public void findNext() {
		current = current.next;
	}
	public void findPrevious() {
		current = current.previous;
	}
	
	public T retrieve() {
		return current.data;
		
	}
	public void update(T data) {
		current.data = data;
	}
	public boolean addSort (T data) {
        Node<T> tmp;  
        if (isEmpty()) {  
                current = head = new Node (data);  
        }  
        else {  
            if ( head.getData().compareTo(data) >0)  
            {  
                tmp = new Node(data);  
                tmp.setNext(head);  
                head = tmp;  
            }  
            else  
            {  
                Node<T> prev = null;  
                current = head;  
                  
                while (( current != null ) && (current.getData().compareTo(data) <= 0))  
                {  
                    prev = current;  
                    current = current.getNext();  
                }  
                tmp = new Node (data);  
                if ( current != null)  
                {  
                    tmp.next = current;  
                    prev.next = tmp;  
                    current = tmp;  
                }  
                else  
                    current = prev.next =tmp;  
            }  
        }  
          
        return true;  
	}
//	public boolean addSort (T data) {
//		Node<T> tmp = new Node(data);
//		
//		if(isEmpty()) {
//			head = current = tmp;
//			return true;
//		}
//		current = head;
//		
//		while((current.getData().compareTo(data) <= 0 && (current != null) )) {
//			current = current.next;
//		}
//		if(first()) { //add at first
//			tmp.next=current;
//			current.previous = tmp;
//			head = tmp;
//			
//		}
//		
//		if(current == null) {  //add at last
//			tmp.previous = current.previous;
//			current.previous.next = tmp;
//			current = tmp;
//			
//		}
//		else { //add at middle
//			tmp.next = current;
//			current.previous.next = tmp;
//			current = tmp;
//			
//		}
//		return true;
//	}
	public boolean search(T data) {
		if(isEmpty()) {
			return false;
		}
		findFirst();// current = head
		
		while((current != null) && current.data.compareTo(data) != 0) {
			current = current.next;
		}
		if((current != null) && (current.data.compareTo(data) == 0)) {
			return true;
		}
		return false;
	}
	public boolean remove(T data) {
		if(search(data)== false) {
			return false;
		}
		if(current == head) {
			head = head.next;
			if(head != null) 
				head.previous=null;
		}
		else {
			current.previous.next= current.next;
			if(current.next != null)
				current.next.previous = current.previous;
		}
		if(current.next == null)
			current = head;
		else
			current = current.next;
		return true;
		
	}
	
	public void printAll () {  
        Node  p = head;  
        while ( p != null)  
        {  
            System.out.print(p.data + "    ");  
            p = p .next;  
        }  
        System.out.println("");  
    } 
}
