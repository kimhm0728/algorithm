package baekjoon;
import java.util.*;

public class B_1068 {
	static int N, del;
	static int[] input; // 부모 노드 입력할 배열
	static boolean[] visited; 
	static int count; // 리프 노드 개수
	
	public static void main(String[] args) {
		Scanner stdin = new Scanner(System.in);
		N = stdin.nextInt();
		
		input = new int[N]; 
		int root = 0;
		
		for(int i=0;i<N;i++) {
			input[i] = stdin.nextInt();
			if(input[i] == -1)
				root = i;
		}
		
		del = stdin.nextInt();
		deleteNode(del);
		
		count = 0;
		visited = new boolean[N];
		countLeaf(root);

		System.out.println(count);
		stdin.close();
	}
	static void deleteNode(int d) { // 삭제할 노드의 번호
		input[d] = -2; // 삭제된 노드를 -2로 표시
		for(int i=0;i<N;i++) 
			if(input[i] == d)  // 삭제할 노드를 부모로 가지는 노드를 탐색
				deleteNode(i);
	}
	static void countLeaf(int v) {
		boolean isLeaf = true; // 자식 노드의 여부를 확인하기 위한 변수
		visited[v] = true;
		if(input[v] != -2) {
			for(int i=0;i<N;i++) {
				if(input[i] == v && visited[i] == false) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if(isLeaf) 
				count++; // 자식 노드가 존재하지 않으면 count를 증가
		}
	}
}