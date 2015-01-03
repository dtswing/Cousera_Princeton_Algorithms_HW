import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	private Node first;
	private Node last;
	private int N;

	private class Node{
		Item item;
		Node next;
		Node prev;
	}

   public Deque() {
   		first = null;
   		last = null;
   		N = 0;
   }                          // construct an empty deque
   
   public boolean isEmpty() {
   		if (N == 0) return true;
   		return false;
   }                // is the deque empty?

   public int size()  {
   		return N;
   }                      // return the number of items on the deque
   
   public void addFirst(Item item)  {
   		Node oldFirst = first;
   		first = new Node();
   		first.item = item;
   		first.next = oldFirst;
   		first.prev = null;
   		if (isEmpty()) last = first;
   		else oldFirst.prev = first;
   		N++;
   }        // insert the item at the front

   public void addLast(Item item)  {
   		Node oldLast = last;
   		last = new Node();
   		last.item = item;
   		last.next = null;
   		last.prev = oldLast;
   		if (isEmpty()) first = last;
   		else oldLast.next = last;
   		N++;
   }         // insert the item at the end

   public Item removeFirst()  {
   		Item item = first.item;
   		first = first.next;
   		N--;
   		if (isEmpty()) last = null;
   		else first.prev = null;
   		return item;
   }              // delete and return the item at the front
   
   public Item removeLast()  {
   		Item item = last.item;
   		last = last.prev;
   		N--;
   		if (isEmpty()) first = null;
   		else last.next = null;
   		return item;
   }               // delete and return the item at the end

   public Iterator<Item> iterator() {
   		return new ListIterator();
   }        

   private class ListIterator implements Iterator<Item>{
   	private Node current = first;

   	public boolean hasNext(){
   		return current != null;
   	}

   	public void remove(){ }

   	public Item next(){
   		Item item = current.item;
   		current = current.next;
   		return item;
   	}
   }
    // return an iterator over items in order from front to end
   
   public static void main(String[] args) {
		Deque<String> q = new Deque<String>();
   	 
   	 	while (!StdIn.isEmpty()) {
   	 		String item = StdIn.readString();
   	 		q.addLast(item);
   	 	}

   	 	while (q.N>0)
   	 	StdOut.println(q.removeFirst());

    }
  // unit testing
}

