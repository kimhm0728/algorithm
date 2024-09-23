package java.bfs;

import java.util.*;
import java.io.*;

public class B_1039 {
    static int N, K, len;
    static HashSet<Integer> visit = new HashSet<>();
    static int answer = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String temp = st.nextToken();
        N = Integer.parseInt(temp);
        K = Integer.parseInt(st.nextToken());
        len = temp.length();
        
        if(len == 2 && N % 10 == 0 || len == 1) {
        	System.out.println(-1);
        	return;
        }
        
        BFS();
        System.out.println(answer);
    }
    
    static void BFS() {
        Queue<Swap> q = new LinkedList<>();
        q.offer(new Swap(N, 0));
        visit.add(N);
        
        while(!q.isEmpty()) {
            Swap now = q.poll();
            
            if(now.cnt % 2 == K % 2) 
                answer = Math.max(answer, now.num);
            
            if(now.cnt == K)
                continue;
            
            for(int i=0;i<len;i++) {
                for(int j=i+1;j<len;j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(now.num);
                    
                    char a = sb.charAt(i);
                    char b = sb.charAt(j);
                    
                    if(i == 0 && b == '0')
                        continue;
                    if(a == b) {
                        answer = Math.max(now.num, answer);
                        continue;
                    }
                    
                    sb.replace(i, i + 1, String.valueOf(b));
                    sb.replace(j, j + 1, String.valueOf(a));
                    
                    int next = Integer.parseInt(sb.toString());
                    if(visit.add(next))
                        q.offer(new Swap(next, now.cnt + 1));
                }
            }
        }
    }
    
    static class Swap {
        int num;
        int cnt;
        
        Swap(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}