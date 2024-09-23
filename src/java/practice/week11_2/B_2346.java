package java.practice.week11_2;

import java.util.*;
import java.io.*;

public class B_2346 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// �ε���, ���� ��ȣ
		Deque<int[]> d = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++)
			d.offer(new int[] {i + 1, Integer.parseInt(st.nextToken())});
		
		while(d.size() != 1) {
			int arr[] = d.poll();
			sb.append(arr[0]).append(' ');
			
			if(arr[1] < 0)
				for(int j=0;j<-arr[1];j++)
					d.offerFirst(d.pollLast());
			else
				for(int j=1;j<arr[1];j++)
					d.offer(d.poll());
		}
		
		sb.append(d.poll()[0]);
		
		System.out.println(sb);
	}

}
