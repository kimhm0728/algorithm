package baekjoon;
import java.io.*;
import java.util.Arrays;

// 재귀로 푸는 방법
public class B_1003_1 {
	static int[][] fibo = new int[41][2];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		
		for(int i=0;i<41;i++)
			Arrays.fill(fibo[i], -1);
		// 비어있는 경우 -1 값을 가짐
		
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			fib(n);
			sb.append(fibo[n][0]+" "+fibo[n][1]+"\n");
		}
		System.out.println(sb);
	}
	static int[] fib(int n) {
		if(fibo[n][0] == -1 || fibo[n][1] == -1) {
			fibo[n][0] = fib(n-1)[0] + fib(n-2)[0];
			fibo[n][1] = fib(n-1)[1] + fib(n-2)[1];
		}
		return fibo[n];
	}
}
