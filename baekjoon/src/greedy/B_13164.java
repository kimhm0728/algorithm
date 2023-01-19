package greedy;

import java.util.*;
import java.io.*;

public class B_13164 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] h = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			h[i] = Integer.parseInt(st.nextToken());
		
		int[] diff = new int[N - 1];
		for(int i=0;i<N-1;i++)
			diff[i] = h[i + 1] - h[i];
		Arrays.sort(diff);
		
		int answer = 0;
		for(int i=0;i<N-K;i++)
			answer += diff[i];
		
		System.out.println(answer);
	}

}
