package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21943 {
	static int N;
	static int[] arr;
	static char[] oper;
	static int[] num;
	static int p, m;
	static int answer = 0;
	static ArrayList<char[]> oper_list = new ArrayList<>();
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		oper = new char[N - 1];
		num = new int[N];
		Arrays.fill(oper, '*');

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		dfs_oper(0, 0, p);
		dfs_num(0);
		System.out.println(answer);
	}

	static void dfs_oper(int idx, int depth, int n) {
		if (depth == n) {
			oper_list.add(oper.clone());

			visit = new boolean[N];
			return;
		}

		for (int i=idx;i<N-1;i++) {
			if (oper[i] == '+') continue;
			oper[i] = '+';
			dfs_oper(idx + 1, depth + 1, n);
			oper[i] = '*';
		}
	}

	static void dfs_num(int depth) {
		if (depth == N) {
			for (char[] oper : oper_list) {
				answer = Math.max(answer, calculate(num[0], 1, oper));
			}
			return;
		}

		for (int i=0;i<N;i++) {
			if (visit[i]) continue;
			visit[i] = true;
			num[depth] = arr[i];
			dfs_num(depth + 1);
			visit[i] = false;
		}


	}

	static int calculate(int result, int idx, char[] oper) {
		for (int i=idx;i<N;i++) {
			if (oper[i - 1] == '+') {
				result += num[i];
			} else {
				result *= calculate(num[i], i + 1, oper);
				break;
			}
		}
		
		return result;
	}

}