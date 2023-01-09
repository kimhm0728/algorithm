package week1_2;

import java.util.*;
import java.io.*;

public class B_21758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] honey = new int[N];

		int answer = 0;
		int first, second, middle;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum += honey[i];
		}

		first = sum - honey[0]; // 가장 왼쪽 벌이 딴 꿀의 양 (가장 오른쪽이 벌통인 경우 첫 번째 벌은 왼쪽 벌으로 고정)
		second = first;
		middle = sum - honey[0] - honey[N - 1]; // 중간에 벌통이 존재하는 경우 -> 전체 합에서 양끝 빼고 중간값 더하기

		for(int i=1;i<N-1;i++) {
			// 중간에 벌통이 존재하는 경우 
			answer = Math.max(middle + honey[i], answer);

			// 가장 오른쪽이 벌통
			first -= honey[i]; // i가 두 번째 벌인 경우, 그 장소의 꿀 제외
			second -= honey[i];
			answer = Math.max(first + second, answer);
			first += honey[i]; // 다시 되돌리기 (두 번째 벌은 왼쪽으로 한 칸씩 이동하면서 꿀의 양이 줄어드므로 되돌리지 않음)
		}

		first = sum - honey[N - 1]; // 가장 오른쪽 벌이 딴 꿀의 양 (가장 왼쪽이 벌통인 경우 첫 번째 벌은 오른쪽 벌으로 고정)
		second = first;

		for(int i=N-2;i>0;i--) {
			// 가장 왼쪽이 벌통
			first -= honey[i]; // i가 두 번째 벌인 경우, 그 장소의 꿀 제외
			second -= honey[i];
			answer = Math.max(first + second, answer);
			first += honey[i]; // 다시 되돌리기 (두 번째 벌은 왼쪽으로 한 칸씩 이동하면서 꿀의 양이 줄어드므로 되돌리지 않음)
		}

		System.out.println(answer);
	}

}
