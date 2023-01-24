package bruteForce;

import java.io.*;

public class B_2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for(int i=0;i<N;i++) {
			int con = i;
			String str = String.valueOf(i);
			for(int j=0;j<str.length();j++)
				con += str.charAt(j) - '0';
			
			if(con == N) {
				answer = i;
				break;
			}
		}
		
		System.out.println(answer);
	}

}
