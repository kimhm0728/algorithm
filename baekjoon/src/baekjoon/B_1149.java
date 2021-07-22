package baekjoon;
import java.util.*;
import java.io.*;

public class B_1149 {
	static int N;
	static int[][] cost; // 색깔 별로 각 집을 칠하는 비용
	static int[][] min; // 집을 칠하는 최소 비용
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		min = new int[N][3];
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			cost[i][0] = Integer.parseInt(st.nextToken());
			cost[i][1] = Integer.parseInt(st.nextToken());
			cost[i][2] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(costMin());
	}
	static int costMin() {
		for(int i=0;i<N;i++) {
			if(i == 0) { // i가 0인 경우 cost값을 바로 대입
				min[i][0] = cost[i][0];
				min[i][1] = cost[i][1];
				min[i][2] = cost[i][2];
			}
			else { 
				min[i][0] = cost[i][0] + Math.min(min[i-1][1], min[i-1][2]);
				min[i][1] = cost[i][1] + Math.min(min[i-1][0], min[i-1][2]);
				min[i][2] = cost[i][2] + Math.min(min[i-1][0], min[i-1][1]);
			}
		}
		return Math.min(Math.min(min[N-1][0], min[N-1][1]), min[N-1][2]);
	}
}