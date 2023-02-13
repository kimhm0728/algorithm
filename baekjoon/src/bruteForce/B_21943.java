package bruteForce;

import java.util.*;
import java.io.*;

public class B_21943 {
	static int N;
	static int[] num;
	static int[] order;
	static char[] oper;
	static boolean[] visit;
	static int answer = 0;
	static int P, Q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		num = new int[N];
		order = new int[N];
		visit = new boolean[N];
		oper = new char[N - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken()); // +
		Q = Integer.parseInt(st.nextToken()); // *

		if(Q == 0) {
			int sum = 0;
			for(int i=0;i<N;i++)
				sum += num[i];
			System.out.println(sum);
			return;
		}

		Arrays.fill(oper, '+');

		numberDFS(0);
		System.out.println(answer);
	}

	static void numberDFS(int depth) {
		if(depth == N) {
			operDFS(0, 0);
			return;
		}

		for(int i=0;i<N;i++) {
			if(visit[i])
				continue;

			visit[i] = true;
			order[depth] = num[i];
			numberDFS(depth + 1);
			visit[i] = false;
		}
	}

	static void operDFS(int depth, int start) {
		if(depth == Q) {
			answer = Math.max(answer, calcute(0));
			return;
		}

		for(int i=start;i<N-1;i++) {
			oper[i] = '*';
			operDFS(depth + 1, i + 1);
			oper[i] = '+';
		}
	}

	static int calcute(int start) {
		int result = order[start];
		for(int i=start;i<N-1;i++)
			if(oper[i] == '+')
				result += order[i + 1];
			else {
				result *= calcute(i + 1);
				break;
			}
		return result;
	}

}
