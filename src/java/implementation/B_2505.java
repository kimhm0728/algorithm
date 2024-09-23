package java.implementation;

import java.util.*;
import java.io.*;

public class B_2505 {
	static int n;
	static int[] arr;
	static int x1, y1, x2, y2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		

		reset();
		
		if (!front(arr.clone())) {
			reset();
			back();
		}
		
		System.out.println(x1 + " " + y1);
		System.out.println(x2 + " " + y2);
	}
	
	static void reset() {
		x1 = y1 = x2 = y2 = 1;
	}
	
	static void reverse(int[] a, int i, int j) {
		int end = (i + j) % 2 == 0 ? (i + j) / 2 - 1 : (i + j) / 2;
		
		for (int s=i;s<=end;s++) {
			int temp = a[s];
			a[s] = a[j - s + i];
			a[j - s + i] = temp;
		}
	} 
	
	static boolean front(int[] a) {
		int i = 0;
		
		L: for (int cnt=0;cnt<3;cnt++) {
			for (;i<n;i++) {
				if (a[i] != i + 1) {
					if (cnt == 2) return false;
					
					int j = i + 1;
					for (;j<n;j++) {
						if (a[j] == i + 1) break;
					}
					
					reverse(a, i, j);
					if (cnt == 0) {
						x1 = i + 1;
						y1 = j + 1;
					} else {
						x2 = i + 1;
						y2 = j + 1;
					}
					i++;
					continue L;
				}
			}
			return true;
		}
		
		return false;
	}

	static void back() {
		int i = n-1;
		
		L: for (int cnt=0;cnt<2;cnt++) {
			for (;i>=0;i--) {
				if (arr[i] != i + 1) {
					int j = i - 1;
					for (;j>0;j--) {
						if (arr[j] == i + 1) break;
					}
					
					reverse(arr, j, i);
					if (cnt == 0) {
						x1 = j + 1;
						y1 = i + 1;
					} else {
						x2 = j + 1;
						y2 = i + 1;
					}
					continue L;
				}
			}
		}
	}
}
