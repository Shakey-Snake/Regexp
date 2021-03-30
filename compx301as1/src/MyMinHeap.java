
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;


public class MyMinHeap {
	
	private int maxSize;
	private int size;
	private int[] Heap;

	public MyMinHeap(int maxSize) {
		this.maxSize = maxSize;
		size = 0;
		Heap = new int[this.maxSize + 1];
	}
	
	public void insert(int num) {
		if (size >= maxSize) {
			return;
		}
		Heap[++size] = num;
		int curPos = size;
    
		while (Heap[curPos] < Heap[parent(curPos)]) {
			replace(curPos, parent(curPos));
			curPos = parent(curPos);
		}
	}
	
	//Removes the element from the MinHeap and returns the minimum element
	public int remove() {
		int popped = Heap[0];
		Heap[0] = Heap[size--];
		return popped;
	}
	
	public void replace(int pos1, int pos2) {
		int temp = Heap[pos1];
		Heap[pos1] = Heap[pos2];
		Heap[pos2] = temp;
	}
	
	public void peek() {
			
	}
	
	//add to current stack and then reheap
	public void load(int[] impHeap) {
		if (impHeap.length > maxSize) {
			System.out.println("too large");
		}
		else {
			Heap = impHeap;
			size = Heap.length-1;
		}
		this.print();
		reheap(0);
	}
	
	//start from the beginning of the stack and go to end of stack 
	public void reheap(int pos) {
		if(!isLeaf(pos)) {
			if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
				replace(leftChild(pos), pos);
				reheap(leftChild(pos));
			}
			else {
				replace(rightChild(pos), pos);
				reheap(rightChild(pos));
			}
		}
	}
	
	private int parent(int pos) {
		return pos / 2;
	}
	
	private int leftChild(int pos) {
		return pos * 2;
	}
	
	private int rightChild(int pos) {
		return (pos * 2) + 1;
	}
	
	private boolean isLeaf(int pos)
    {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
	
	public void print() {
		System.out.println("");
		System.out.print("Heap:");
		for(int i = 0; i < Heap.length; i++) {
			System.out.print(Heap[i]+ ", ");
		}
	}
	
	public static void main(String[] arg) {
		int[] arr = {10,3,17,12,16,14,1,0};
		MyMinHeap minHeap = new MyMinHeap(10);
		minHeap.load(arr);
		minHeap.print();
		try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
