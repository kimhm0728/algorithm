package bruteForce;

import java.util.*;
import java.io.*;

public class B_2503 {
	static int N;
	static String[] str;
	static int[][] arr;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		str = new String[N];
		arr = new int[N][2];
		StringTokenizer st;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			str[i] = st.nextToken();
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=9;j++) {
				for(int k=1;k<=9;k++) {
					if(i == j || j == k || i == k)
						continue;
					if(check(i, j, k))
						answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static boolean check(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		sb.append(a).append(b).append(c);
		String input = sb.toString();
		
		for(int i=0;i<N;i++) {
			int st = 0;
			int ball = 0;
			
			for(int j=0;j<3;j++) {
				for(int k=0;k<3;k++) {
					if(input.charAt(j) == str[i].charAt(k)) {
						if(j == k)
							st++;
						else
							ball++;
					}
				}	
			}
			
			if(arr[i][0] != st || arr[i][1] != ball)
				return false;
		}
		
		return true;
	}

}
