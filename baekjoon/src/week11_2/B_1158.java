package week11_2;

import java.util.*;
import java.io.*;

public class B_1158 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        
        sb.append('<');
        for(int i=0;i<N;i++)
            q.offer(i + 1);
        
        while(!q.isEmpty()) {
            for(int i=1;i<K;i++)
                q.offer(q.poll());
            sb.append(q.poll()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append('>');
        
        System.out.println(sb);
	}

}
