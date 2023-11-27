package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_2193 {
	static long[][] arr;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new long[n+1][2];
		arr[1][0] = 0; // 0으로 끝나는 갯수
		arr[1][1] = 1; // 1로 끝나는 갯수
		
		System.out.println(dp(n));
	}
	
	private static long dp(int n) {
		for(int i=2;i<=n;i++) {
			arr[i][0] = arr[i-1][0] + arr[i-1][1];
			arr[i][1] = arr[i-1][0];
		}
		return arr[n][0] + arr[n][1];
	}
}
