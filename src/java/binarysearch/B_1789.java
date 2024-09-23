package java.binarysearch;

import java.io.*;

public class B_1789 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine());
		
		long lo = 0;
		long hi = S;
        
		while(lo < hi) {
			long mid = (lo + hi) / 2;
			if((mid * (mid + 1)) / 2 <= S)
				lo = mid + 1;
			else
				hi = mid;
		}
		
		System.out.println(lo - 1);
	}

}
