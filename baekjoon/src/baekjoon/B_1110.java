package baekjoon;
import java.util.Scanner;

public class B_1110 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		stdin.close();
		
		int left, right; // 왼쪽 자리 수와 오른쪽 자리 수
		int sum; // 각 자리의 수를 더할 필드
		int new_n = n; // 이어 붙여 만든 새로운 수
		int length = 0; // 사이클의 길이
		while (true) {
			left = new_n / 10;
			right = new_n % 10;
			sum = left + right;
			new_n = right*10 + sum%10;
			length++;
			if(new_n == n)
				break;
		}
		System.out.println(length);
	}

}
