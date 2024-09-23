package java.greedy;

import java.util.*;
import java.io.*;

public class B_8980 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // ���� ��
		int C = Integer.parseInt(st.nextToken()); // Ʈ���� �뷮
		int M = Integer.parseInt(br.readLine()); // �ڽ� ������ ����
		
		int[][] box = new int[M][3];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			box[i][0] = Integer.parseInt(br.readLine());
			box[i][1] = Integer.parseInt(br.readLine());
			box[i][2] = Integer.parseInt(br.readLine());
		}
		
		// 1. ������ ������ȣ �������� 2. �޴� ������ȣ �������� 3. ������ �ڽ� ���� ��������
		Arrays.sort(box, (o1, o2) -> o1[0] == o2[0] ? 
				(o1[1] == o2[1] ? o2[2] - o1[2] : o1[1] - o1[1]) : o1[0] - o2[0]);
	
		
	}

}
