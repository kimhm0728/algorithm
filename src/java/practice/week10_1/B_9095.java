package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_9095 {
	static int[] d = new int[11];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) 
			sb.append(dp(Integer.parseInt(br.readLine()))).append('\n');
			
		System.out.print(sb);
	}
	
	static int dp(int n) {
		if(n == 1) return 1;
		if(n == 2) return 2;
		if(n == 3) return 4;
		if(d[n] != 0) return d[n];
		
		return d[n] = dp(n - 3) + dp(n - 2) + dp(n - 1);
	}

}
