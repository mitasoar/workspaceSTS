package level_1;

public class InnerProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        
        for (int i = 0; i < a.length; i++) answer += a[i] * b[i];
        
        return answer;
    }

}
