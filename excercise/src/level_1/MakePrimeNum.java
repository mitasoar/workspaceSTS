package level_1;

import java.util.Arrays;

public class MakePrimeNum {

	public static void main(String[] args) {

		solution(new int[] { 1, 2, 3, 4, 5, 6, 7 });

	}

	public static int solution(int[] nums) {
		int answer = 0;

		int[] num = new int[0];

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					num = Arrays.copyOfRange(num, 0, num.length + 1);
					num[num.length - 1] = nums[i] + nums[j] + nums[k];
				}
			}
		}
		
//		num = Arrays.stream(num).distinct().toArray();

		for (int a : num) {
			boolean noPrime = true;
			if (a != 1 && a % 2 != 0) {
				for (int i = 3; i <= Math.round(Math.sqrt(a)); i += 2) {
					if (a % i == 0) {
						noPrime = false;
						break;
					}
				}
				if (noPrime) answer++;
			}
		}
		
		return answer;
	}

}
