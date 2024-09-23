package java.bruteforce;

import java.io.*;

public class B_17626 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int i = 0, j = 0, k = 0, l = 0;
		Loop: for(i=0;i<224;i++) {
			for(j=0;j<224;j++) {
				if(j * j > N) break;
				for(k=0;k<224;k++) {
					if(k * k > N) break;
					for(l=0;l<224;l++) {
						if(l * l > N) break;
						int temp = i * i + j * j + k * k + l * l;
						if(temp > N)
							break;
						else if(i * i + j * j + k * k + l * l == N)
							break Loop;
					}
				}
			}
		}

		int cnt = 0;
		if(i != 0) cnt++;
		if(j != 0) cnt++;
		if(k != 0) cnt++;
		if(l != 0) cnt++;

		System.out.println(cnt);
	}

}
