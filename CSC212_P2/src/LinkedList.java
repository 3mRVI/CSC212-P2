public class LinkedList <T extends Comparable<T>>{
	public Node<T> head;
	public Node<T> current;
	
	public LinkedList () {
		head=current=null;
	}
	public boolean isEmpty() {
		return head == null;
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
	
	public T retrieve() {
		return current.data;
		
	}
	public void update(T data) {
		current.data = data;
	}
	public boolean addSort (T data) {// this method will add objects sorted according to their respective compareTo method
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
                Node<T> previous = null;  
                current = head;  
                  
                while (( current != null ) && (current.getData().compareTo(data) <= 0))  
                {  
                    previous = current;  
                    current = current.getNext();  
                }  
                tmp = new Node (data);  
                if ( current != null)  
                {  
                    tmp.next = current;  
                    previous.next = tmp;  
                    current = tmp;  
                }  
                else  
                    current = previous.next =tmp;  
            }  
        }  
          
        return true;  
	}//O(n)

	public boolean search(T data) {//this method will search for object in a linked list then if found return true. 
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
	}//O(n)

	
	public boolean remove(T data) {
		if (search (data) == false)  
	         return false;  
	     
	    if (current == head) {  
	    	head = head.next;  
	    }  
	    else {  
	    	  Node tmp = head;
	          while (tmp.next != current)  
	        	     tmp = tmp.next;  
	                  
	          tmp.next = current.next;  
	    }  
	    if (current.next == null)  
	    	current = head;  
	    else  
	    	current = current.next;   
	    return true;
	}//O(n)
	
}