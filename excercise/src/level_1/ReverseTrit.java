package level_1;

public class ReverseTrit {

	public static void main(String[] args) {
		
		System.out.println(solution(3));
		
	}
	
	 public static int solution(int n) {
	        int answer = 0;
	        
	        int three = 0;
	        
	        String str = "";
	        
	        for (int i = 1; i <= n; i *= 3) {
	        	three = i;
	        }
	        
	        for (int j = three; j > 0; j /= 3) {
	        	int num = n / j;
	        	str += num;
	        	n -= j * num;
	        }
	        
	        for (int k = str.length() - 1; k > -1; k--) {
	        	answer += three * (str.charAt(k) - 48);
	        	three /= 3;
	        }
	        
	        return answer;
	    }

}
