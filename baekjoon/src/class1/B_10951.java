package class1;
import java.util.Scanner;

public class B_10951 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		while(stdin.hasNextInt()) {
			int a = stdin.nextInt();
			int b = stdin.nextInt();
			System.out.println(a+b);
		}
		stdin.close();
	}

}
