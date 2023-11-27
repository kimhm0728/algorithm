package binarySearch;

import java.io.*;

public class B_2417 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double n = Double.parseDouble(br.readLine());
		
		double lo = 0;
		double hi = n;
		
		while(lo < hi) {
			double mid = Math.floor((lo + hi) / 2);
			
			if(mid * mid >= n) 
				hi = mid;
			else
				lo = mid + 1;
		}
		
		System.out.println((long)lo);
	}

}
