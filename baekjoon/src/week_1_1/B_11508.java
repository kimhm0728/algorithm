package week_1_1;

import java.util.*;
import java.io.*;

public class B_11508 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer[] cost = new Integer[N];
		for(int i=0;i<N;i++)
			cost[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(cost, Collections.reverseOrder());
		int cnt = 0;
		int answer = 0;
		
		for(int i=0;i<N;i++)
			if(++cnt % 3 != 0)
				answer += cost[i];
		
		System.out.println(answer);
	}

}
