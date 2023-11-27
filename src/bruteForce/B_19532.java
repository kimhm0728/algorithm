package bruteForce;

import java.io.*;
import java.util.*;

public class B_19532 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[6];
		for(int i=0;i<6;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		for(int x=-999;x<=999;x++) {
			for(int y=-999;y<=999;y++) {
				if(arr[0] * x + arr[1] * y == arr[2] && 
						arr[3] * x + arr[4] * y == arr[5]) {
					System.out.println(x + " " + y);
					return;
				}
			}
		}
		
	}

}
