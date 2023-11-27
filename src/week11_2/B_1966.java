package week11_2;

import java.util.*;
import java.io.*;

public class B_1966 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0;i<K;i++) {
			// 인덱스, 중요도
			Queue<int[]> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
	
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for(int j=0;j<N;j++) 
				q.offer(new int[] {j, Integer.parseInt(st.nextToken())});
			
			int cnt = 0;
			while(true) {
				int max = maxDegree(q);
				int[] arr = q.poll();
				if(arr[1] < max)
					q.offer(arr);
				else if(arr[1] == max) {
					cnt++;
					if(arr[0] == M) {
						sb.append(cnt).append('\n');
						break;
					}
				}
			}
		}
		
		System.out.println(sb);
	}
	
	static int maxDegree(Queue<int[]> q) {
		Iterator<int[]> iter = q.iterator();
		int max = 0;
		
		while(iter.hasNext()) {
			int[] arr = iter.next();
			max = Math.max(max, arr[1]);
		}
		
		return max;
	}

}
