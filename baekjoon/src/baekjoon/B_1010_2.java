package baekjoon;
import java.io.*;
import java.util.*;

public class B_1010_2 {
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sb.append(combi(M, N)).append("\n");
		}
		System.out.println(sb);
	}
	static int combi(int a, int b) { // aCb
		if(dp[a][b] > 0) // 값이 이미 계산된 경우 그 값을 반환
			return dp[a][b]; 
		
		if (a == b || b == 0)
			return dp[a][b] = 1;
		
		return dp[a][b] = combi(a - 1, b - 1) + combi(a - 1, b);
		// 조합의 성질을 이용하지 않고 팩토리얼로 풀면 값의 범위가 너무 커 BigInteger 클래스나 double 자료형을 사용해야 함.
	} 
} 