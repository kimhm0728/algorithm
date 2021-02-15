package baekjoon;
import java.util.Arrays;
import java.util.Scanner;

public class B_1546 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();

		int []s = new int[n]; // 원래의 점수를 저장
		double []score = new double[n]; // 조작한 점수를 저장
		double sum = 0.0;
		double average;
		
		for(int i=0;i<n;i++)
			s[i] = stdin.nextInt();
		
		stdin.close();
		Arrays.sort(s);
		int max = s[n-1]; // 최고 점수
		
		for(int i=0;i<n;i++) { // 점수 조작
			score[i] = s[i] / (double)max * 100;
			sum += score[i];
		}
		average = sum / n;
		System.out.println(average);
	}

}
