
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
    
public void insert() {
		while (Heap[curPos] < Heap[parent(curPos)]) {
			replace(curPos, parent(curPos));
			curPos = parent(curPos);
		}
	}
	
	//Removes the element from the MinHeap and returns the minimum element
	public void remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		return popped;
	}
	
	public void replace(int pos1, int pos2) {
		int temp = Heap[pos1];
		Heap[pos1] = Heap[pos2];
		Heap[pos2] = temp;
	}
	
	public void peek() {
			
	}
	
	public void load() {
		
	}
	
	public void reheap(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				if (Heap[pos] > Heap[leftChild(pos)]) {
					
				}
				else {
					
				}
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
}
