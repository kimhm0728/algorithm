package week1_1;

import java.util.*;
import java.io.*;

public class B_2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] weight = new int[N];
		
		for(int i=0;i<N;i++) 
			weight[i] = Integer.parseInt(br.readLine());
		
		int answer = 0;
		int cnt = N;
		Arrays.sort(weight);
		
		// 버틸 수 있는 중량이 가장 적은 로프를 사용할 경우
		// N개의 로프가 그 로프의 무게만큼 들어올릴 수 있다.
		// 두 번째로 적은 로프를 사용할 경우 (N-1)개 (가장 적은 로프 제외하므로)
		for(int i=0;i<N;i++) 
			answer = Math.max(answer, weight[i] * cnt--);
		
		System.out.println(answer);
	}

}
