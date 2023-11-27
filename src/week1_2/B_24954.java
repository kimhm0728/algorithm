package week1_2;

import java.util.*;
import java.io.*;

public class B_24954 {
	static int N;
	static int answer = 10001;
	static int[] cost;
	static ArrayList<int[]>[] sale;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N];
		visit = new boolean[N];
		sale = new ArrayList[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cost[i] = Integer.parseInt(st.nextToken());
			sale[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N;i++) {
			int p = Integer.parseInt(br.readLine());
			for(int j=0;j<p;j++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken()) - 1;
				int c = Integer.parseInt(st.nextToken());
				
				sale[i].add(new int[] {idx, c});
			}
		}
		
		DFS(0, 0);
		System.out.println(answer);
	}
	
	static void DFS(int depth, int sum) {
		if(depth == N) {
			System.out.println();
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visit[i]) {
				System.out.print(i);
				visit[i] = true;
				int temp = cost[i]; // cost[i]의 값이 변경될 수 있으므로 저장(다시 되돌리기 위해)
				sum += cost[i] < 0 ? 1 : cost[i];
				
				for(int[] arr : sale[i]) 
					cost[arr[0]] -= arr[1];
				
				DFS(depth + 1, sum);
				
				visit[i] = false;
				for(int[] arr : sale[i]) 
					cost[arr[0]] += arr[1];
				sum -= temp;
			}
		}
	}

}
