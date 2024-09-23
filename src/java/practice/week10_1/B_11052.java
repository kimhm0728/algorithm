package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_11052 {
	static int[] maxP; // ī�带 i�� ��� ����� �ִ� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		maxP = new int[N+1];
		int max;
		
		for(int i=1;i<=N;i++) {
			maxP[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			max = -1;
			for(int j=0;j<=i/2;j++) {
				int tmp = maxP[j] + maxP[i-j];
				if(max < tmp)
					max = tmp;
			}
			maxP[i] = max;
		}
		
		System.out.print(maxP[N]);
		
	}

}
