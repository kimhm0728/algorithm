package java.practice.week12_3;

import java.io.*;

public class B_3447 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input;
		while((input = br.readLine()) != null) {
			input = input.replaceAll("BUG", "");
			sb.append(input).append('\n');
		}
		
		System.out.println(sb);
		br.close();
	}

}
