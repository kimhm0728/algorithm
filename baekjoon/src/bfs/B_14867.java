package bfs;

import java.util.*;
import java.io.*;

public class B_14867 {
	static int A, B, C, D;
	static HashSet<Water> visit;
	static Queue<Water> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		visit = new HashSet<>();
		System.out.println(BFS());
	}

	static int BFS() {
		// 두 물통의 용량 0으로 시작
		addVisit(new Water(0, 0, 0));

		while(!q.isEmpty()) {
			Water now = q.poll();

			if(now.a == C && now.b == D) {
				return now.cnt;
			}

			if(now.a < A) // F(a)
				addVisit(new Water(A, now.b, now.cnt + 1));
			
			if(now.b < B) // F(b)
				addVisit(new Water(now.a, B, now.cnt + 1));
			
			if(now.a > 0) // E(a)
				addVisit(new Water(0, now.b, now.cnt + 1));
			
			if(now.b > 0) // E(b)
				addVisit(new Water(now.a, 0, now.cnt + 1));
			
			if(now.a <= B - now.b) // M(a, b)
				// a만큼 b에 빈공간이 있다면 모두 옮김
				addVisit(new Water(0, now.a + now.b, now.cnt + 1));
			else // a만큼 b에 빈공간이 없다면 남은 공간만큼 옮김
				addVisit(new Water(now.a - (B - now.b), B, now.cnt + 1));

			if(now.b <= A - now.a) // M(b, a)
				addVisit(new Water(now.a + now.b, 0, now.cnt + 1));
			else 
				addVisit(new Water(A, now.b - (A - now.a), now.cnt + 1));
		}

		return -1;
	}
	
	static void addVisit(Water w) {
		if(visit.contains(w))
			return;
		
		visit.add(w);
		q.offer(w);
	}

	static class Water {
		int a, b, cnt;

		Water(int a, int b, int cnt) {
			this.a = a;
			this.b = b;
			this.cnt = cnt;
		}
		
		@Override
		public boolean equals(Object o) {
			Water w = (Water) o;
			return (this.a == w.a && this.b == w.b);
		}
		
        @Override
        public int hashCode() {
            return (""+a+b).hashCode();
        }
	}
}
