package bruteForce;

import java.util.*;
import java.io.*;

public class B_1969 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		String[] arr = new String[N];
		for(int i=0;i<N;i++)
			arr[i] = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			HashMap<Character, Integer> map = new HashMap<>();
			for(int j=0;j<N;j++) {
				char c = arr[j].charAt(i);
				map.put(c, map.getOrDefault(c, 0) + 1);
			}
			
			int max = 0;
			char c = ' ';
			
			ArrayList<Character> list = new ArrayList<>(map.keySet());
			for(char key : list) {
				int val = map.get(key);
				if(val > max) {
					max = val;
					c = key;
				}
				else if(val == max && Character.compare(key, c) < 0) {
					c = key;
				}
			}
			
			sb.append(c);
			answer += N - max;
		}
		
		System.out.println(sb);
		System.out.println(answer);
	}

}
