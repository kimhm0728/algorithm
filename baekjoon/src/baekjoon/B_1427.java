package baekjoon;
import java.util.Scanner;
import java.util.Arrays;

public class B_1427 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		String n = stdin.next();
		stdin.close();
		
		int array[] = new int[n.length()];
		for(int i=0;i<n.length();i++)
			array[i]=Integer.parseInt(String.valueOf(n.charAt(i)));
		
		Arrays.sort(array); // 오름차순 정렬
		for(int i=array.length-1;i>=0;i--)
			System.out.print(array[i]);
	}
}
