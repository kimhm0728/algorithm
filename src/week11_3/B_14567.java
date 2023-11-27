package week11_3;

import java.util.*;
import java.io.*;

public class B_14567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 과목 수
		int M = Integer.parseInt(st.nextToken()); // 선수 조건 수

		StringBuilder sb = new StringBuilder();
		
		int indegree[] = new int[N + 1];
		ArrayList<Integer> list[] = new ArrayList[N + 1];

		for(int i=1;i<=N;i++)
			list[i] = new ArrayList<>();

		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int pre = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());

			list[pre].add(next);
			indegree[next]++;
		}
		
		// 인덱스, 학기
		Queue<int[]> q = new LinkedList<>();
		int result[] = new int[N];
		
		for(int i=1;i<=N;i++)
			if(indegree[i] == 0) 
				q.offer(new int[] {i, 1});
		
		while(!q.isEmpty()) {
			int arr[] = q.poll();
			int idx = arr[0];
			int semester = arr[1];
			result[idx - 1] = semester;
			
			for(int i : list[idx])
				if(--indegree[i] == 0)
					q.offer(new int[] {i, semester + 1});
		}
		
		for(int i=0;i<N;i++)
			sb.append(result[i]).append(' ');
		
		System.out.println(sb);
	}

}
