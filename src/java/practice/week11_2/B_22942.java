package java.practice.week11_2;

import java.io.*;
import java.util.*;

public class B_22942 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			arr[i][0] = x - r; // ���� ���� ��ǥ
			arr[i][1] = x + r; // ���� �� ��ǥ
		}

		// ���� ��ǥ�� ���� ������� ����. ���� ��ǥ�� ���� ��� �� ��ǥ�� ū ������� ���� 
		Arrays.sort(arr, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);

		int start = arr[0][0];
		int end = arr[0][1];

		for(int i=1;i<arr.length;i++) {
			if(start == arr[i][0] || (start < arr[i][0] && arr[i][0] < end && end <= arr[i][1])) { // ����
				System.out.println("NO");
				return;
			}
			start = arr[i][0];
			end = arr[i][1];
		}
		
		System.out.println("YES");
	}
}
