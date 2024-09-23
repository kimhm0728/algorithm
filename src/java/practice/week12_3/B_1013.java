package java.practice.week12_3;

import java.io.*;
import java.util.regex.*;

public class B_1013 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		String regex = "(100+1+|01)+";
		boolean result;
		
		for(int i=0;i<T;i++) {
			String input = br.readLine();
			result = Pattern.matches(regex, input);
			sb.append(result ? "YES" : "NO").append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
