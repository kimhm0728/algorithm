package java.practice.baekjoon;
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
		heap.add(0); // �ε��� 0�� ������� ����
	}
	public void insert(int val) {
		heap.add(val);
		int p = heap.size()-1; // ���� ������ ����� ��ġ ����
		while(p > 1 && heap.get(p) < heap.get(p/2)) {
			// ������ ��尡 ��Ʈ ��尡 �ƴϰ� �θ� �ڽĺ��� ũ��
			int tmp = heap.get(p/2);
			heap.set(p/2, val);
			heap.set(p, tmp);
			// �θ�� �ڽ� ��ġ ����

			p /= 2;
		}
	}
	public int delete() {
		if(heap.size()-1 < 1)
			return 0;

		int del = heap.get(1);
		// ��Ʈ ��带 ����

		heap.set(1, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		// ������ ��带 ��Ʈ�� �����ϰ� ������ ��� ����

		int p = 1; // ���� ������ ����� ��ġ (��Ʈ ���)

		while(p * 2 < heap.size()) {
			// �ڽ��� �� ����� ��� ������ while�� �ݺ�
			int min = heap.get(p*2); // ���� �ڽ��� ��
			int minP = p*2; // ���� �ڽ��� �ε���

			if(2*p+1 < heap.size() && min > heap.get(2*p+1)) {
				// ������ �ڽ��� ���� �ڽĺ��� �۰� �� ����� ����� ������
				min = heap.get(2*p+1);
				minP = 2*p+1;
			}
			if(heap.get(p) < min)
				break; // �θ� �� ������ ��������

			int tmp = heap.get(p);
			heap.set(p, min);
			heap.set(minP, tmp);
			p = minP;
			// �θ�� �ڽ� ��ġ ����
		}
		return del;
	}
}