package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_16508 {
	static String T;
	static int N, len;
	static int[] price;
	static String[] book;
	static boolean[] visit;
	static boolean[] find;
	static boolean[][] use;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = br.readLine();
		N = Integer.parseInt(br.readLine());
		len = T.length();

		price = new int[N];
		book = new String[N];
		visit = new boolean[N];
		find = new boolean[len];
		use = new boolean[N][50];

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			price[i] = Integer.parseInt(st.nextToken());
			book[i] = st.nextToken();
		}

		DFS(0, 0, 0);

		if(answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	static void DFS(int cnt, int start, int sum) {
		if(cnt == len) {
			answer = Math.min(answer, sum);
			return;
		}

		for(int i=start;i<N;i++) {
			int temp = 0;
			ArrayList<int[]> list = new ArrayList<>();

			for(int j=0;j<T.length();j++) {
				if(!find[j]) {
					String s = String.valueOf(T.charAt(j));
					int s_idx = 0;
					
					while(true) {
						int idx = book[i].indexOf(s, s_idx);
						if(idx == -1)
							break;
						if(use[i][idx]) {
							s_idx = idx + 1;
							continue;
						}
						else {
							list.add(new int[] {j, idx});
							find[j] = true;
							use[i][idx] = true;
							temp++;
							break;
						}
					}
				}
			}
			
			if(temp > 0) {
				DFS(cnt + temp, i + 1, sum + price[i]);
				for(int[] arr : list) {
					find[arr[0]] = false;
					use[i][arr[1]] = false;
				}
			}
		}
	}

}
