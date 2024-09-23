package java.greedy;

import java.util.*;
import java.io.*;

public class B_21758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] honey = new int[N];

		int answer = 0;
		int first, second, middle;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum += honey[i];
		}

		first = sum - honey[0]; // ���� ���� ���� �� ���� �� (���� �������� ������ ��� ù ��° ���� ���� ������ ����)
		second = first;
		middle = sum - honey[0] - honey[N - 1]; // �߰��� ������ �����ϴ� ��� -> ��ü �տ��� �糡 ���� �߰��� ���ϱ�

		for(int i=1;i<N-1;i++) {
			// �߰��� ������ �����ϴ� ��� 
			answer = Math.max(middle + honey[i], answer);

			// ���� �������� ����
			first -= honey[i]; // i�� �� ��° ���� ���, �� ����� �� ����
			second -= honey[i];
			answer = Math.max(first + second, answer);
			first += honey[i]; // �ٽ� �ǵ����� (�� ��° ���� �������� �� ĭ�� �̵��ϸ鼭 ���� ���� �پ��Ƿ� �ǵ����� ����)
		}

		first = sum - honey[N - 1]; // ���� ������ ���� �� ���� �� (���� ������ ������ ��� ù ��° ���� ������ ������ ����)
		second = first;

		for(int i=N-2;i>0;i--) {
			// ���� ������ ����
			first -= honey[i]; // i�� �� ��° ���� ���, �� ����� �� ����
			second -= honey[i];
			answer = Math.max(first + second, answer);
			first += honey[i]; // �ٽ� �ǵ����� (�� ��° ���� �������� �� ĭ�� �̵��ϸ鼭 ���� ���� �پ��Ƿ� �ǵ����� ����)
		}

		System.out.println(answer);
	}

}
