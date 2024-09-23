package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_1912 {
	static int arr[];
	static Integer d[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		d = new Integer[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		d[0] = arr[0];
		int max = Integer.MIN_VALUE;
		
		dp(n-1);
		
		for(int i=0;i<n;i++)
			if(max < d[i])
				max = d[i];
		
		System.out.println(max);
	}
	
	static int dp(int n) {
		if(d[n] != null) return d[n];
		
		if(dp(n-1) > 0)
			d[n] = dp(n-1) + arr[n];
		else
			d[n] = arr[n];
		
		return d[n];
	}

}
