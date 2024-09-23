package java.practice.baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class B_1546 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();

		int []s = new int[n]; // ������ ������ ����
		double []score = new double[n]; // ������ ������ ����
		double sum = 0.0;
		double average;
		
		for(int i=0;i<n;i++)
			s[i] = stdin.nextInt();
		
		stdin.close();
		Arrays.sort(s);
		int max = s[n-1]; // �ְ� ����
		
		for(int i=0;i<n;i++) { // ���� ����
			score[i] = s[i] / (double)max * 100;
			sum += score[i];
		}
		average = sum / n;
		System.out.println(average);
	}

}
