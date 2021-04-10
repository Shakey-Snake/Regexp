/**
 * Name and ID:
 * Bhawin Mistry 1365187
 * Reece Brown 1365178
 */

import java.io.*;
import java.lang.*;
import java.util.*;

=======

public class DistributeRuns {
	
	private int posInt = 0;
	
	public DistributeRuns(int posInteger) {
		if(posInteger > 1) {
			posInteger = posInt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		//BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//String output = reader.readLine();
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\cygwin64\\home\\Bhawin\\301\\tempFile.txt"));
		bw.write(new InputStreamReader(System.in).toString());
		bw.close();
	}
}

//constructor takes a positive integer greater than 1
//It should accept standard input, which it expects will be text in the format of the output from your CreateRuns program
