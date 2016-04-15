import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("GIT");
//		while(scanner.hasNext()) {
//			String s = scanner.next();
//			System.out.println(s);
//		}
		boolean b = false;
		while(!b){
			 try {
			        String key = System.in.read()+"";
			        // read a character and process it 
			        System.out.println("key pressed");
			        b = true;
			    } catch (java.io.IOException ioex) {
			        System.out.println("IO Exception");
			    }
		}
	}

}
