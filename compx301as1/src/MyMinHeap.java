
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
		
		while (Heap[curPos] < Heap(parent(curPos)) {
			
		}
	}
	
	public void remove() {
		
	}
	
	public void replace() {
		
	}
	
	public void peek() {
			
		}
	
	public void load() {
		
	}
	
	public void reheap() {
		
	}
	
	private int parent(int pos) {
		
	}
}
