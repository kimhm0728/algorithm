package java.greedy;

import java.util.*;
import java.io.*;

public class B_11000 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
		pq.offer(arr[0][1]);
		
		for(int i=1;i<N;i++) {
			if(pq.peek() <= arr[i][0])
				pq.poll(); // ���� �����ϴ� ���ǽ� �� �� �� �ִٸ� �װɷ� ��ü
			pq.offer(arr[i][1]); // ���ο� ���ǽ� ����
		}
		
		System.out.println(pq.size());
	}
	
}
