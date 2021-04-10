
public class MergeRuns {
	
	private String[] a;
	private String[] b;
	private String popped = null;
	private String[] c;
	
	public static void main(String[] arg) {
		DistributeRuns ds = new DistributeRuns();
		
	}
	
	public void compareArr() {
		String[] temp;
		int i = 0;
		if(a.length == b.length) {
			while(a.length > 0 || b.length > 0) {
				if(a[i].compareTo(b[i]) < 0) {
					popped = a[i];
					temp = a;
					a = new String[temp.length-1];
					for(int j = 0; j < a.length; j++) {
						a[j] = temp[j + 1];
					}
				}
				else {
					popped = b[i];
					temp = b;
					b = new String[temp.length-1];
					for(int j = 0; j < b.length; j++) {
						b[j] = temp[j + 1];
					}
				}
				insert(popped);
				i++;
			}
			if(a.length > 0 && b.length <= 0){
				insert(a);
			}
			else if(b.length > 0 && a.length <= 0){
				insert(b);
			}
		}
	}
	
	public void insert(String x) {
		
	}
	
	public void insert(String[] x) {
			
	}
	//create files, each run will have a name.
	//the first run from each file will be taken out of the file and separated into arrays.
	//the first elements from each will be compared to each other. Smallest value gets taken.
	//Then goes down one on the taken array and compares the two.
}
