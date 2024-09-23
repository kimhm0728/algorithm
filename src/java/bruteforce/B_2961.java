package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_2961 {
	static int N;
	static long[][] taste;
	static long answer = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
	
		taste = new long[N][2];
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			taste[i][0] = Long.parseLong(st.nextToken());
			taste[i][1] = Long.parseLong(st.nextToken());
		}
		
		DFS(0, 1, 0);
		System.out.println(answer);
	}
	
	static void DFS(int start, long sour, long bitter) {
		if(start != 0)
			answer = Math.min(answer, Math.abs(sour - bitter));
	
		for(int i=start;i<N;i++) {
			DFS(i + 1, sour * taste[i][0], bitter + taste[i][1]);
		}
	}

}
