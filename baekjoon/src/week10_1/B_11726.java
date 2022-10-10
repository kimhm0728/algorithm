package week10_1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_11726 {
	static int[] arr = new int[1001];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(dp(n));
	}
	static int dp(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(arr[n] != 0) return arr[n];
		return arr[n] = (dp(n-1) + dp(n-2)) % 10007;
	}
}
