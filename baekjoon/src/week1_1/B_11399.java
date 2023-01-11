package week1_1;

import java.util.*;
import java.io.*;

public class B_11399 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] time = new int[N];
		for(int i=0;i<N;i++)
			time[i] = Integer.parseInt(st.nextToken());
	
		Arrays.sort(time);
		
		int answer = time[0];
		
		for(int i=1;i<N;i++) {
			time[i] += time[i - 1];
			answer += time[i];
		}
		
		System.out.println(answer);
	}

}