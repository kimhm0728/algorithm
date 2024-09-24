import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
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

// public class B_11053 {
// 	static int[] seq;
// 	static Integer[] dp;

// 	public static void main(String[] args) throws IOException {
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		int N = Integer.parseInt(br.readLine());

// 		seq = new int[N];
// 		dp = new Integer[N];

// 		dp[0] = 1;

// 		StringTokenizer st = new StringTokenizer(br.readLine());
// 		for(int i=0;i<N;i++) 
// 			seq[i] = Integer.parseInt(st.nextToken());

// 		int max = 1;
// 		for(int i=1;i<N;i++) 
// 			max = Math.max(max, getLength(i));

// 		System.out.println(max);
// 	}

// 	static int getLength(int n) {
// 		if(dp[n] == null) {
// 			dp[n] = 1;
// 			for(int i=n-1;i>=0;i--) 
// 				if(seq[n] > seq[i])
// 					dp[n] = Math.max(dp[n], getLength(i) + 1);
// 		}

// 		return dp[n];
// 	}

// }
