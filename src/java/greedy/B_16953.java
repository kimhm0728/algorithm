package java.greedy;

import java.util.*;
import java.io.*;

public class B_16953 {
	static long answer = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		
		BFS(a, b);
		System.out.println(answer);
	}

	static void BFS(long a, long b) {
		Queue<long[]> q = new LinkedList<>();
		q.offer(new long[] {a, 0}); // ���� ����, ���� Ƚ��
		
		while(!q.isEmpty()) {
			long[] temp = q.poll();
			long num = temp[0];
			long cnt = temp[1];
			
			if(num == b) {
				answer = cnt + 1;
				return;
			}
			
			// 2�� ���Ѵ�
			long next = num * 2;
			if(next <= b)
				q.offer(new long[] {next, cnt + 1});
			
			// 1�� ���� ���� �����ʿ� �߰��Ѵ�
			next = num * 10 + 1;
			if(next <= b)
				q.offer(new long[] {next, cnt + 1});
		}
	}
}
