package java.practice.baekjoon;
import java.util.*;

public class B_1010_1 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		for(int i=0;i<n;i++) {
			double N = stdin.nextDouble();
			double M = stdin.nextDouble();
			System.out.printf("%.0f\n", combination(M, N));
		}
		stdin.close();
	}
	public static double factorial(double a) { // a!
		double n = 1;
		for(double i=1;i<=a;i++)
			n *= i;
		return n;
	}
	public static double permutation(double a, double b) { // aPb
		double n = 1;
		double c = a - b + 1; // a���� c���� b���� ���ڸ� ����
		for(double i=a;i>=c;i--)
			n *= i;
		return n;
	}
	
	public static double combination(double a, double b) { // aCb
		return permutation(a, b) / factorial(b);
		// permutation(a, b) / permutation(b, b) �� ��ü�Ͽ� factorial �Լ� ���̵� ���� ����
	}
}