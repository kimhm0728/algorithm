package backTracking;

import java.util.*;
import java.io.*;

public class B_16987 {
	static int N;
	static int[][] egg;
	static boolean[] visit;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		egg = new int[N][2];
		visit = new boolean[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
	}

}
