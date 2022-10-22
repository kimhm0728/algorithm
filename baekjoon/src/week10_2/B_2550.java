package week10_2;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class B_2550 {
	private static class Node {
		int left, right;
		Node(int left , int right) {
			this.left = left;
			this.right = right;
		}
	}
	
	private static List<Node> list[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		
		
		for(int i=1;i<n+1;i++)
			list[i] = new ArrayList<>();
		
		for(int i=1;i<n+1;i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int left = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			list[idx].add(new Node(left, right));
		}
			
	}

}
