package skt;

import java.util.*;
import java.io.*;

public class B_21943 {
	static int N;
	static int[] arr;
	static boolean[] plus;
	static int[] order;
	static int p, m;
	static int answer = 0;
	static ArrayList<Character> oper;
	static ArrayList<Integer> num;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		plus = new boolean[N - 1];
		order = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dfs_oper(0, 0, p);
		System.out.println(answer);
	}

	static void dfs_oper(int idx, int depth, int n) {
		if (depth == n) {
			oper = new ArrayList<>();
			for (int i=0;i<N-1;i++) {
				oper.add(plus[i] ? '+' : '*');
			}
			
			visit = new boolean[N];
			dfs_num(0);
			return;
		}

		for (int i=idx;i<N-1;i++) {
			if (plus[i]) continue;
			plus[i] = true;
			dfs_oper(idx + 1, depth + 1, n);
			plus[i] = false;
		}
	}

	static void dfs_num(int depth) {
		if (depth == N) {
			num = new ArrayList<>();
			for (int i=0;i<N;i++) {
				num.add(order[i]);
			}
			
			dfs_result(0, N);
			return;
		}

		for (int i=0;i<N;i++) {
			if (visit[i]) continue;
			visit[i] = true;
			order[depth] = arr[i];
			dfs_num(depth + 1);
			visit[i] = false;
		}


	}

	static void dfs_result( int idx, int n) {
		if (n == 1) {
			answer = Math.max(answer, num.get(0));
			return;
		}

		if (idx + 1 >= n) {
			dfs_result(0, n);
			return;
		}

		for (int i=idx;i<n-1;i++) {
			int n1 = num.get(i);
			int n2 = num.get(i + 1);
			char o = oper.get(i);

			num.set(i, calculate(n1, n2, o));
			num.remove(i + 1);
			oper.remove(i);

			dfs_result(i, n - 1);
			num.set(i, n1);
			num.add(i + 1, n2);
			oper.add(i, o);
		}
	}

	static int calculate(int a, int b, char o) {
		if (o == '+') return a + b;
		return a * b;
	}
}
