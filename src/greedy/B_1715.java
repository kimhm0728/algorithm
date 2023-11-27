package greedy;

import java.util.*;
import java.io.*;

public class B_1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++)
			pq.add(Integer.parseInt(br.readLine()));
		
		int answer = 0;
		while(pq.size() > 1) {
			int first = pq.poll();
			int second = pq.poll();
			
			pq.add(first + second);
			answer += (first + second);
		}
		
		System.out.println(answer);
	}

}
