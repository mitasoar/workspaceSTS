package level_2;

import java.util.Arrays;

public class MakeLargeNum_Doing {

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
	}

	public static String solution(String number, int k) {
		String answer = "";
		char[] chs = number.toCharArray();
		Arrays.sort(chs);
		int n = chs.length - 1;
		int a = 0;
		int s = number.length() - k;
		while (true) {
			chs = number.toCharArray();
			Arrays.sort(chs);
			n = chs.length - 1;
			while (true) {
				a = number.indexOf(chs[n]);
//				System.out.println("찾은 수는 => " + chs[n] + ", 인덱스는 => " + a);
				if (answer.length() == s) return answer;
				if (number.length() - a > s - answer.length()) {
					answer += number.substring(a, a+1);
//					System.out.println("추가열");
					break;
				} else if (number.length() - a < s - answer.length()) {
//					System.out.println("숫자가 크다");
					n--;
				} else if (number.length() - a == s - answer.length()){
//					System.out.println("딱 맞네");
					return answer += number.substring(a);
				}
			}
			number = number.substring(a + 1);
//			System.out.println("가져온 수 => " + answer);
//			System.out.println("남은 수 => " + number);
//			System.out.println("가져온 수의 인덱스 => " + a);
//			System.out.println("빼야할 수 => " + k);
			k -= answer.length();
//			System.out.println("빼야할 수 적용값 => " + k);
//			System.out.println();
		}

//		for (int i = 0; i < number.length() - k - 1; i++) {
//			for (int j = i + 1; j < number.length() - k - 1; j++) {
//				if (number.charAt(i) < number.charAt(j)) {
//					i = j - 1;
//					num = j;
//					System.out.println("위" + number.charAt(j) + " " + num);
//					break;
//				}
//				if (j == number.length() - k - 1) {
//					num = i;
//					System.out.println("?");
//					i = number.length();
//				}
//			}
//		}

	}

}
