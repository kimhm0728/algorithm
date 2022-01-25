package class2;
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
			// 인덱스 0, 1는 현재 위치 (x, y)
			// 인덱스 2, 3은 직사각형의 오른쪽 위 꼭짓점 (w, h)
		}
		int min = Math.min(arr[0], arr[1]);
		// 현재 위치에서 좌표축의 경계선으로 갈 수 있는 최솟값
		
		if(min > arr[2] - arr[0]) // w - x
			min = arr[2] - arr[0];
		if(min > arr[3] - arr[1]) // h - y
			min = arr[3] - arr[1];
		// 두 if문 모두 만족할 수 있으므로 else if문 쓰지 않음
		
		System.out.println(min);
		
	}

}
