package bfs;

import java.util.*;
import java.io.*;

public class B_1039 {
	static int N, M, K;
	static int[] arr;
	static HashSet<Number> visit;
	static int answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String temp = st.nextToken();
		M = temp.length();
		N = Integer.parseInt(temp);
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		for(int i=0;i<M;i++) 
			arr[i] = temp.charAt(i) - '0';
		
		if(M == 1 || M == 2 && N % 10 == 0) {
			System.out.println(-1);
			return;
		}
		visit = new HashSet<>();

		BFS();
		System.out.println(answer);
	}

	static void BFS() {
		Queue<Number> q = new LinkedList<>();

		Number start = new Number(arr, 0);
		visit.add(start);
		q.offer(start);

		while(!q.isEmpty()) {
			Number now = q.poll();

			if(now.cnt % 2 == K % 2) {
				answer = Math.max(getNumber(now.num), answer);
			}

			if(now.cnt + 1 > K)
				continue;
			
			for(int i=0;i<M;i++) {
				for(int j=i+1;j<M;j++) {
					if(now.num[i] == now.num[j]) {
						answer = Math.max(getNumber(now.num), answer);
						continue;
					}
					if(i == 0 && now.num[j] == 0)
						continue;
					
					int[] next = now.num.clone();
					int temp = next[i];
					next[i] = next[j];
					next[j] = temp;
					
					Number n = new Number(next, now.cnt + 1);
					if(visit.contains(n))
						continue;
					
					visit.add(n);
					q.offer(n);
				}
			}
		}
	}
	
	static int getNumber(int[] a) {
		int ret = a[0];
		
		for(int i=1;i<M;i++) {
			ret *= 10;
			ret += a[i];
		}
		
		return ret;
	}

	static class Number {
		int[] num;
		int cnt;

		Number(int[] num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}
		
		@Override 
		public boolean equals(Object o) {
			Number n = (Number)o;
			return Arrays.equals(this.num, n.num);
		}
		
		@Override
		public int hashCode() {
			return ("").hashCode(); // 배열 값을 비교해야 하므로 hashcode는 모두 같은 값을 가지도록 함
		}
	}

}
