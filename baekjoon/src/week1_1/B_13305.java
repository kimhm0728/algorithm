package week1_1;

import java.util.*;
import java.io.*;

public class B_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer dis = new StringTokenizer(br.readLine());
		StringTokenizer cos = new StringTokenizer(br.readLine());
		
		long[] distance = new long[N - 1];
		long[] cost = new long[N];
		
		for(int i=0;i<N;i++) {
			cost[i] = Long.parseLong(cos.nextToken());
			if(i != N - 1)
				distance[i] = Long.parseLong(dis.nextToken());
		}
		
		long answer = cost[0] * distance[0];
		long now = cost[0]; // 현재 주유소 가격
		for(int i=1;i<N-1;i++) {
			if(cost[i] < now) // 현재보다 더 저렴하면 그 주유소에서 기름을 넣음
				now = cost[i];
			answer += distance[i] * now;
		}
		
		System.out.println(answer);
	}

}
