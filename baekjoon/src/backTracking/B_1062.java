package backTracking;

import java.util.*;
import java.io.*;

public class B_1062 {
	static ArrayList<Character>[] list;
	static int N, K, idx;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); // anta ~ tica
		
		if(K < 5) {
			System.out.println(0);
			return;
		}
		if(K == 26) {
			System.out.println(N);
			return;
		}
		
		K -= 5;
		list = new ArrayList[N];
		idx = 0;
		
		int def = 0;
		for(int i=0;i<N;i++) {
			list[i] = new ArrayList<>();
			
			String str = br.readLine();
			str = str.substring(4, str.length() - 4);
			for(char c : str.toCharArray()) {
				if(c == 'a' || c == 'n' || c == 't' ||
						c == 'i' || c == 'c')
					continue;
				list[idx].add(c);
			}
			
			int size = list[idx].size();
			if(size == 0) {
				def++;
				list[idx].clear();
			}
			else if(size > K)
				list[idx].clear();
			else
				idx++;
		}
		
		DFS();
		System.out.println(answer + def);
		
	}
	
	
	static void DFS() {
		for(int i=0;i<idx;i++) {
			
		}
	}

}
