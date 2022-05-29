package level_2;

import java.util.Arrays;

public class MakeLargeNum_Time {

	public static void main(String[] mita) {
		System.out.println(solution("123456789", 4));
		System.out.println("다음");
		System.out.println(solution("84965", 2));
		System.out.println("다음");
		System.out.println(solution("8496", 2));
		System.out.println("다음");
		System.out.println(solution("561828917", 4));
		System.out.println("다음");
		System.out.println(solution("291874621", 4));
		System.out.println("다음");
		System.out.println(solution("987654321", 4));
		System.out.println("다음");
		System.out.println(solution("5161", 4));
		System.out.println("다음");
		System.out.println(solution("89", 2));
		System.out.println("다음");
		System.out.println(solution("987654321", 2));
	}

	public static String solution(String number, int k) {
		String answer = "";
		char[] chs = number.toCharArray();
		Arrays.sort(chs);
		int n = chs.length - 1;
		int a = 0;
		int s = k;
		
		while (true) {
			chs = number.toCharArray();
			n = chs.length - 1;
			while (true) {
				a = number.indexOf(chs[n]);
				System.out.println(a);
				if (answer.length() == s) { 
					return answer;
				}
				if (number.length() - a > s - answer.length()) {
					answer += number.substring(a, a + 1);
					break;
				} else if (number.length() - a < s - answer.length()) {
					n--;
				} else if (number.length() - a == s - answer.length()) {
					return answer += number.substring(a);
				}
			}
			number = number.substring(a + 1);
			k -= answer.length();
		}
	}
}
