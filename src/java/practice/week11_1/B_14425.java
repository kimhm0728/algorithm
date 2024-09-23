package java.practice.week11_1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Trie trie = new Trie();
		
		for(int i=0;i<N;i++)
			trie.insert(br.readLine());
		
		int cnt = 0;
		for(int i=0;i<M;i++)
			if(trie.search(br.readLine()))
				cnt++;
		
		System.out.println(cnt);
	}
	
	static class Trie {
		Node rootNode = new Node();
		
		void insert(String str) {
			Node node = this.rootNode;
			
			for(int i=0;i<str.length();i++)
				node = node.child.computeIfAbsent(str.charAt(i), key -> new Node());
		
			node.end = true;
		}
		
		boolean search(String str) {
			Node node = this.rootNode;
			
			for(int i=0;i<str.length();i++) {
				node = node.child.getOrDefault(str.charAt(i), null);
				if(node == null)
					return false;
			}
			
			return node.end;
		}
	}
	
	static class Node {
		HashMap<Character, Node> child = new HashMap<Character, Node>();
		boolean end;
	}

}
