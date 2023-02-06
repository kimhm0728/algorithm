package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_1106 {
	static int C, N;
	static int[][] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		cost = new int[N][2]; // 비용, 얻을 수 있는 고객의 수

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(cost, (o1, o2) -> Double.compare((double)o2[0] / o2[1], (double)o1[0] / o1[1]) == 0 ?
				o2[1] - o1[1] : Double.compare((double)o2[0] / o2[1], (double)o1[0] / o1[1]));
		System.out.println(costMin(N - 1, C));
	}

	static int costMin(int n, int customer) {
		if(customer <= 0)
			return 0;
		
		int cnt = customer / cost[n][1];

		if(n == 0)
			return customer - cnt * cost[n][1] == 0 ? cnt * cost[n][0] : (cnt + 1) * cost[n][0];
			
		int answer = Integer.MAX_VALUE;
		for(int i=0;i<=cnt+1;i++) 
			answer = Math.min(i * cost[n][0] + costMin(n - 1, customer - i * cost[n][1]), answer);

		return answer;
	}

}
