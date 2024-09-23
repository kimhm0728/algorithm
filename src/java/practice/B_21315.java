package java.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21315 {
	static int n;
	static int[] arr;
	static int[] right;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		right = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			right[i] = i + 1;
		}
		
		int k = 0;
		for (int i=1;i<n;i++) {
			if (Math.pow(2, i) >= n) break;
			k = i;
		} 
		
		for (int i=1;i<=k;i++) {
			int[] temp = calculate(arr.clone(), i);
			for (int j=1;j<=k;j++) {
				if (isEqual(calculate(temp.clone(), j), right)) {
					System.out.println(j + " " + i);
					return;
				}
			}
		}
	}
	
	static int[] calculate(int[] a, int k) {
		for (int i=0;i<k;i++) {
			int cnt = (int) Math.pow(2, i);
			int dis = cnt * 2 - cnt;
			
			for (int j=0;j<cnt;j++) {
				int temp = a[j];
				a[j] = a[j + dis];
				a[j + dis] = temp;
			}
		}
		
		int[] ret = new int[n];
		int cnt = (int) Math.pow(2, k);
		for (int j=0;j<cnt;j++) {
			ret[j + n - cnt] = a[j];
		}
		for (int j=cnt;j<n;j++) {
			ret[j - cnt] = a[j];
		}
		
		return ret;
	}
	
	static boolean isEqual(int[] a, int[] b) {
		for (int i=0;i<n;i++) if (a[i] != b[i]) return false;
		return true;
	}
	
}
