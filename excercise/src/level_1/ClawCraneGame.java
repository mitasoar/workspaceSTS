package level_1;

import java.util.ArrayList;
import java.util.List;

public class ClawCraneGame {

	public static void main(String[] args) {

		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
				{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));

	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;

		List<Integer> basket = new ArrayList<>(); // 바구니

		for (int m : moves) { // 인형뽑기
			for (int i = 0; i < board.length; i++) { // 인형탐색
				if (board[i][m - 1] != 0) {
					basket.add(board[i][m - 1]); // 바구니에 인형 넣기
					board[i][m - 1] = 0; // 인형 비우기
					break;
				}
			}
		}

		for (int i = 0; i < basket.size() - 1; i++) {
			if (basket.get(i) == basket.get(i + 1)) {
				basket.remove(i);
				basket.remove(i);
				answer += 2;
				if (i == 0) i -= 1;
				else i -= 2;
			}
		}

		return answer;
	}
}
