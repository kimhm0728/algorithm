package java.practice.week10_1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B_16194 {
	static int[] minP; // ī�带 i�� ��� ����� �ִ� ����
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		minP = new int[N+1];
		int min;
		
		for(int i=1;i<=N;i++) {
			minP[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			min = Integer.MAX_VALUE;
			for(int j=0;j<=i/2;j++) {
				int tmp = minP[j] + minP[i-j];
				if(min > tmp)
					min = tmp;
			}
			minP[i] = min;
		}
		
		System.out.print(minP[N]);
		
	}

}
