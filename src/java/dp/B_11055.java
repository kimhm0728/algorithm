import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        int[] dp = arr.clone();
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= arr[i]) continue;
                dp[i] = Math.max(dp[i], arr[i] + dp[j]);
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}

// package java.dp;

// import java.util.*;
// import java.io.*;

// public class B_11055 {
// 	static int N;
// 	static int[] arr;
// 	static Integer[] dp;
	
// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		N = Integer.parseInt(br.readLine());
		
// 		arr = new int[N];
// 		dp = new Integer[N];
		
// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		for(int i=0;i<N;i++) {
// 			arr[i] = Integer.parseInt(st.nextToken());
// 		}
		
// 		dp[0] = arr[0];
// 		int max = dp[0];
// 		for(int i=1;i<N;i++) {
// 			getSequenceSum(i);
// 			max = Math.max(dp[i], max);
// 		}
		
// 		System.out.println(max);
// 	}
	
// 	static int getSequenceSum(int n) {
// 		if(dp[n] == null) {
// 			dp[n] = arr[n];
			
// 			for(int i=n-1;i>=0;i--) {
// 				if(arr[n] > arr[i])
// 					dp[n] = Math.max(dp[n], arr[n] + getSequenceSum(i));
// 			}
// 		}
		
// 		return dp[n];
// 	}

// }
