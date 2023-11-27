package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_11053 {
	static int[] arr;
	static int[] d;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		d = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<n;i++)
			dp(i);
		
		int max = d[0];
		
		for(int i=1;i<n;i++)
			max = Math.max(max, d[i]);
		
		System.out.println(max);
		
	}
	
	static int dp(int n) {
		if(d[n] != 0) return d[n];
		
		d[n] = 1;
		
		for(int i=n-1;i>=0;i--) 
			if(arr[i] < arr[n])
				d[n] = Math.max(d[n], dp(i) + 1);
		
		return d[n];
	}

}
