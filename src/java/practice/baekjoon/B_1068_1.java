package java.practice.baekjoon;
import java.io.*;
import java.util.*;

public class B_1068_1 {
	static int N;
	static int[] input; // �θ� ��� �Է��� �迭
	static int[] number; // �ڽ� ��� ������ ������ �迭
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N]; 
		number = new int[N];
		int count = 0; // ���� ����� ����
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			for(int j=0;j<N;j++) 
				if(input[i] == j)
					number[j]++;
		}
		int del = Integer.parseInt(br.readLine());
		delete(del);
		for(int i=0;i<N;i++) // �ڽ� ��尡 0���� count�� ����
			if(number[i] == 0)
				count++;
		System.out.print(count);
	}
	static void delete(int d) { // ����� ������ ������ ����� ��ȣ
		number[d] = -2; 
		for(int i=0;i<N;i++) 
			if(d == input[i])  // ������ ��带 �θ�� ������ ��带 Ž��
				delete(i);
	}
}