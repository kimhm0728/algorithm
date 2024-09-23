package java.practice.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_1003 {
	static int[][] fib = new int[41][2];
	public static void main(String[] args) throws IOException {
		fib[0][0] = 1; // fibo(0)�� �� 0 ȣ�� Ƚ��
		fib[0][1] = 0;
		fib[1][0] = 0;
		fib[1][1] = 1; 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int i=2;i<41;i++) {
			fib[i][0] = fib[i-1][0] + fib[i-2][0];
			fib[i][1] = fib[i-1][1] + fib[i-2][1];
		}
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(fib[n][0] + " " + fib[n][1] + "\n");
		}
		System.out.println(sb);
	}
}