package java.greedy;

import java.util.*;
import java.io.*;

public class B_1343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder(br.readLine());
		StringTokenizer st = new StringTokenizer(answer.toString(), ".");
		
		while(st.hasMoreTokens()) {
			String temp = st.nextToken();
			int len = temp.length();
			if(len % 2 == 1) {
				System.out.println(-1);
				return;
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("AAAA".repeat(len / 4));
			sb.append("BB".repeat((len % 4) / 2));
			
			int index = answer.indexOf("X");
			answer.replace(answer.indexOf("X"), len + index, sb.toString());
		}
		
		System.out.println(answer);
	}
}
