import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] a;
   	private int N;


   public RandomizedQueue() {
   	a = (Item[]) new Object[2];
   	N = 0;

   }                
   // construct an empty randomized queue
   public boolean isEmpty() {
   	return N==0;
   }                // is the queue empty?
   public int size()  {
   	return N;
   }                      // return the number of items on the queue

       // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

   public void enqueue(Item item)  {
   		if (N == a.length) resize(2*a.length);    // double size of array if necessary
        a[N++] = item;                            // add item
   }         // add the item
   public Item dequeue()  {
   		int removeIndex = StdRandom.uniform(N);
   		Item item = a[removeIndex];
   		a[removeIndex] = a[N-1];
   		N--;
   		return item;
   }                  // delete and return a random item
   public Item sample()   {
   		int removeIndex = StdRandom.uniform(N);
   		Item item = a[removeIndex];
   		return item;
   }                  // return (but do not delete) a random item
   
   public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class RandomArrayIterator implements Iterator<Item> {
        private int i = StdRandom.uniform(N);

        public boolean hasNext() {
            return N > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = a[i];
            i = StdRandom.uniform(N);
            return item;
        }
    }


   public static void main(String[] args)	{
   		RandomizedQueue<String> test = new RandomizedQueue<String>();
   		
        int subsetSize = StdIn.readInt();

   		while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            test.enqueue(item);
        }

       	for (int i = 1; i <= subsetSize; i++){
       		StdOut.println(test.dequeue());
       	}


   }   // unit testing
}