package java.practice.week10_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_14391 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N*M];
		int max = 0;
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) 
				arr[i * M + j] = str.charAt(j) - '0';
		}

		for(int s=0;s<(1<<(N*M));s++) {
			int sum = 0, tmp = 0;

			for(int i=0;i<N;i++) { // ����
				tmp = 0;
				for(int j=0;j<M;j++) {
					int idx = i * M + j;
					if((s&(1<<idx)) == 0) {
						tmp *= 10;
						tmp += arr[idx];
					}
					else {
						sum += tmp;
						tmp = 0;
					}
				}
				sum += tmp;
			}

			for(int j=0;j<M;j++) { // ����
				tmp = 0;
				for(int i=0;i<N;i++) {
					int idx = i * M + j;
					if((s&(1<<idx)) != 0) {
						tmp *= 10;
						tmp += arr[idx];
					}
					else {
						sum += tmp;
						tmp = 0;
					}
				}
				sum += tmp;
			}

			max = Math.max(max, sum);
		}

		System.out.println(max);
	}


}
