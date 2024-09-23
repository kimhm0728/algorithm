package java.practice.baekjoon;
import java.util.*;

public class B_1068 {
	static int N, del;
	static int[] input; // �θ� ��� �Է��� �迭
	static boolean[] visited; 
	static int count; // ���� ��� ����
	
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
	static void deleteNode(int d) { // ������ ����� ��ȣ
		input[d] = -2; // ������ ��带 -2�� ǥ��
		for(int i=0;i<N;i++) 
			if(input[i] == d)  // ������ ��带 �θ�� ������ ��带 Ž��
				deleteNode(i);
	}
	static void countLeaf(int v) {
		boolean isLeaf = true; // �ڽ� ����� ���θ� Ȯ���ϱ� ���� ����
		visited[v] = true;
		if(input[v] != -2) {
			for(int i=0;i<N;i++) {
				if(input[i] == v && visited[i] == false) {
					countLeaf(i);
					isLeaf = false;
				}
			}
			if(isLeaf) 
				count++; // �ڽ� ��尡 �������� ������ count�� ����
		}
	}
}