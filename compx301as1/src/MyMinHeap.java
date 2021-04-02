import java.io.IOException;
import java.util.Arrays;
public class MyMinHeap<T extends Comparable<T>> {
	
	private int maxSize;
	private int size;
	private T[] Heap;

	public MyMinHeap(int maxSize) {
		this.maxSize = maxSize;
	}
	
	public void insert(T obj) {
		if (size >= maxSize) {
			return;
		}
		@SuppressWarnings("unchecked")
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
		for(int i = 0; i < size; i++)
			reheap(i);
	}

	private void reheap(int x) {
		if(!isLeaf(x)) {
			if((Heap[x].compareTo(Heap[leftChild(x)]) > 0) || (Heap[x].compareTo(Heap[rightChild(x)]) > 0)) {
				if(Heap[leftChild(x)].compareTo(Heap[rightChild(x)]) < 0) {
					replace(x, leftChild(x));
					reheap(leftChild(x));
				}
				else {
					replace(x, rightChild(x));
					reheap(rightChild(x));
				}
			}
		}
	}
	
	private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
	
	private int leftChild(int pos) {
		if (pos == 0) {
			pos = 1;
		}
		return 2 * pos;
	}
	
	private int rightChild(int pos) {
		if (pos == 0) {
			pos = 1;
		}
		return 2 * pos + 1;
	}
	
	public void print() {
		System.out.println("");
		System.out.print("Heap:");
		for(int i = 0; i < Heap.length; i++) {
			System.out.print(Heap[i]+ ", ");
		}
	}
	
	public static void main(String[] arg) {
		Comparable[] arr = {"ba", "x","a", "x", "z", "l", "als", "alsa"};
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
