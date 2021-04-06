import java.io.*;
import java.util.Scanner;

public class CreateRuns {
	
	private static int runSize;
	private String line;
	private String[] linearr;
	private String[] arr = new String[runSize];
	private PrintStream printStream = new PrintStream(System.out);
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
	        	System.out.println("---------------");
	        	for (int j = 0; j < linearr.length; j++) {
	        		System.out.println(linearr[j]);
	        	}
	        	
	        	insertion();
	        	System.out.println("fin");
	        	//splitting the arrays if the line wont fit into the current runsize.
	        }
	        printStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//not quite done, still need to check if there are still words remaining.
	}
	
	private void insertion(){
		if(linearr.length > runSize - i) {
    		System.out.println("split");
    		System.out.println(linearr.length + " " + (runSize - i));
    		String[] a = new String[runSize - i];
    		String[] b = new String[linearr.length - (runSize - i)];
    		
    		for (int j = 0; j < runSize - i; j++) {
    			a[j] = linearr[j];
    		}
    		
    		for (int j = 0; j < linearr.length - (runSize - i); j++) {
    			b[j] = linearr[j + runSize - i];
    		}
    		
    		//System.out.println(runSize + " " + " " + i + " " + (runSize - i));
    		//System.out.println("b values");
    		
    		for(int j = 0; j < a.length; j++){
    			arr[i] = a[j]; 
    			i++;
    		}
    		
    		linearr = b;
    		
    	}
    	else {
    		System.out.println("normal");
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
	
	private void go() {
		//output array
    	System.out.println("send:");
    	run.load(arr);
    	arr = (String[]) run.copyarr();
    	
    	for(int j = 0; j < arr.length; j++) {
    		printStream.print(arr[j]);
    	}
    	
    	printStream.flush();
    	arr = new String[runSize];
    	i = 0;
    	//check if the line arr has gone through the whole line
    	if(linearr != null) {
    		System.out.println("ins");
    		insertion();
    	}else {
    		System.out.println("no ins");
    	}
	}
	
	
	//check line isnt empty, if it is, go to next line.
	//if run size is too big, output it and create another heap.
}
