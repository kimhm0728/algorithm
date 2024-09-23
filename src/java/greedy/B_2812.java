package java.greedy;

import java.util.*;
import java.io.*;

public class B_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] num = br.readLine().toCharArray();
		
		Deque<Integer> d = new LinkedList<>();
		for(int i=0;i<N;i++) {
			int n = num[i] - '0';
			while(d.size() != 0 && K > 0 && d.peekLast() < n) {
				K--;
				d.pollLast();
			}
			d.addLast(n);
		}
		
		StringBuilder sb = new StringBuilder();
		int size = d.size();
		for(int i=0;i<size-K;i++)
			sb.append(d.pollFirst());
		
		System.out.println(sb);
	}

}
