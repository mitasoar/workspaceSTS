package level_2;

public class MatrixMultiply {

	public static void main(String[] mita) {
		
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2[0].length];

		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				int num = 0;
				for (int k = 0; k < arr2.length; k++) {
					num += arr1[i][k] * arr2[k][i];
				}
				answer[i][j] = num;
			}
		}
		return answer;
	}
}
