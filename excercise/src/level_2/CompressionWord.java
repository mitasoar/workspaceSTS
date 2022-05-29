package level_2;

public class CompressionWord {

	public static void main(String[] args) {
		System.out.println(solution("xxxxxxxxxxxxxxyyyyyyyyyyyyyyyyy"));
	}
	
	 public static int solution(String s) {
	        int answer = s.length();
	        
	        for (int i = 1; i <= s.length() / 2; i++) {
	        	String[] strs = s.split("(?<=\\G.{" + i + "})");
	        	String str = strs[0];
	        	int ans = s.length();
	        	int cnt = 1;
	        	boolean match = false;
	        	for (int j = 1; j < strs.length; j++) {
	        		if (str.equals(strs[j])) {
	        			ans = match ?  ans : ++ans;
	        			match = true;
	        			cnt++;
	        			ans -= i;
	        		} else {
	        			str = strs[j];
	        			ans = cnt > 9 ? ans + String.valueOf(cnt).length() - 1 : ans;
	        			cnt = 1;
	        			match = false;
	        		}
	        	}
	        	ans = cnt > 9 ? ans + String.valueOf(cnt).length() - 1 : ans;
	        	answer = answer > ans ? ans : answer;
	        }
	        
	        return answer;
	    }

}
