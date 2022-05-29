package level_2;

import java.util.Arrays;

public class MoreSpicy_Time {

	public int solution(int[] scoville, int K) {
		int answer = 0;
		
		while (true) {
			Arrays.sort(scoville);
			if (scoville[0] < K) {
				int a = scoville[0] + (scoville[1] * 2);
				scoville = Arrays.copyOfRange(scoville, 2, scoville.length + 1);
				scoville[scoville.length - 1] = a;
				answer++;
				continue;
			}
			break;
		}
		
		return answer;
	}

}
