package week11_2;

import java.util.*;
import java.io.*;


public class B_2696 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			int M = Integer.parseInt(br.readLine());
			sb.append(M / 2 + 1).append('\n');
			
			ArrayList<Integer> list = new ArrayList<>();
			int start = 1, end = 0, cnt = 0, m = M;
			
			while(true) {
				st = new StringTokenizer(br.readLine());
				int tmp = m >= 10 ? 10 : m;
				end += tmp;
				m -= tmp;
				
				for(int j=start;j<=end;j++) {
					list.add(Integer.parseInt(st.nextToken()));
					if(j % 2 == 1) {
						Collections.sort(list);
						sb.append(list.get(j / 2)).append(' ');
						cnt++;
						if(cnt % 10 == 0)
							sb.append('\n');
					}
				}
				start = end + 1;
				if(m == 0)
					break;
			}
			if(cnt % 10 != 0)
				sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
