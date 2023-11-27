package week10_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_14852 {
	static long[][] arr = new long[1000001][2];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr[0][0] = 1;
		arr[1][0] = 2;
		arr[2][0] = 7;
		arr[2][1] = 0;
		System.out.println(dp(n));
	}
	static long dp(int n) {
		for(int i=3;i<=n;i++) {
			arr[i][1] = (arr[i-3][0] + arr[i-1][1]) % 1000000007;
			arr[i][0] = (2 * arr[i-1][0] + 3 * arr[i-2][0] + 2 * arr[i][1]) % 1000000007;
		}
		return arr[n][0];
	}

}
