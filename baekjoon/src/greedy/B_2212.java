package greedy;

import java.util.*;
import java.io.*;

public class B_2212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] sensor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			sensor[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(sensor);
		
		int[] diff = new int[N - 1];
		for(int i=0;i<N-1;i++)
			diff[i] = sensor[i + 1] - sensor[i];
		
		Arrays.sort(diff);
		int answer = 0;
		
		for(int i=0;i<N-K;i++)
			answer += diff[i];
		
		System.out.println(answer);
	}

}
