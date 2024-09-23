package java.backtracking;

import java.util.*;
import java.io.*;

public class B_14712 {
	static int N, M;
	static boolean[][] visit;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N][M];
		DFS(0, 0);
		
		System.out.println(answer);
	}
	
	static void DFS(int depth, int start) {
		// �۸� 0������ N * M������ ������ �� �����Ƿ� ��� ��츦 ī��Ʈ
		answer += check(depth) ? 1 : 0; 
		if(depth == N * M) // �۸� ��� ä�� ��� DFS ������
			return;

		for(int i=start;i<N*M;i++) {
			int r = i / M;
			int c = i % M;
			if(visit[r][c])
				continue;
			visit[r][c] = true;
			DFS(depth + 1, i + 1);
			visit[r][c] = false;
		}
		
	}
	
	// ���� �� �ִ� �۸� ������ true, ������ false
	static boolean check(int depth) {
		if(depth < 4) // �۸� ���� ������ ��� ���� �� ����
			return true;
		
		for(int i=0;i<N-1;i++)
			for(int j=0;j<M-1;j++) 
				if(visit[i][j] && visit[i][j + 1] && visit[i + 1][j] && visit[i + 1][j + 1])
					return false;
		return true;
	}

}
