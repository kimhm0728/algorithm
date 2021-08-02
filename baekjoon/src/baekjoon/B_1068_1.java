package baekjoon;
import java.io.*;
import java.util.*;

public class B_1068_1 {
	static int N;
	static int[] input; // 부모 노드 입력할 배열
	static int[] number; // 자식 노드 개수를 저장할 배열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		input = new int[N]; 
		number = new int[N];
		int count = 0; // 리프 노드의 개수
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			for(int j=0;j<N;j++) 
				if(input[i] == j)
					number[j]++;
		}
		int del = Integer.parseInt(br.readLine());
		delete(del);
		for(int i=0;i<N;i++) // 자식 노드가 0개면 count를 증가
			if(number[i] == 0)
				count++;
		System.out.print(count);
	}
	static void delete(int d) { // 노드의 개수와 삭제할 노드의 번호
		number[d] = -2; 
		for(int i=0;i<N;i++) 
			if(d == input[i])  // 삭제할 노드를 부모로 가지는 노드를 탐색
				delete(i);
	}
}