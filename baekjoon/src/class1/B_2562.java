package class1;
import java.util.Scanner;

public class B_2562 {
	public static void main(String[] args) {
		int []num = new int[10];
		num[0] = 0;
		
		Scanner stdin = new Scanner(System.in);
		int maxIndex = 0;
		
		for(int i=1;i<num.length;i++) {
			num[i] = stdin.nextInt();
			if(num[maxIndex] < num[i])
				maxIndex = i;
		}
		
		System.out.println(num[maxIndex]);
		System.out.println(maxIndex);
		
		stdin.close();
	}

}
