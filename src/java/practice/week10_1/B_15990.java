package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_15990 {
	static long[][] d = new long[100001][4];
	/*
	d[i][0] : ���� ��
	d[i][1] : 1�� ������ ����
	d[i][2] : 2�� ������ ����
	d[i][3] : 3���� ������ ����
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		d[1][1] = 1;
		d[2][2] = 1;
		d[3][1] = 1;
		d[3][2] = 1;
		d[3][3] = 1;
		
		for(int i=0;i<T;i++) 
			sb.append(dp(Integer.parseInt(br.readLine()))).append('\n');
			
		System.out.print(sb);
	}
	
	static long dp(int n) {
		if(d[n][0] != 0) return d[n][0];
		
		// ������� ���� �� ã��
		int cnt = 3;
		while(true) {
			if(d[++cnt][0] == 0) break;
		}
			
		for(int i=cnt;i<=n;i++) {
			d[i][1] = (d[i-1][2] + d[i-1][3])  % 1000000009;
			d[i][2] = (d[i-2][1] + d[i-2][3]) % 1000000009;
			d[i][3] = (d[i-3][1] + d[i-3][2])  % 1000000009;
		}
		
		return d[n][0] = (d[n][1] + d[n][2] + d[n][3]) % 1000000009;

	}

}
