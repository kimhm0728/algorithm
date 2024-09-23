package java.backtracking;

import java.util.*;
import java.io.*;

public class B_1174 {
	static int[] num = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
	static int N;
	static ArrayList<Long> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		DFS(0, 0);
		Collections.sort(list);

		if(list.size() < N)
			System.out.println(-1);
		else
			System.out.println(list.get(N - 1));
	}

	static void DFS(int start, long result) {
		for(int i=start;i<10;i++) {
			list.add(result * 10 + num[i]);
			DFS(i + 1, result * 10 + num[i]);
		}
	}
}