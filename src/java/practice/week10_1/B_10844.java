package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_10844 {
	static long[][] arr;
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		arr = new long[n+1][10];
		
		for(int i=1;i<=9;i++)
			arr[1][i] = 1;
		
		System.out.println(dp(n));
	}
	
	private static long dp(int n) {
		long ans = 0;
		for(int i=2;i<=n;i++) {
			for(int j=0;j<=9;j++) {
				if(j == 0)
					arr[i][0] = arr[i-1][1] % mod;
				else if(j == 9)
					arr[i][9] = arr[i-1][8] % mod;
				else
					arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % mod;
			}
		}
		for(int i=0;i<=9;i++) 
			ans += arr[n][i];
		
		return ans % mod;
	}
}
