package week_1_1;

import java.util.*;
import java.io.*;

public class B_20365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str, "R");
		int b = st.countTokens();
		
		st = new StringTokenizer(str, "B");
		int r = st.countTokens();
		
		int answer = Math.min(b, r) + 1;
		System.out.println(answer);
	}

}
