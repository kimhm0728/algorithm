package greedy;

import java.util.*;
import java.io.*;

public class B_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		
		int answer = 1;
		int now = time[0][1];
		
		for(int i=1;i<N;i++) {
			if(time[i][0] >= now) {
				answer++;
				now = time[i][1];
			}
			else continue;
		}
		
		System.out.println(answer);
	}

}
