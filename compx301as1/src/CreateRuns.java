
public class CreateRuns {
	private static int runSize;
	public static void main(String[] arg) {
		try {
			runSize = Integer.parseInt(arg[0]);
		}
		catch(NumberFormatException n) {
			runSize = 32;
		}
		
	}
	
	private void runs() {
		for(int i = 0; i < runSize; i++) {
			
		}
	}
}
