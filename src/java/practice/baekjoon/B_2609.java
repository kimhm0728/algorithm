package java.practice.baekjoon;
import java.util.Scanner;

public class B_2609 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int a = stdin.nextInt();
		int b = stdin.nextInt();
		stdin.close();
		
		int max = gcd(a, b); // �ִ�����
		int min = a * b / max; // �ּҰ����
		
		System.out.println(max);
		System.out.println(min);
	}
	public static int gcd(int x, int y) {
		if(y == 0) return x;
		else return gcd(y, x % y);
	}
}
