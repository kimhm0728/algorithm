package java.practice.baekjoon;
import java.io.*;
import java.util.StringTokenizer;

public class B_1929 {
	static int[] prime;
	// �迭 ���� 0�̸� �Ҽ�
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		get_prime(end);
		for(int i=start;i<=end;i++) {
			if(prime[i] == 0) {
				sb.append(i);
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
	static void get_prime(int a) { // �����佺�׳׽��� ü
		prime = new int[a+1];
		
		prime[0] = prime[1] = 1;
		for(int i=2;i<=Math.sqrt(a);i++) {
			if(prime[i] == 1) // �̹� üũ�� ���̸� �Ѿ
				continue;
			for(int j=i*i;j<=a;j+=i) // i�� ����� ���ܽ�Ŵ
				prime[j] = 1;
			// j�� i*2�� �ƴ� i*i�� �����ϴ� ����. ������ i�� 2�� �� i*i�� 4�̰�, 
			// 2�� ����� ���ܽ�Ű�� �������� i*2(2�� ���)�� ��� üũ�Ǳ� ������. i*i�� �ϴ°� �ð����⵵ �� ����.
		}
	}
}
