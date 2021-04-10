import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Name and ID:
 * Bhawin Mistry 1365187
 * Reece Brown 1365178
 */

public class MergeRuns {
	
	private String[] a;
	private String[] b;
	private String popped = null;
	private String[] c = new String[0];
	private int fileNum = 1;
	private int oldFileNum = fileNum;
	DistributeRuns ds;
	BufferedWriter bwF1; 
	BufferedWriter bwF2;
	BufferedReader br1;
	BufferedReader br2;
	int count = 1;
	int alt = 1;
	
	
	public static void main(String[] arg) throws IOException {
		MergeRuns mr = new MergeRuns();
		mr.readFile();
	}
	
	public void readFile() throws IOException {
		ds = new DistributeRuns(2);
		ds.getInput();
		while(true) {
			File file1 = new File("T" + oldFileNum + ".txt");
			boolean exists1 = file1.exists();
			File file2 = new File("T" + (oldFileNum + 1) + ".txt");
			boolean exists2 = file2.exists();
			if(!exists1 && !exists2) {
				break;
			}
			br1 = new BufferedReader(new FileReader("T" + oldFileNum + ".txt"));
			br2 = new BufferedReader(new FileReader("T" + (oldFileNum + 1) + ".txt"));
			String line1 = "";
			String line2 = "";
			while(true) {
				line1 = br1.readLine();
				line2 = br2.readLine();
				
				if(line1 == null || line2 == null) {
					break;
				}
				
				a = line1.split(" ");
				b = line2.split(" ");
				compareArr();
			}
		}
		
	}
	
	public void compareArr() {
		String[] temp;
		if(a.length == b.length) {
			while(a.length >= 0 || b.length >= 0) {
				if(b.length <= 0 || a.length <= 0) {
					break;
				}
				System.out.println(a.length + " " + b.length);
				if(a[0].compareTo(b[0]) < 0) {
					popped = a[0];
					temp = a;
					a = new String[temp.length-1];
					for(int j = 0; j < a.length; j++) {
						a[j] = temp[j + 1];
					}
				}
				else {
					popped = b[0];
					temp = b;
					b = new String[temp.length-1];
					for(int j = 0; j < b.length; j++) {
						b[j] = temp[j + 1];
					}
				}
				insert(popped);
			}
			if(a.length > 0 && b.length <= 0){
				insert(a);
			}
			else if(b.length > 0 && a.length <= 0){
				insert(b);
			}
			try {
				createFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insert(String x) {
		String[] temp = c;
		c = new String [temp.length + 1];
		for(int i = 0; i < temp.length; i++) {
			c[i] = temp[i];
		}
		c[c.length - 1] = x;
		System.out.println("--------");
		for(int j = 0; j < c.length; j++) {
			System.out.println(c[j]);
    	}
		
	}
	
	public void insert(String[] x) {
		String[] temp = c;
		
		int lastpos = 0;
		c = new String [temp.length + x.length];
		for(int i = 0; i < temp.length; i++) {
			c[i] = temp[i];
			lastpos++;
		}

		System.out.print(lastpos);
		for(int i = 0; i < x.length; i++) {
			c[lastpos + i] = x[i];
		}
	}
	
	public void createFile() throws IOException {
		if (count == 1) {
			fileNum++;
			bwF1 = new BufferedWriter(new FileWriter("T" + fileNum + ".txt"));
		}
		else if (count == 2) {
			bwF2 = new BufferedWriter(new FileWriter("T" + (fileNum + 1) + ".txt"));
		}
		if (alt == 1) {
			alt++;
			for(int i = 0; i < c.length; i++)
				bwF1.write(c[i]);
		}
		else {
			alt = 1;
			for(int i = 0; i < c.length; i++) {
				System.out.println(i);
				bwF2.write(c[i]);
			}
		}
		
		if(bwF2 == null) {
			bwF1.flush();
			bwF1.close();
		}
		else {
			oldFileNum = fileNum;
			fileNum =+ 2;
			bwF1.flush();
			bwF1.close();
			bwF2.flush();
			bwF2.close();
		}
		
		
		
		
	}
	//create files, each run will have a name.
	//the first run from each file will be taken out of the file and separated into arrays.
	//the first elements from each will be compared to each other. Smallest value gets taken.
	//Then goes down one on the taken array and compares the two.
}
