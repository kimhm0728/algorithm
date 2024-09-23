package java.practice.baekjoon;
import java.util.Scanner;

public class B_1110 {
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		int n = stdin.nextInt();
		stdin.close();
		
		int left, right; // ���� �ڸ� ���� ������ �ڸ� ��
		int sum; // �� �ڸ��� ���� ���� �ʵ�
		int new_n = n; // ���ο� ��
		int length = 0; // ����Ŭ�� ����
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
