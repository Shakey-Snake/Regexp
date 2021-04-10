/**
 * Name and ID:
 * Bhawin Mistry 1365187
 * Reece Brown 1365178
 */

import java.io.*;
import java.lang.*;
import java.util.*;

public class DistributeRuns {
	
	private int posInt = 0;
	private int num = 1;
	
	public DistributeRuns(int posInteger) {
		if(posInteger > 1) {
			posInteger = posInt;
		}
	}
	
	public void getInput() throws IOException {
		BufferedWriter bwF1 = new BufferedWriter(new FileWriter("T" + num + ".txt"));
		BufferedWriter bwF2 = new BufferedWriter(new FileWriter("T" + (num + 1) + ".txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int count = 0;
		while((line = br.readLine()) != null){
			if(count == 0) {
				bwF1.write(line);
				bwF1.newLine();
				count++;
			}
			else {
				bwF2.write(line);
				bwF2.newLine();
				count = 0;
			}
		}
		bwF1.flush();
		bwF1.close();
		bwF2.flush();
		bwF2.close();
		//System.out.println("a");
	}
	
	public int getFileNum() {
		return num;
	}
}

//constructor takes a positive integer greater than 1
//It should accept standard input, which it expects will be text in the format of the output from your CreateRuns program
