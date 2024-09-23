package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_18511 {
	static int N, K;
	static int[] arr;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String str = st.nextToken();
		N = Integer.parseInt(str);
		K = Integer.parseInt(st.nextToken());

		arr = new int[K];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<K;i++)
			arr[i] = Integer.parseInt(st.nextToken());

		DFS(0, str.length(), new StringBuilder());
		System.out.println(answer);

	}

	static void DFS(int depth, int len, StringBuilder sb) {
		if(sb.length() > 0) {
			int num = Integer.parseInt(sb.toString());
			if(N < num)
				return;

			answer = Math.max(answer, num);
		}
		
		if(depth == len) {
			return;
		}

		for(int i=0;i<K;i++) {
			sb.append(arr[i]);
			DFS(depth + 1, N, sb);
			sb.setLength(sb.length() - 1);
		}
	}

}
