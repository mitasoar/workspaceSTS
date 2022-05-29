package level_1;

import java.util.Arrays;

public class TwoSelectPlus {

	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(solution(new int[] {5, 0, 2, 7})));
		
	}

	public static int[] solution(int[] numbers) {
        int[] answer = {};
        
        for(int i = 0; i < numbers.length - 1; i++) {
        	for (int j = i + 1; j < numbers.length; j++) {
        	 	answer = Arrays.copyOfRange(answer, 0, answer.length + 1);
            	answer[answer.length - 1] = numbers[i] + numbers[j];
        	}
        }
        
        answer = Arrays.stream(answer).distinct().toArray();
        
        Arrays.sort(answer);
        
        return answer;
    }
}
