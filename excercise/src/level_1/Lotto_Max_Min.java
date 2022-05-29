package level_1;

import java.util.Arrays;

public class Lotto_Max_Min {

	public static void main(String[] args) {
		// int[] a = {44, 1, 0, 0, 31, 25};
		// int[] b = {31, 10, 45, 1, 6, 19};
		System.out.println(Arrays.toString
				(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19})));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = {};
		int win = 0; // 당첨 갯수
		int zero = 0; // 0의 갯수
		
		for (int i = 0 ; i < lottos.length ; i++) { // 로또 번호를 하나씩 확인
			if (lottos[i] != 0) { // 로또 번호 0을 제외
				for (int j = 0 ; j < win_nums.length ; j++) { // 당첨번호 확인
					if (lottos[i] == win_nums[j]) { // 번호가 같을 때
						win++; // 당첨 숫자 증가
						break; // 더 찾을 필요없기에 for문 중단
					}
				}
			} else { // 0일 때
				zero++; // 0 카운트 증가
			}
		}
		
		if (zero == 0) { // 0이 없을 때
			if (win == 6) {
				answer = new int[] {1, 1};
			} else if (win == 5) {
				answer = new int[] {2, 2};
			} else if (win == 4) {
				answer = new int[] {3, 3};
			} else if (win == 3) {
				answer = new int[] {4, 4};
			} else if (win == 2) {
				answer = new int[] {5, 5};
			} else {
				answer = new int[] {6, 6};
			}
		} else { // 0이 있을 때
			if (win == 6) {
				answer = new int[] {1, 1};
			} else if (win == 5) {
				answer = new int[] {2 - zero, 2};
			} else if (win == 4) {
				answer = new int[] {3 - zero, 3};
			} else if (win == 3) {
				answer = new int[] {4 - zero, 4};
			} else if (win == 2) {
				answer = new int[] {5 - zero, 5};
			} else if (win == 1) { // 0이 있을 때는 하나라도 맞는지 확인
				answer = new int[] {6 - zero, 6};
			} else {
				answer = new int[] {7 - zero, 6};
			}
		}
		
		return answer;
	}

}
