package java.practice.baekjoon;
import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B_2675 {
	public static void main(String[] args) throws IOException {
		Scanner stdin = new Scanner(System.in);
		int T = stdin.nextInt();
		int t = 0;
		while(true) {
			if(t == T)
				break;
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			String S = st.nextToken();
			
			for(int i=0;i<S.length();i++) 
				for(int j=0;j<R;j++) 
					System.out.print(S.charAt(i));
			
			System.out.println();
			t++;
		}
		stdin.close();
	}

}
