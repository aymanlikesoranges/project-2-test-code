package linkedlist;
import java.util.Iterator;

import linkedlist.LinkedList.LinkedListIterator;

import java.util.Comparator;
public class LinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;
    private Node<T> curr;

    public boolean append(T item){
        Node<T> temp = new Node<T>(item);
        if(head == null){
            head = temp;
            tail = temp;
        }

        tail.setNext(temp);
        temp.setPrev(tail);
        tail = temp;
        return true;
    }

    public T remove(int index) {
        if (index < 0 || index >= size()) {
            return null;
        }

        Node<T> curr = head;
        Node<T> temp = null;

        if (index == 0) {
            temp = head;
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            } else {
                tail = null;
            }
        } else {
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }

            temp = curr.getNext();
            curr.setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrev(curr);
            } else {
                tail = curr; 
            }
        }

        return temp.getData();
    }

    public int size(){
        Node<T> curr = head;
        int size = 0;
        
    while(curr != null){
        size++;
        curr = curr.getNext();

    }

        return size;
    }

    public void sort(){
        
    }

    public T getFirst(){
        return head.getData();
    }

    protected Node<T> getRoot(){
        return head;
    }

    public void swap(Node<T> n1, Node<T> n2) {
    if (n1 == n2) {
        return; // No need to swap same nodes
    }

    // Check if n1 is adjacent to n2
    if (n1.next == n2) {
        Node<T> temp = n1.prev;
        n1.prev = n2;
        n1.next = n2.next;
        n2.prev = temp;
        n2.next = n1;
        
        if (temp != null) {
            temp.next = n1;
        }
        
        if (n1.next != null) {
            n1.next.prev = n1;
        }
        return;
    }

    // Check if n2 is adjacent to n1
    if (n2.next == n1) {
        Node<T> temp = n2.prev;
        n2.prev = n1.prev;
        n2.next = n1;
        n1.prev = temp;
        n1.next = n2.next;
        
        if (temp != null) {
            temp.next = n2;
        }
        
        if (n2.next != null) {
            n2.next.prev = n2;
        }
        return;
    }

    Node<T> temp1 = n1.prev;
    Node<T> temp2 = n1.next;
    Node<T> temp3 = n2.prev;
    Node<T> temp4 = n2.next;

    // Update n1 links
    n1.prev = temp3;
    n1.next = temp4;

    // Update n2 links
    n2.prev = temp1;
    n2.next = temp2;

    // Update links of nodes adjacent to n1
    if (temp1 != null) {
        temp1.next = n2;
    }

    if (temp2 != null) {
        temp2.prev = n2;
    }

    // Update links of nodes adjacent to n2
    if (temp3 != null) {
        temp3.next = n1;
    }

    if (temp4 != null) {
        temp4.prev = n1;
    }
}

public void sort(Comparator<T> c) {
    Node<T> curr;
    Boolean swapped;

    do {
        swapped = false;
        curr = head;

        while (curr != null && curr.getNext() != null) {
            Node<T> next = curr.getNext();

            // Use the comparator to compare the data of the nodes
            int comparisonResult = c.compare(curr.getData(), next.getData());

            if (comparisonResult > 0) {
                swap(curr, next);
                swapped = true;

                // Update prev pointer correctly after swap
                if (curr.getPrev() != null) {
                    curr = curr.getPrev(); // Move back one step after a swap
                } else {
                    head = curr; // If curr is now the head, update head reference
                }
            }

            curr = next;
        }
    } while (swapped);
}




    protected class Node<T>{

    private T data;
    private Node<T> next;
    private Node<T> prev;
    
	
    public Node(T item)
    {
        this.data = item;
        next = null;
        prev = null;
    }

    public void setNext(Node<T> n){

    }

    public void setPrev(Node<T> n) {
        
    }

    public T getData(){
        return data;
    }
    
    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrev(){
        return prev;
    }

    }


    protected class LinkedListIterator implements Iterator<T> { 
        public boolean hasNext(){
            if(tail == null){
                return curr != null && curr.getNext() != null;
            }
            else {
                return curr != tail;
            }
        }

        public T next() {

            Node<T> value = curr;
            if (curr == null || curr.getNext() == null) {
                return null;
            }
            Node<T> temp = curr.getNext();
            if (curr.getPrev() != null) {
                curr.getPrev().setNext(temp);
            }
            temp.setPrev(curr.getPrev());
            curr = temp;
            return value.getData();
        }

        private LinkedList<T> list;
        private Node<T> curr;

        public LinkedListIterator(LinkedList<T> list){ 
            this.list = list;
            this.curr = list.getRoot();
        } 
    
    } 


    /**
     *(iterator is necessary since LinkedList<T> is implementing Iterable)
     *@return LinkedListIterator object based on the current status of the list
     */
    public Iterator<T> iterator(){ 
        return new LinkedListIterator(this); 
    } 

    /**
     * Default constructor. root should be null to begin.
     */
    public LinkedList(){
	this.head = null;
    }

    /**
     * Shallow copy constructor
     * @param l LinkedList to be copied
     *
     */
    public LinkedList(LinkedList<T> l){
	Node<T> curr = l.getRoot();
        while(curr != null){
	    append(curr.getData());
	    curr = curr.getNext();
	}
    }
}
