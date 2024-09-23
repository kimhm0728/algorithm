package java.backtracking;

import java.util.*;
import java.io.*;

public class B_1062 {
	static String[] str;
	static boolean[] visit;
	static int N, K;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		str = new String[N];
		visit = new boolean[26];

		if(K < 5) {
			System.out.println(0);
			return;
		}
		if(K == 26) {
			System.out.println(N);
			return;
		}

		K -= 5;

		for(int i=0;i<N;i++) 
			str[i] = br.readLine().replaceAll("anta|tica", "");

		visit['a' - 'a'] = true;
		visit['n' - 'a'] = true;
		visit['t' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['c' - 'a'] = true;

		DFS(0, 0);
		System.out.println(answer);

	}

	static void DFS(int depth, int start) {
		if(depth == K) {
			int cnt = 0;
			Loop : for(int i=0;i<N;i++) {
				for(int j=0;j<str[i].length();j++)
					if(!visit[str[i].charAt(j) - 'a'])
						continue Loop;
				cnt++;
			}

			answer = Math.max(answer, cnt);
			return;
		}

		for(int i=start;i<26;i++) {
			if(visit[i])
				continue;

			visit[i] = true;
			DFS(depth + 1, i + 1);
			visit[i] = false;
		}
	}

}
