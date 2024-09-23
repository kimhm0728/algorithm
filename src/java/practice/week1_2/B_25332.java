package java.practice.week1_2;

import java.util.*;
import java.io.*;

public class B_25332 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] a = new long[N];
		long[] b = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			a[i] = Long.parseLong(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) // b�� b�� a�� ���̸� ����
			b[i] = Long.parseLong(st.nextToken()) - a[i];

		for(int i=1;i<N;i++)
			b[i] += b[i - 1];

		HashMap<Long, Long> map = new HashMap<>();
		long answer = 0;

		for(int i=0;i<N;i++) {
			if(b[i] == 0)
				answer++;
			long cnt = map.getOrDefault(- b[i], (long) 0);
			answer += cnt;
			map.put(b[i], map.getOrDefault(b[i], (long)0) + 1);
		}

		System.out.println(answer);
	}

}
