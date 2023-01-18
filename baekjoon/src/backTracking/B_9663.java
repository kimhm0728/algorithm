package backTracking;

import java.io.*;

public class B_9663 {
	static int answer = 0;
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N]; // 인덱스: 열, 값: 행
		
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
	
	// 서로 공격할 수 있는 퀸이 존재하는지 체크
	static boolean check(int col) {
		for(int i=0;i<col;i++) {
			if(arr[col] == arr[i]) // 두 열이 같은 행에 존재하는 경우
				return false;
			
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) // 대각선에 존재하는 경우
				return false;
		}
		
		return true;
	}
}
