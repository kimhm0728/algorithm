package week_1_1;

import java.util.*;
import java.io.*;

public class B_1758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer[] tip = new Integer[N];
		for(int i=0;i<N;i++)
			tip[i] = Integer.parseInt(br.readLine());

		Arrays.sort(tip, Collections.reverseOrder());
		
		long answer = 0;
		for(int i=0;i<N;i++)
			answer += (tip[i] - i) > 0 ? (tip[i] - i) : 0;
		
		System.out.println(answer);
	}

}
