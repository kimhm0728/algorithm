package class1;
import java.util.Scanner;

public class B_1330 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		
		if(a > b)
			System.out.println(">");
		else if(a < b)
			System.out.println("<");
		else
			System.out.println("==");
		
		stdin.close();
	}

}
