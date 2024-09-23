package java.greedy;

import java.util.*;
import java.io.*;

public class B_2141 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] distance = new long[N][2]; // ���� ��ġ, ��� ��
		
		StringTokenizer st;
		long sum = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			distance[i][0] = Long.parseLong(st.nextToken());
			distance[i][1] = Long.parseLong(st.nextToken());
			sum += distance[i][1];
		}
		
		// ������ ��찡 �������� ��� �� ���� ��ġ�� ����ؾ� �ϹǷ�
		Arrays.sort(distance, (o1, o2) -> Long.compare(o1[0], o2[0]) == 0 ? 
				Long.compare(o2[1], o1[1]) : Long.compare(o1[0], o2[0]));

		long people = 0;
		long middle = (sum + 1) / 2; // �� ��� ���� �߰���
		for(int i=0;i<N;i++) {
			people += distance[i][1];
			if(people >= middle) { // �߰����� �Ѵ� ��쿡 ��ü���� ��ġ�ؾ� �� (���� ����� �����ִ� ���� ��ü���� ��ġ�ؾ� �ϹǷ�)
				System.out.println(distance[i][0]);
				break;
			}
		}
		
	}

}
