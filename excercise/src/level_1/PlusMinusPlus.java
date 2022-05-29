package level_1;

public class PlusMinusPlus {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {4, 7, 12}, new boolean[] {true, false, true}));
		
	}
	
	 public static int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        
	        for (int i = 0; i < signs.length; i++) {
	        	if (signs[i]) answer += absolutes[i];
	        	else answer -= absolutes[i];
	        }
	        
	        return answer;
	    }

}
