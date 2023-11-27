package dynamicProgramming;

import java.util.*;
import java.io.*;

public class B_21941 {
	static String S;
	static int M;
	static String[] str;
	static int[] score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		M = Integer.parseInt(br.readLine());
	
		str = new String[M];
		score = new int[M];
		
		StringTokenizer st;
		for (int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			str[i] = st.nextToken();
			score[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
}
