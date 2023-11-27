package week10_2;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B_1991 {
	private static class Node {
		int left, right;
		Node(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	private static List<Node> list[];
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n];
		
		for(int i=0;i<n;i++)
			list[i] = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = st.nextToken().charAt(0) - 'A';
			
			int left = st.nextToken().charAt(0);
			left = left == '.' ? -1 : left - 'A'; 
				
			int right = st.nextToken().charAt(0);
			right = right == '.' ? -1 : right - 'A';
			
			list[idx].add(new Node(left, right));
		}
		
		preorder(0);
		sb.append('\n');
		inorder(0);
		sb.append('\n');
		postorder(0);
		
		System.out.println(sb);
		
	}
	
	private static void preorder(int root) {
		Node node = list[root].get(0);
		
		sb.append((char)(root + 'A'));
		
		if(node.left != -1)
			preorder(node.left);
		
		if(node.right != -1)
			preorder(node.right);
	}
	
	private static void inorder(int root) {
		Node node = list[root].get(0);
		
		if(node.left != -1)
			inorder(node.left);
		
		sb.append((char)(root + 'A'));
		
		if(node.right != -1)
			inorder(node.right);
	}
	
	private static void postorder(int root) {
		Node node = list[root].get(0);
		
		if(node.left != -1)
			postorder(node.left);
		
		if(node.right != -1)
			postorder(node.right);
		
		sb.append((char)(root + 'A'));
	}


}
