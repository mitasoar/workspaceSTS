package level_1;

public class LackOfMoney {

	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}

	public static long solution(int price, int money, int count) {
        long answer = 0;
        
        for (int i = 1; i <= count; i++) {
        	answer += price * i;
        }
        
        return answer <= money ? 0 : answer - money;
    }
}
