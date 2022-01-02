package class1;
import java.util.Scanner;

public class B_2577 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		int c = stdin.nextInt();
		String result = Integer.toString(a * b * c);
		
		int cnt[] = new int[10];
		for(int i=0;i<result.length();i++) 
			cnt[Character.getNumericValue(result.charAt(i))]++;
		
		for(int i=0;i<cnt.length;i++)
			System.out.println(cnt[i]);
		stdin.close();
	}

}
