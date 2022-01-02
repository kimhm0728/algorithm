package class1;
import java.util.Scanner;

public class B_2439 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();

		for(int i=1;i<=n;i++) {
			for(int k=0;k<n-i;k++)
				System.out.print(" ");
			for(int j=0;j<i;j++) 
				System.out.print("*");
			System.out.println();
		}

		stdin.close();
	}

}