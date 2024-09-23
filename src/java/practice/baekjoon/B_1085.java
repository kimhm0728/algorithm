package java.practice.baekjoon;
import java.io.*;
import java.util.StringTokenizer;

public class B_1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int i = 0;
		while(st.hasMoreTokens()) {
			arr[i] = Integer.parseInt(st.nextToken());
			i++;
			// �ε��� 0, 1�� ���� ��ġ (x, y)
			// �ε��� 2, 3�� ���簢���� ������ �� ������ (w, h)
		}
		int min = Math.min(arr[0], arr[1]);
		// ���� ��ġ���� ��ǥ���� ��輱���� �� �� �ִ� �ּڰ�
		
		if(min > arr[2] - arr[0]) // w - x
			min = arr[2] - arr[0];
		if(min > arr[3] - arr[1]) // h - y
			min = arr[3] - arr[1];
		// �� if�� ��� ������ �� �����Ƿ� else if�� ���� ����
		
		System.out.println(min);
		
	}

}
