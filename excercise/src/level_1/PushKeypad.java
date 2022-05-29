package level_1;

public class PushKeypad {

	public static void main(String[] args) {

		System.out.println(solution(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
		
	}

	public static String solution(int[] numbers, String hand) {
		String answer = "";

		// 위치를 *은 11, #은 12, 0은 10으로 대체

		int left = 11; // 왼쪽 손가락 위치
		int right = 12; // 오른쪽 손가락 위치

		for (int i : numbers) {
			
			if (i == 1 || i == 4 || i == 7) { // 왼쪽 버튼

				answer += "L";
				left = i;

			} else if (i == 3 || i == 6 || i == 9) { // 오른쪽 버튼

				answer += "R";
				right = i;

			} else { // 가운데 버튼

				if (hand.equals("left")) { // 왼손잡이

					if (i == 2) {
						
						if (left == 2) {
							answer += "L";
							left = i;
						} else if (right == 2) {
							answer += "R";
							right = i;
						} else if (left == 1 || left == 5) {
							answer += "L";
							left = i;
						} else if (right == 3 || right == 5) {
							answer += "R";
							right = i;
						} else if (left == 4 || left == 8) {
							answer += "L";
							left = i;
						} else if (right == 6 || right == 8) {
							answer += "R";
							right = i;
						} else if (left == 7 || left == 10) {
							answer += "L";
							left = i;
						} else if (right == 9 || right == 10) {
							answer += "R";
							right = i;
						} else {
							answer += "L";
							left = i;
						}

					} else if (i == 5) {

						if (left == 5) {
							answer += "L";
							left = i;
						} else if (right == 5) {
							answer += "R";
							right = i;
						} else if (left == 2 || left == 4 || left == 8) {
							answer += "L";
							left = i;
						} else if (right == 2 || right == 6 || right == 8) {
							answer += "R";
							right = i;
						} else if (left == 1 || left == 7 || left == 10) {
							answer += "L";
							left = i;
						} else if (right == 3 || right == 9 || right == 10) {
							answer += "R";
							right = i;
						} else {
							answer += "L";
							left = i;
						}

					} else if (i == 8) {

						if (left == 8) {
							answer += "L";
							left = i;
						} else if (right == 8) {
							answer += "R";
							right = i;
						} else if (left == 5 || left == 7 || left == 10) {
							answer += "L";
							left = i;
						} else if (right == 5 || right == 9 || right == 10) {
							answer += "R";
							right = i;
						} else if (left == 2 || left == 4 || left == 11) {
							answer += "L";
							left = i;
						} else if (right == 2 || right == 6 || right == 12) {
							answer += "R";
							right = i;
						} else {
							answer += "L";
							left = i;
						}

					} else { // 0

						if (left == 10) {
							answer += "L";
							left = 10;
						} else if (right == 10) {
							answer += "R";
							right = 10;
						} else if (left == 8 || left == 11) { 
							answer += "L";
							left = 10;
						} else if (right == 8 || right == 12) { 
							answer += "R";
							right = 10;
						} else if (left == 5 || left == 7) {
							answer += "L";
							left = 10;
						} else if (right == 5 || right == 9) {
							answer += "R";
							right = 10;
						} else if (left == 2 || left == 4) {
							answer += "L";
							left = 10;
						} else if (right == 2 || right == 6) { 
							answer += "R";
							right = 10;
						} else { 
							answer += "L";
							left = 10;
						}

					}

				} else { // 오른손잡이

					if (i == 2) {

						if (right == 2) {
							answer += "R";
							right = i;
						} else if (left == 2) {
							answer += "L";
							left = i;
						} else if (right == 3 || right == 5) {
							answer += "R";
							right = i;
						} else if (left == 1 || left == 5) {
							answer += "L";
							left = i;
						} else if (right == 6 || right == 8) {
							answer += "R";
							right = i;
						} else if (left == 4 || left == 8) {
							answer += "L";
							left = i;
						} else if (right == 9 || right == 10) {
							answer += "R";
							right = i;
						} else if (left == 7 || left == 10) {
							answer += "L";
							left = i;
						} else {
							answer += "R";
							right = i;
						}

					} else if (i == 5) {

						if (right == 5) {
							answer += "R";
							right = i;
						} else if (left == 5) {
							answer += "L";
							left = i;
						} else if (right == 2 || right == 6 || right == 8) {
							answer += "R";
							right = i;
						} else if (left == 2 || left == 4 || left == 8) {
							answer += "L";
							left = i;
						} else if (right == 3 || right == 9 || right == 10) {
							answer += "R";
							right = i;
						} else if (left == 1 || left == 7 || left == 10) {
							answer += "L";
							left = i;
						} else {
							answer += "R";
							right = i;
						}

					} else if (i == 8) {

						if (right == 8) {
							answer += "R";
							right = i;
						} else if (left == 8) {
							answer += "L";
							left = i;
						} else if (right == 5 || right == 9 || right == 10) {
							answer += "R";
							right = i;
						} else if (left == 5 || left == 7 || left == 10) {
							answer += "L";
							left = i;
						} else if (right == 2 || right == 6 || right == 12) {
							answer += "R";
							right = i;
						} else if (left == 2 || left == 4 || left == 11) {
							answer += "L";
							left = i;
						} else {
							answer += "R";
							right = i;
						}

					} else { // 0

						if (right == 10) {
							answer += "R";
							right = 10;
						} else if (left == 10) {
							answer += "L";
							left = 10;
						} else if (right == 8 || right == 12) { 
							answer += "R";
							right = 10;
						} else if (left == 8 || left == 11) { 
							answer += "L";
							left = 10;
						} else if (right == 5 || right == 9) {
							answer += "R";
							right = 10;
						} else if (left == 5 || left == 7) {
							answer += "L";
							left = 10;
						} else if (right == 2 || right == 6) {
							answer += "R";
							right = 10;
						} else if (left == 2 || left == 4) { 
							answer += "L";
							left = 10;
						} else { 
							answer += "R";
							right = 10;
						}

					}
					
				}

			}
			
		}

		return answer;
	}

}
