package class2;
import java.util.Scanner;

public class B_1436 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		stdin.close();
		
		int num = 665;
		while(n!=0) {
			num++;
			if(String.valueOf(num).contains("666"))
				n--;
		}
		System.out.println(num);
	}
}
