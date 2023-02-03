package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2293 {
	static int N, K;
	static int[] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		coin = new int[N];
		for(int i=0;i<N;i++) 
			coin[i] = Integer.parseInt(br.readLine());

		Arrays.sort(coin);
		System.out.println(coinValue(0, K));
	}

	static int coinValue(int n, int value) {
		if(n >= N)
			return 0;
		
		int ret = 0;
		while(true) {
			if(value < 0)
				break;

			if(value == 0)
				ret++;
			else
				ret += coinValue(n + 1, value);
			
			value -= coin[n];
		}

		return ret;
	}

}
