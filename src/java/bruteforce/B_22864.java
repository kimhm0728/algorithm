package java.bruteforce;

import java.util.*;
import java.io.*;

public class B_22864 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int A = Integer.parseInt(st.nextToken()); // �� �ð� ���ϸ� ���̴� �Ƿε�
		int B = Integer.parseInt(st.nextToken()); // �� �ð� ���ϸ� ó���� �� �ִ� ��
		int C = Integer.parseInt(st.nextToken()); // �� �ð� ���� �پ��� �Ƿε�
		int M = Integer.parseInt(st.nextToken()); // �ѱ�� ���ƿ��� ���� ���� ��
	
		int fatigue = 0; // �Ƿε�
		int throughput = 0; // ó����
		
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
