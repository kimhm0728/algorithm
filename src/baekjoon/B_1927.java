package baekjoon;
import java.io.*;
import java.util.*;

public class B_1927 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		minHeap heap = new minHeap();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0) {
				System.out.println(heap.delete());
			}
			else
				heap.insert(input);
		}
	}
}

class minHeap {
	private ArrayList<Integer> heap;
	public minHeap() {
		heap = new ArrayList<Integer>();
		heap.add(0); // 인덱스 0은 사용하지 않음
	}
	public void insert(int val) {
		heap.add(val);
		int p = heap.size()-1; // 현재 삽입한 노드의 위치 저장
		while(p > 1 && heap.get(p) < heap.get(p/2)) {
			// 삽입한 노드가 루트 노드가 아니고 부모가 자식보다 크면
			int tmp = heap.get(p/2);
			heap.set(p/2, val);
			heap.set(p, tmp);
			// 부모와 자식 위치 변경

			p /= 2;
		}
	}
	public int delete() {
		if(heap.size()-1 < 1)
			return 0;

		int del = heap.get(1);
		// 루트 노드를 삭제

		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		// 마지막 노드를 루트에 삽입하고 마지막 노드 삭제

		int p = 1; // 현재 삭제한 노드의 위치 (루트 노드)

		while(p * 2 < heap.size()) {
			// 자식이 힙 사이즈를 벗어날 때까지 while문 반복
			int min = heap.get(p*2); // 왼쪽 자식의 값
			int minP = p*2; // 왼쪽 자식의 인덱스

			if(2*p+1 < heap.size() && min > heap.get(2*p+1)) {
				// 오른쪽 자식이 왼쪽 자식보다 작고 힙 사이즈를 벗어나지 않으면
				min = heap.get(2*p+1);
				minP = 2*p+1;
			}
			if(heap.get(p) < min)
				break; // 부모가 더 작으면 빠져나옴

			int tmp = heap.get(p);
			heap.set(p, min);
			heap.set(minP, tmp);
			p = minP;
			// 부모와 자식 위치 변경
		}
		return del;
	}
}