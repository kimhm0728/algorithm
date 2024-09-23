package java.greedy;

import java.io.*;

public class B_14916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int answer = n / 5;
		n %= 5;
		if(n % 2 == 1) { // 5���� �ִ�� �� �������� Ȧ����� 5�� �ϳ��� �� �ֱ�
			if(answer == 0) { // �Ž��� �� �� ���� ���
				System.out.println(-1);
				return;
			}
			answer--;
			n += 5;
		}
		answer += n / 2;

		System.out.println(answer);
	}

}
