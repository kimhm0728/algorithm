package week1_2;

import java.util.*;
import java.io.*;

public class B_2141 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[][] distance = new long[N][2]; // 마을 위치, 사람 수
		
		StringTokenizer st;
		long sum = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			distance[i][0] = Long.parseLong(st.nextToken());
			distance[i][1] = Long.parseLong(st.nextToken());
			sum += distance[i][1];
		}
		
		// 가능한 경우가 여러가진 경우 더 작은 위치를 출력해야 하므로
		Arrays.sort(distance, (o1, o2) -> Long.compare(o1[0], o2[0]) == 0 ? 
				Long.compare(o2[1], o1[1]) : Long.compare(o1[0], o2[0]));

		long people = 0;
		long middle = (sum + 1) / 2; // 총 사람 수의 중간값
		for(int i=0;i<N;i++) {
			people += distance[i][1];
			if(people >= middle) { // 중간값을 넘는 경우에 우체국을 설치해야 함 (가장 사람이 몰려있는 곳에 우체국을 설치해야 하므로)
				System.out.println(distance[i][0]);
				break;
			}
		}
		
	}

}
