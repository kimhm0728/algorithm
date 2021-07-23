package baekjoon;
import java.util.*;
import java.io.*;

public class B_1932 {
	static int n;
	static int[][] num;
	static int[][] max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n][n];
		max = new int[n][n];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<=i;j++) 
				num[i][j] = Integer.parseInt(st.nextToken());
		}
		System.out.println(maxNum());
	}
	static int maxNum() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if(i == 0)
					max[i][j] = num[i][j];
				else {
					if(j == 0)
						max[i][j] = num[i][j] + max[i-1][j];
					else if(j == i)
						max[i][j] = num[i][j] + max[i-1][j-1];
					else
						max[i][j] = num[i][j] + Math.max(max[i-1][j-1], max[i-1][j]);
				}
			}
		}
		int m = max[n-1][0]; // max 배열의 가장 마지막 행에서 최대값 찾기
		for(int i=1;i<n;i++)
			if(m < max[n-1][i])
				m = max[n-1][i];
		return m;
	}
}
