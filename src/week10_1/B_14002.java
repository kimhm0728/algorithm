package week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_14002 {
	static int[] arr;
	static int[] d;
	static String[] str
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		arr = new int[n];
		d = new int[n];
		str = new String[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		str[0] = String.valueOf(arr[0]);
		
		for(int i=0;i<n;i++)
			dp(i);
		
		int max = 0;
		
		for(int i=1;i<n;i++)
			if(d[max] < d[i])
				max = i;
	
		System.out.println(d[max] + "\n" + str[max]);
		
	}
	
	static int dp(int n) {
		if(d[n] != 0) return d[n];

		boolean flag = false;
		d[n] = 1;

		for(int i=n-1;i>=0;i--) 
			if(arr[i] < arr[n]) {
				flag = true;
				int tmp = dp(i);
				if(d[n] < tmp + 1) {
					str[n] = str[i] + " " + arr[n];
					d[n] = tmp + 1;
				}
			}
		
		if(flag == false)
			str[n] = String.valueOf(arr[n]);
		
		return d[n];
	}

}
