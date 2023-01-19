package greedy;

import java.util.*;
import java.io.*;

public class B_2812 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String num = br.readLine();
		StringBuilder answer = new StringBuilder(num);
		
		char[] arr = num.toCharArray();
		Arrays.sort(arr);
		
		for(int i=0;i<K;i++) {
			int idx = answer.indexOf(String.valueOf(arr[i]));
			answer.replace(idx, idx + 1, "*");
		}
		
		System.out.println(answer.toString().replaceAll("\\*", ""));
	}

}
