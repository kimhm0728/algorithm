package java.dp;

import java.util.*;
import java.io.*;

public class B_1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] jewel = new int[N][2];
		int[] bag = new int[K];

		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			jewel[i][0] = Integer.parseInt(st.nextToken());
			jewel[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i=0;i<K;i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewel, (o1, o2) -> o1[0] - o2[0]);
		Arrays.sort(bag);

		long answer = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		int idx = 0;
		for (int i=0;i<K;i++) {
			for (;idx<N;idx++) {
				if (bag[i] < jewel[idx][0]) {
					break;
				}
				pq.offer(jewel[idx][1]);
			}
			
			if (!pq.isEmpty()) answer += pq.poll();
		}

		System.out.println(answer);
	}

}
