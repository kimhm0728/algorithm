package week_1_1;

import java.util.*;
import java.io.*;

public class B_20300 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long[] exercise = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			exercise[i] = Long.parseLong(st.nextToken());

		Arrays.sort(exercise);
		long answer = N % 2 == 1 ? exercise[N - 1] : Long.MIN_VALUE;

		for(int i=0;i<N/2;i++) {
			long temp;
			if(N % 2 == 1)
				temp = exercise[i] + exercise[N - i - 2];
			else
				temp = exercise[i] + exercise[N - i - 1];
			answer = Math.max(answer, temp);
		}

		System.out.println(answer);
	}

}
