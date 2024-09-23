package java.backtracking;

import java.io.*;

public class B_9663 {
    static int N;
    static int[] arr;
    static int answer = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        DFS(0);
        System.out.println(answer);
    }
    
    static void DFS(int depth) {
        if(depth == N) {
            answer++;
            return;
        }
        
        for(int i=0;i<N;i++) {
            arr[depth] = i;
            if(check(depth)) 
                DFS(depth + 1);
        }
    }
    
    static boolean check(int idx) {
        for(int i=0;i<idx;i++) 
            if(arr[i] == arr[idx] || Math.abs(i - idx) == Math.abs(arr[i] - arr[idx]))
                return false;
        return true;
    }
}
