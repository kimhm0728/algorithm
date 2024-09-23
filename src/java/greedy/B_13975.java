package java.greedy;

import java.util.*;
import java.io.*;

public class B_13975 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int K = Integer.parseInt(br.readLine());
			PriorityQueue<Long> pq = new PriorityQueue<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<K;j++)
				pq.add(Long.parseLong(st.nextToken()));
			
			long answer = 0;
			while(pq.size() > 1) {
				long first = pq.poll();
				long second = pq.poll();
				
				answer += (first + second);
				pq.add(first + second);
			}
			
			sb.append(answer).append('\n');
		}
		
		System.out.println(sb);
	}

}
