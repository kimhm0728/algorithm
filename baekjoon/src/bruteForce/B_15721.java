package bruteForce;

import java.io.*;

public class B_15721 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int p = -1;
		
		for(int i=1;i<T;i++) {
			for(int j=0;j<4+(i+1)*2;j++) {
				p++;
				
				if(c == 0) {
					if(j == 0 || j == 2 || (j > 3 && j <= 4 + i))
						cnt++;
				}
				if(c == 1) {
					if(j == 1 || j == 3 || (j > 4 + i))
						cnt++;
				}
				
				if(cnt == T) {
					System.out.println(p % A);
					return;
				}
			}
		}

	}

}
