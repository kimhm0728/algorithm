package baekjoon;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class B_1915 {
	static int[][] square;
	static int[][] dp;
	static int n, m;
	static int r = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		square = new int[n][m];
		dp = new int[n][m];
		
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			for(int j=0;j<m;j++) {
				square[i][j] = s.charAt(j) - '0';
				if(square[i][j] == 1) {
					dp[i][j] = 1;
					r = 1;
				} 
			}
		}
		
		isSquare();
		System.out.println(r * r);
	}
	static void isSquare() {
		for(int i=1;i<n;i++)
			for(int j=1;j<m;j++) {
				if(square[i][j] == 1)
					dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
				if(r < dp[i][j]) r = dp[i][j]; // 한 변의 최대값 찾기
			}
	}
}
