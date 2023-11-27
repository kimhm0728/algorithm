package baekjoon;
import java.util.Scanner;

public class B_2750 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		int []array = new int[n];
		for(int i=0;i<n;i++)
			array[i] = stdin.nextInt();
		stdin.close();
		
		int minIndex;
		int temp;

		for(int i=0;i<n;i++) {
			minIndex = i;
			for(int j=i+1;j<n;j++) 
				if(array[j] < array[minIndex]) 
					minIndex = j;
			temp = array[minIndex];
			array[minIndex] = array[i];
			array[i] = temp;

		}
		for(int a : array)
			System.out.println(a);
	}

}
