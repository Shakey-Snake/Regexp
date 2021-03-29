
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMinHeap {	
	
	private static final int FRONT = 1;
	
	public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
     String name = reader.readLine();
     System.out.println(name);       

	}
	
	
	
	public void insert() {
		
	}
	
	//Removes the element from the MinHeap and returns the minimum element
	public void remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		
		return popped;
	}
	
	public void replace() {
		
	}
	
	public void peek() {
			
		}
	
	public void load() {
		
	}
	
	public void reheap() {
		
	}
}
