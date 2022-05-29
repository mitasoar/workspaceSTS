package level_1;

import java.util.Arrays;

public class DefaultNumPlus {
	
	public static void main(String[] args) {
		solution(new int[] {1,2,3,4,6,7,8,0});
	}

	 public static int solution(int[] numbers) {
	        int answer = 0;
	        
	        Arrays.sort(numbers);
	        
	        for (int i = 0; i < 10; i++) {
	        	if (numbers.length != 0 && i == numbers[0]) {
	        		numbers = Arrays.copyOfRange(numbers, 1, numbers.length);
	        	} else {
	        		answer += i;
	        	}
	        }
	        
	        return answer;
	    }

}
