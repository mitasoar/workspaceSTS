package level_2;

public class DoubleDelete_Time {
	
	public static void main(String[] mita) {

	}
	
	public static int solution(String s) {
		if (s.length() == 1) {
        	return 0;
        }
        
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                s = s.substring(0, i) + s.substring(i + 2, s.length());
                i = -1;
                continue;
            }
        }
        
        if (s.length() == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
