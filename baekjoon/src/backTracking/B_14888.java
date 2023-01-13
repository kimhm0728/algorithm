package backTracking;

import java.util.*;
import java.io.*;

public class B_14888 {
	static int N;
	static int[] num;
	static int[] oper;
	static int[] order; // 연산 순서 저장
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		oper = new int[N - 1];
		order = new int[N - 1];
		visit = new boolean[N - 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) 
			num[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for(int i=0;i<4;i++) {
			int cnt = Integer.parseInt(st.nextToken());
			for(int j=0;j<cnt;j++)
				oper[idx + j] = i;
			idx += cnt;
		}
		
		DFS(0);

		System.out.println(max);
		System.out.println(min);
	}

	static void DFS(int depth) {
		if(depth == N - 1) {
			int result = getResult();
			max = Math.max(max, result);
			min = Math.min(min, result);
			return;
		}

		for(int i=0;i<N-1;i++) {
			if(visit[i])
				continue;
			visit[i] = true;
			order[depth] = oper[i];
			DFS(depth + 1);
			visit[i] = false;
		}
	}

	static int getResult() {
		int ret = num[0];
		for(int i=0;i<N-1;i++) 
			ret = calcute(ret, num[i + 1], order[i]);
		return ret;
	}

	static int calcute(int num1, int num2, int oper) {
		int ret = 0;
		switch(oper) {
		case 0:
			ret = num1 + num2;
			break;
		case 1:
			ret = num1 - num2;
		break;
		case 2:
			ret = num1 * num2;
			break;
		case 3:
			if(num1 < 0 && num2 > 0) 
				ret = -(-num1 / num2);
			else 
				ret = num1 / num2;
			break;
		}
		return ret;
	}

}
