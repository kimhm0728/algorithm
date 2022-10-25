package week10_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class B_2550 {
	private static class Node {
		int num, left, right, parent;
		Node(int num, int left , int right) {
			this.parent = -1;
			this.num = num;
			this.left = left;
			this.right = right;
		}
	}
	
	private static List<Node> list = new ArrayList<>(); // 이진트리
	private static List<Integer> level[]; // 각 레벨에 어떤 노드가 속해있는지 저장
	private static int n;
	private static int num = 0; // 열 번호
	private static int maxLevel = 0; // 트리의 최대 레벨
	private static int widthLevel, maxWidth = -1; 
	private static int root;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		level = new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++)
			list.add(new Node(i, -1, -1));
		
		for(int i=1;i<n+1;i++)
			level[i] = new ArrayList<>();
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			list.get(idx).left = left;
			list.get(idx).right = right;
			
			if(left != -1) list.get(left).parent = idx;
			if(right != -1) list.get(right).parent = idx;
		}
		
		for(int i=1;i<=n;i++) // 루트 찾기
			if(list.get(i).parent == -1) {
				root = i;
				break;
			}
		
		inOrder(root, 1); // 열 번호, 레벨 찾기
		
		for(int i=1;i<=maxLevel;i++)
			getWidth(i);
		
		System.out.println(widthLevel + " " + maxWidth);
		
	}

	private static void inOrder(int idx, int l) {
		if(l > maxLevel)
			maxLevel = l;
		
		Node node = list.get(idx);
		
		if(node.left != -1)
			inOrder(node.left, l + 1);
		
		list.get(idx).num = ++num;
		level[l].add(list.get(idx).num);
		
		if(node.right != -1)
			inOrder(node.right, l + 1);
	}
	
	private static void getWidth(int l) {
		int leftNode = n + 1, rightNode = -1;
		int width;
		
		for(int a : level[l]) {
			if(a < leftNode)
				leftNode = a;
			if(a > rightNode)
				rightNode = a;
		}
		
		width = rightNode - leftNode + 1;
		
		if(width > maxWidth) {
			maxWidth = width;
			widthLevel = l;
		}
	}

}
