package week1_2;

import java.util.*;
import java.io.*;

public class B_8980 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 마을 수
		int C = Integer.parseInt(st.nextToken()); // 트럭의 용량
		int M = Integer.parseInt(br.readLine()); // 박스 정보의 개수
		
		int[][] box = new int[M][3];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			box[i][0] = Integer.parseInt(br.readLine());
			box[i][1] = Integer.parseInt(br.readLine());
			box[i][2] = Integer.parseInt(br.readLine());
		}
		
		// 1. 보내는 마을번호 오름차순 2. 받는 마을번호 오름차순 3. 보내는 박스 개수 내림차순
		Arrays.sort(box, (o1, o2) -> o1[0] == o2[0] ? 
				(o1[1] == o2[1] ? o2[2] - o1[2] : o1[1] - o1[1]) : o1[0] - o2[0]);
	
		
	}

}
