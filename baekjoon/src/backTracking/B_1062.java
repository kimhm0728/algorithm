package backTracking;

import java.util.*;
import java.io.*;

public class B_1062 {
	static char[] arr;
	static boolean[] visit;
	static Character[] select;
	static HashSet<Character>[] set;
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
		set = new HashSet[N];
		idx = 0; // 실제 값이 존재하는 set
		
		int def = 0;
		HashSet<Character> alpa = new HashSet<>();
		for(int i=0;i<N;i++) {
			set[i] = new HashSet<>();
			
			String str = br.readLine();
			str = str.substring(4, str.length() - 4);
			for(char c : str.toCharArray()) {
				if(c == 'a' || c == 'n' || c == 't' ||
						c == 'i' || c == 'c')
					continue;
				set[idx].add(c);
			}
			
			int size = set[idx].size();
			if(size == 0) {
				def++;
				set[idx].clear();
			}
			else if(size > K) {
				set[idx].clear();
			}
			else {
				alpa.addAll(set[idx]);
				idx++;
			}
		}
		
		int size = alpa.size();
		arr = new char[size];
		visit = new boolean[size];
		Iterator<Character> iter = alpa.iterator();
		
		for(int i=0;i<size;i++)
			arr[i] = iter.next();
		
		select = new Character[K];
		DFS(0, 0, size);
		System.out.println(answer + def);
		
	}
	
	static void DFS(int depth, int start, int n) {
		if(depth == K) {
			answer = Math.max(answer, count());
			return;
		}
		
		for(int i=start;i<n;i++) {
			if(visit[i])
				continue;
			
			visit[i] = true;
			select[depth] = arr[i];
			DFS(depth + 1, start + 1, n);
			visit[i] = false;
		}
	}
	
	static int count() {
		ArrayList<Character> list = new ArrayList<>(Arrays.asList(select));
		
		int cnt = 0;
		Loop : for(int i=0;i<idx;i++) {
			Iterator<Character> iter = set[i].iterator();
			while(iter.hasNext())
				if(!list.contains(iter.next()))
					continue Loop;
			cnt++;
		}
		
		return cnt;
	}

}
