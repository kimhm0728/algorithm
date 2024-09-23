package java.practice.baekjoon;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_11652 {
	public static void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];
		for(int i=0;i<N;i++)
			num[i] = Long.parseLong(br.readLine());
		Arrays.sort(num);
		
		int count = 1; // for���� ���� �� ������ Ƚ���� ����
		int countMax = 1; // ���� ���� ������ �ִ� ������ ����Ƚ��
		int indexMax = 0; // ���� ���� ������ �ִ� ������ �ε���
		for(int i=1;i<N;i++) {
			if(num[i-1] == num[i]) 
				count++;
			else 
				count = 1;
			if(countMax < count) { 
				// ���� ������ count�� countMax���� ũ�� countMax�� count�� ����
				indexMax = i;
				countMax = count; 
			}
			//else if(countMax == count)
			// ������������ ���������Ƿ� ���� ���ں��� ���� ���ڰ� �� ŭ. �� index �� ���� x
		}
		System.out.println(num[indexMax]);
	}
}