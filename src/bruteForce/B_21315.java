package bruteForce;

import java.util.*;
import java.io.*;

public class B_21315 {
	static int N;
	static int[] arr;
	static int[] temp1;
	static int[] temp2;
	static int first = 0, second = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
			arr[i] = Integer.parseInt(st.nextToken());

		int K = 1;
		for(int i=1;i<N;i++) // 될 수 있는 K의 최대값 찾기
			if(Math.pow(2, i) < N)
				K = i;
			else 
				break;

		Loop: for(int i=1;i<=K;i++) {
			temp1 = reverseMix(i, arr.clone());
			for(int j=1;j<=K;j++) {
				if(i == j)
					continue;

				temp2 = reverseMix(j, temp1.clone());

				if(check(temp2)) {
					first = j;
					second = i;
					break Loop;
				}
			}
		}

		System.out.println(first + " " + second);

	}

	static int[] reverseMix(int K, int[] a) {
		for(int i=0;i<K;i++) {
			// 2^i개의 원소를 2^i+1 - 2^i만큼 뒤에 놓기
			int num = (int)Math.pow(2, i);
			int dis = (int)Math.pow(2, i + 1) - num;

			for(int j=0;j<num;j++) {
				int temp = a[j];
				a[j] = a[j + dis];
				a[j + dis] = temp;
			}
		}

		int[] ret = new int[N];
		int num = (int)Math.pow(2, K);
		for(int i=0;i<num;i++)
			ret[i + (N - num)] = a[i];

		for(int i=0;i<N-num;i++)
			ret[i] = a[i + num];

		return ret;
	} 

	static boolean check(int[] a) {
		for(int i=1;i<=N;i++) 
			if(a[i - 1] != i)
				return false;

		return true;
	} 

}
