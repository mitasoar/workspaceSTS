package level_1;

public class DivisorPlus {

	public static void main(String[] args) {
		solution(13, 17);
	}

	public static int solution(int left, int right) {
		int answer = 0;
		
		for (int i = left; i <= right; i++) {
			if (i == 1 || Math.sqrt(i) * 10 % 10 == 0) answer -= i;
			else answer += i;
		}
		
		return answer;
	}

}
