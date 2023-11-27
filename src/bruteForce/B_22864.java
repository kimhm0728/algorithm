package bruteForce;

import java.util.*;
import java.io.*;

public class B_22864 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int A = Integer.parseInt(st.nextToken()); // 한 시간 일하면 쌓이는 피로도
		int B = Integer.parseInt(st.nextToken()); // 한 시간 일하면 처리할 수 있는 일
		int C = Integer.parseInt(st.nextToken()); // 한 시간 쉬면 줄어드는 피로도
		int M = Integer.parseInt(st.nextToken()); // 넘기면 번아웃이 오는 일의 양
	
		int fatigue = 0; // 피로도
		int throughput = 0; // 처리량
		
		for(int i=0;i<24;i++) {
			if(fatigue + A > M) { 
				fatigue = fatigue - C < 0 ? 0 : fatigue - C;
			}
			else {
				throughput += B;
				fatigue += A;
			}
		}
		
		System.out.println(throughput);
	}

}
