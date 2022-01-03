package class2;
import java.io.*;
import java.util.*;

public class B_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] xy = new int[N][2]; // 키와 몸무게를 저장할 배열
		int[] rank = new int[N]; // 각 사람의 등수를 저장할 배열
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) { // 키와 몸무게 입력
			st = new StringTokenizer(br.readLine());
			xy[i][0] = Integer.parseInt(st.nextToken());
			xy[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) // 등수 계산
			for(int j=0;j<N;j++) 
				if(i != j) 
					if(xy[i][0] < xy[j][0] && xy[i][1] < xy[j][1])
						rank[i]++;
		for(int i=0;i<N;i++)
			sb.append(++rank[i]).append(" ");
		System.out.println(sb);
	}
} 