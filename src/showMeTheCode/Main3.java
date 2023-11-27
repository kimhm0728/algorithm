package showMeTheCode;

import java.util.*;
import java.io.*;

public class Main3 {
	static int N, M, C, K;
	static long[][] W;
	static HashMap<Integer, Integer> A = new HashMap<>();
	static HashMap<Integer, Integer> B = new HashMap<>();
	static long answer = 0;

	// DFS
	static int[] person;
	static boolean[] visite;
	static boolean[] visit;
	static int[] order;
	static HashSet<String> check = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken()) - 1;

		K = Math.min(N, M); // K쌍을 뽑아야 함
		W = new long[K][C];

		person = new int[C + 1];
		for(int i=0;i<=C;i++)
			person[i] = i;
		order = new int[C + 1];

		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++)
				W[i][j] = Long.parseLong(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int p = Integer.parseInt(st.nextToken()) - 1;
			A.put(p, A.getOrDefault(p, 0) + 1);
		}

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int p = Integer.parseInt(st.nextToken()) - 1;
			B.put(p, B.getOrDefault(p, 0) + 1);
		}

		if((C + 1) % 2 == 0)
			for(int i=0;i<C+1;i+=2) {
				visite = new boolean[C + 1];
				visit = new boolean[C + 1];
				DFSe(0, i, 0);
			}
		else
			for(int i=1;i<C+1;i+=2) {
				visite = new boolean[C + 1];
				visit = new boolean[C + 1];
				DFSe(0, i, 0);
			}
		
		System.out.println(answer);
	}

	static void DFSe(int depth, int n, int start) {
		if(depth == n) {
			DFS(0, C + 1 - n);
			return;
		}

		for(int i=start;i<=C;i++) {
			if(visite[i])
				continue;
			visite[i] = true;
			DFSe(depth + 1, n, i + 1);
			visit[i] = true;
		}
	}
	
	static void DFS(int depth, int n) {
		if(depth == n) {
			calcute(depth);
			return;
		}

		for(int i=0;i<=C;i++) {
			if(visit[i] || visite[i])
				continue;
			visit[i] = true;
			order[depth] = i;
			DFS(depth + 1, n);
			visit[i] = false;
		}
	}

	static void calcute(int depth) {
		ArrayList<long[]> list = new ArrayList<>();
		for(int i=0;i<C+1;i++)
			if(visite[i])
				list.add(new long[] {i, i, W[i][i]});

		StringBuilder sb = new StringBuilder();
		int x = 0, y = 0;
		for(int i=0;i<depth;i++) {
			if(i % 2 == 0)
				x = order[i];
			else {
				y = order[i];
				int max = Math.max(x, y);
				int min = Math.min(x, y);
				sb.append(max).append(min);

				list.add(new long[] {(long)max, (long)min, W[max][min]});
			}
		}

		if(check.contains(sb.toString()))
			return;

		check.add(sb.toString());

		list.sort((o1, o2) -> Long.compare(o2[2], o1[2]));

		long result = 0;
		int aCnt = K, bCnt = K;
		for(long[] arr : list) {
			int a = A.get((int)arr[0]) + A.get((int)arr[1]);
			int b = B.get((int)arr[1]) + B.get((int)arr[0]);

			int cnt = Math.min(a, b);
			result += arr[2] * cnt;

			aCnt -= cnt;
			bCnt -= cnt;
		}

		answer = aCnt == 0 || bCnt == 0 ? Math.max(result, answer) : answer;
		
		// HashMap을 직접적으로 바꾸면 안됨 (깊은복사 ㄱ)
		// [1][2]인 경우 1,2의 전체 명수를 W와 곱해야 함.. 계산하는거 다시 고민
	}
}
