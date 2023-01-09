package week1_2;

import java.util.*;
import java.io.*;

public class B_21758 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] honey = new int[N];

		int answer = 0;
		int firstR, secondR, firstL, secondL;
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			honey[i] = Integer.parseInt(st.nextToken());
			sum += honey[i];
		}

		firstR = sum - honey[0]; // 가장 왼쪽 벌이 딴 꿀의 양 (가장 오른쪽이 벌통인 경우 첫 번째 벌은 왼쪽 벌으로 고정)
		secondR = firstR;
		firstL = sum - honey[N - 1]; // 가장 오른쪽 벌이 딴 꿀의 양 (가장 왼쪽이 벌통인 경우 첫 번째 벌은 오른쪽 벌으로 고정)
		secondL = firstL;
		int middle = sum - honey[0] - honey[N - 1]; // 중간에 벌통이 존재하는 경우 -> 전체 합에서 양끝 빼고 중간값 더하기

		
		for(int i=0;i<N;i++) {
			if(i != N - 1 && i != 0) { // 중간에 벌통이 존재하는 경우 
				answer = Math.max(middle + honey[i], answer);
			}
			else if(i != 0) { // 가장 오른쪽이 벌통
				firstR -= honey[i]; // i가 두 번째 벌인 경우, 그 장소의 꿀 제외
				secondR -= honey[i];
				answer = Math.max(firstR + secondR, answer);
				firstR += honey[i]; // 다시 되돌리기 (두 번째 벌은 왼쪽으로 한 칸씩 이동하면서 꿀의 양이 줄어드므로 되돌리지 않음)
			}			
			else if(i != N -1) { // 가장 왼쪽이 벌통
				firstL -= honey[i]; // i가 두 번째 벌인 경우, 그 장소의 꿀 제외
				secondL -= honey[i];
				answer = Math.max(firstL + secondL, answer);
				firstL += honey[i]; // 다시 되돌리기 (두 번째 벌은 오른쪽으로 한 칸씩 이동하면서 꿀의 양이 줄어드므로 되돌리지 않음)
			}
		}

		System.out.println(answer);
	}

}
