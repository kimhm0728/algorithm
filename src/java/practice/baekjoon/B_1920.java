package java.practice.baekjoon;
import java.io.*;
import java.util.StringTokenizer;

public class B_1920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] input = new int[M];
		
		st = new StringTokenizer(br.readLine());
		i = 0;
		while(st.hasMoreTokens()) {
			input[i] = Integer.parseInt(st.nextToken());
			i++;
		}
		
		A: for(int j=0;j<M;j++) {
			for(int k=0;k<N;k++) {
				if(input[j] == arr[k]) {
					sb.append("1").append('\n');
					continue A;
				}
			}
			sb.append("0").append('\n');
		}
		
		System.out.println(sb);
	}

}
