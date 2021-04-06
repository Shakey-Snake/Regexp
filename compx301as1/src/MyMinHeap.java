import java.io.IOException;
import java.util.Arrays;
public class MyMinHeap<T extends Comparable<T>> {
	
	private int maxSize;
	private int size;
	private T[] Heap;
	private int arrHalf;
	
	public MyMinHeap(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void insert(T obj) {
		if (size >= maxSize) {
			return;
		}
		T[] newHeap = (T[]) new Comparable[size + 1];
		for (int i = 0; i < Heap.length; i++) {
			newHeap[i] = Heap[i];
		}
		newHeap[++size-1] = obj;
		Heap = newHeap;
		reheap();
	}
	
	//Removes the element from the MinHeap and returns the minimum element
	public T remove() {
		T popped = Heap[0];
		Heap[0] = Heap[size--];
		reheap();
		return popped;
	}
	
	public void replace(int pos1, int pos2) {
		T temp = Heap[pos1];
		Heap[pos1] = Heap[pos2];
		Heap[pos2] = temp;
		
		System.out.println(Heap[pos1] + " and "+ Heap[pos2]);
	}
	
	public void peek() {
			
	}
	
	//add to current stack and then 
	public void load(Comparable[] arr) {
		if (arr.length > maxSize) {
			System.out.println("too large");
		}
		else {
			Heap = (T[]) arr;
			size = Heap.length;
		}
		this.print();
		reheap();
	}
	
	public void reheap() {
		for (int i = (size/2); i >= 0; i--) { 
			reheap(i); 
		} 
	}

	private void reheap(int s) {
		int smallest = s;
		
		if (leftChild(s) < size && (Heap[leftChild(s)].compareTo(Heap[smallest]) < 0))
            smallest = leftChild(s);
		
		if (rightChild(s) < size && (Heap[rightChild(s)].compareTo(Heap[smallest]) < 0))
            smallest = rightChild(s);
		
		if (smallest != s) {
			replace(s, smallest);
            reheap(smallest);
		}
	}
	
	private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
	
	private int leftChild(int pos) {
		return 2 * pos + 1;
	}
	
	private int rightChild(int pos) {
		return 2 * pos + 2;
	}
	
	public void print() {
		System.out.println("");
		System.out.print("Heap:");
		for(int i = 0; i < Heap.length; i++) {
			System.out.print(Heap[i]+ ", ");
		}
	}
	
	public static void main(String[] arg) {
		Comparable[] arr = {"ba","a", "x", "z", "alss", "als", "l"};
		MyMinHeap minHeap = new MyMinHeap(20);
		minHeap.load(arr);
		//minHeap.insert("2");
		//minHeap.insert("23");
		//minHeap.insert("96");
		//minHeap.insert("4");
		//minHeap.print();
		//minHeap.reheap();
		minHeap.print();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
