package week1_2;

import java.util.*;
import java.io.*;

public class B_2015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		st = new StringTokenizer(br.readLine());
		arr[0] = Long.parseLong(st.nextToken());
		
		for(int i=1;i<N;i++) 
			arr[i] = arr[i - 1] + Long.parseLong(st.nextToken());
		
		HashMap<Long, Long> map = new HashMap<>();
		long answer = 0;
		
		for(int i=0;i<N;i++) {
			if(arr[i] == K)
				answer++;
			answer += map.getOrDefault(arr[i] - K, (long)0);
			map.put(arr[i], map.getOrDefault(arr[i], (long)0) + 1);
		}
		
		System.out.println(answer);
	}

}
