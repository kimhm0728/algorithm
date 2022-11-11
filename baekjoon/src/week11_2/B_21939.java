package week11_2;

import java.io.*;
import java.util.*;

public class B_21939 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		// 문제번호, 난이도
		PriorityQueue<int[]> min = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
		PriorityQueue<int[]> max = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? o2[0] - o1[0] : o2[1] - o1[1]);
		int[] problem = new int[100001];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int degree = Integer.parseInt(st.nextToken());
			
			min.add(new int[] {num, degree});
			max.add(new int[] {num, degree});
			problem[num] = degree;
		}
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			
			if(cmd.equals("recommend")) {
				if(num == 1) {
					while(true) {
						if(max.peek()[1] != problem[max.peek()[0]])
							max.poll();
						else {
							sb.append(max.peek()[0]).append('\n');
							break;
						}
					}
				}
				else {
					while(true) {
						if(min.peek()[1] != problem[min.peek()[0]])
							min.poll();
						else {
							sb.append(min.peek()[0]).append('\n');
							break;
						}
					}
				}
			}
			else if(cmd.equals("add")) {
				int degree = Integer.parseInt(st.nextToken());
				min.add(new int[] {num, degree});
				max.add(new int[] {num, degree});
				problem[num] = degree;
			}
			else  // solved
				problem[num] = 0;
		}
		
		System.out.println(sb);
	
	}

}
