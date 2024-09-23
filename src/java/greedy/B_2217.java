package java.greedy;

import java.util.*;
import java.io.*;

public class B_2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] weight = new int[N];
		
		for(int i=0;i<N;i++) 
			weight[i] = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int cnt = N;
		Arrays.sort(weight);
		
		// ��ƿ �� �ִ� �߷��� ���� ���� ������ ����� ���
		// N���� ������ �� ������ ���Ը�ŭ ���ø� �� �ִ�.
		// �� ��°�� ���� ������ ����� ��� (N-1)�� (���� ���� ���� �����ϹǷ�)
		for(int i=0;i<N;i++) 
			answer = Math.max(answer, weight[i] * cnt--);
		
		System.out.println(answer);
	}

}
