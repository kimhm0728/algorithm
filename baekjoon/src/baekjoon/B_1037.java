package baekjoon;
import java.util.*;
import java.io.*;

public class B_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		int[] divisor = new int[number];
		int N;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<number;i++) 
			divisor[i] = Integer.parseInt(st.nextToken());
		if(number == 2)
			N = divisor[0] * divisor[1];
		else {
			int max = divisor[0];
			int min = divisor[0];
			for(int i=1;i<number;i++) {
				if(max < divisor[i])
					max = divisor[i];
				if(min > divisor[i])
					min = divisor[i];
			}
			N = max * min;
		}
		System.out.println(N);
	}

}
