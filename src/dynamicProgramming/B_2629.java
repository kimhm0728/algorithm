package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_2629 {
	static int N, T;
	static int[] weight;
	static int[] marble;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		weight = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			weight[i] = Integer.parseInt(st.nextToken());

		T = Integer.parseInt(br.readLine());
		marble = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<T;i++) 
			marble[i] = Integer.parseInt(st.nextToken());

		check = new boolean[40001];
		check[0] = true;

		for(int i=0;i<N;i++) {
			int w = weight[i];
			for(int j=40000;j>=w;j--) {
				check[j] = (check[j - w] || check[j]);
				if(w - (j - w) >= 0 && w - (j - w) <= 40000)
					check[w - (j - w)] = (check[j] || check[w - (j - w)]);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++)
			if(check[marble[i]])
				sb.append("Y").append(" ");
			else
				sb.append("N").append(" ");

		System.out.println(sb);
	}

}
