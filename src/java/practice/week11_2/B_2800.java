package java.practice.week11_2;

import java.util.*;
import java.io.*;

public class B_2800 {
	static boolean visit[];
	static ArrayList<int[]> list = new ArrayList<>(); // ��ȣ ���� �ε���, �� �ε���
	static ArrayList<String> ans = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();

		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c == '(')
				stack.push(i);
			else if(c == ')')
				list.add(new int[] {stack.pop(), i});
		}
		
		visit = new boolean[list.size()];
		DFS(0, str);
		
		ans.sort(Comparator.naturalOrder());
		for(String s : ans)
			sb.append(s).append('\n');
		
		System.out.println(sb);
	}
	
	static void DFS(int idx, String str) {
		for(int i=idx;i<list.size();i++) {
			if(!visit[i]) {
				visit[i] = true;
				StringBuilder temp = new StringBuilder(str);
				int[] arr = list.get(i);
				temp.setCharAt(arr[0], ' ');
				temp.setCharAt(arr[1], ' ');
				
				String s = temp.toString().replaceAll(" ", "");
				if(!ans.contains(s))
					ans.add(s);

				DFS(i + 1, temp.toString());
				visit[i] = false;
			}
		}
	}

}
