package week1_1;

import java.util.*;
import java.io.*;

public class B_20115 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Integer[] weight = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			weight[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(weight, Collections.reverseOrder());
		double answer = weight[0];
		
		for(int i=1;i<N;i++)
			answer += ((double)weight[i] / 2);
		
		System.out.println(answer);
	}

}
