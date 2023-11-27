package bruteForce;

import java.util.*;
import java.io.*;

public class B_18312 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for(int h=0;h<=N;h++) {
			for(int m=0;m<=59;m++) 
				for(int s=0;s<=59;s++) 
					if(check(h, m, s, K))
						answer++;
		}
		
		System.out.println(answer);
	}
	
	static boolean check(int h, int m, int s, int K) {
		if(h / 10 == K || h % 10 == K || m / 10 == K || m % 10 == K || s / 10 == K || s % 10 == K)
			return true;
		
		return false;
	}

}
