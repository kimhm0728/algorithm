package java.dp;

import java.util.*;
import java.io.*;

public class B_22857 {
	static int N, K;
	static int[] S;
	static int[] cnt;
	static Integer[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		S = new int[N];
		cnt = new int[N];
		dp = new Integer[N][K + 1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			S[i] = Integer.parseInt(st.nextToken());
			if(S[i] % 2 == 0)
				cnt[i]++;
			
			if(i != 0)
				cnt[i] += cnt[i - 1];
		}
		
		System.out.println(twoPointer());
	}
	
	static int twoPointer() {
		int r = N - 1, e = N - 1;
		int k = S[e] % 2 == 1 ? 1 : 0;
		int max = cnt[0];
		
		while(true) {
			if(r == 0 && e == 0)
				break;
			if(k < K && r > 0) {
				r--;
				if(S[r] % 2 == 1 && k < K)
					k++;
			}
			else if(k == K && r > 0 && S[r - 1] % 2 == 0) {
				r--;
			}
			else {
				max = Math.max(max, cnt[e] - (r > 0 ? cnt[r - 1] : 0));
				if(S[e] % 2 == 1)
					k--;
				e--;
			}
		}
		
		return max;
	}

}
