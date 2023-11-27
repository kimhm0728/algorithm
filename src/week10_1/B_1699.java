package week10_1;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1699 {
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		
		System.out.println(dp(n));
	}
	
	static int dp(int n) {
		if(arr[n] != 0) return arr[n];
		if(n == 1) return 1;
		
		double sqrtD = Math.sqrt(n);
		int sqrtI = (int)sqrtD;
		
		if(sqrtD - sqrtI == 0.0)
			return arr[n] = 1;
		else {
			arr[n] = Integer.MAX_VALUE;
			for(int i=sqrtI;i>=1;i--) {
				int tmp = dp(n - (int)Math.pow(i, 2)) + 1;
				if(tmp < arr[n])
					arr[n] = tmp;
			}
			return arr[n];
		}
	}

}
