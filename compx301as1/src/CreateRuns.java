import java.io.*;
import java.util.Scanner;

public class CreateRuns {
	
	private static int runSize;
	private String line;
	private String[] linearr;
	private String[] arr = new String[runSize];
	private PrintStream printStream = new PrintStream(System.out);
	private int currentRun = 0;
	
	private int i = 0;
	MyMinHeap run = new MyMinHeap(runSize);
	
	public static void main(String[] arg) {
		try {
			runSize = Integer.parseInt(arg[0]);
		}
		catch(NumberFormatException n) {
			runSize = 32;
		}
		
		CreateRuns cr = new CreateRuns();
		
		cr.run();
	}
	
	private void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        while((line = br.readLine()) != null){ 
	        	linearr = line.split(" ");
	        	/*System.out.println("---------------");
	        	for (int j = 0; j < linearr.length; j++) {
	        		System.out.println(linearr[j]);
	        	}*/
	        	insertion();
	        	//splitting the arrays if the line wont fit into the current runsize.
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] temparr = arr;
		int count = 0;
        if(arr.length > 0) {
        	for (int j = 0; j < arr.length; j++) {
        		if(arr[j] == null) {
        			break;
        		}
        		count++;
        	}
        	arr = new String[count];
        	for (int j = 0; j < count; j++) {
        		arr[j] = temparr[j];
        	}
        	go();
		}
        
        printStream.close();
	}
	
	
	private void insertion(){
		if(linearr.length > runSize - i) {
    		String[] a = new String[runSize - i];
    		String[] b = new String[linearr.length - (runSize - i)];
    		
    		for (int j = 0; j < runSize - i; j++) {
    			a[j] = linearr[j];
    		}
    		
    		for (int j = 0; j < linearr.length - (runSize - i); j++) {
    			b[j] = linearr[j + runSize - i];
    		}
    		
    		for(int j = 0; j < a.length; j++){
    			arr[i] = a[j]; 
    			i++;
    		}
    		
    		linearr = b;
    		
    	}
    	else {
    		for(int j = 0; j < linearr.length; j++){
    			arr[i] = linearr[j]; 
    			i++;
    		}
    		linearr = null;
    	}
		
		if (i == runSize) {
			go();
		}
	}
	
	//outputs the array
	private void go() {
		//output array
    	run.load(arr);
    	arr = (String[]) run.copyarr();
    	for(int j = 0; j < arr.length; j++) {
    		printStream.print(arr[j]);
    	}
    	printStream.print("(R" + currentRun + ")");
    	currentRun++;
    	printStream.flush();
    	System.out.println();
    	arr = new String[runSize];
    	i = 0;
    	//check if the line arr has gone through the whole line
    	if(linearr != null) {
    		insertion();
    	}
	}
}