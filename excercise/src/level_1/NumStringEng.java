package level_1;

public class NumStringEng {

	public static void main(String[] args) {
		
		System.out.println(solution("zero33"));
		
	}

	public static int solution(String s) {
		
			int answer = 0;
			
			if (s.matches(".*zero.*")) s = s.replaceAll("zero", "0"); // zero -> 0
			if (s.matches(".*one.*")) s = s.replaceAll("one", "1"); // one -> 1
			if (s.matches(".*two.*")) s = s.replaceAll("two", "2"); // two -> 2
			if (s.matches(".*three.*")) s = s.replaceAll("three", "3"); // three -> 3
			if (s.matches(".*four.*")) s = s.replaceAll("four", "4"); // four -> 4
			if (s.matches(".*five.*")) s = s.replaceAll("five", "5"); // five -> 5
			if (s.matches(".*six.*")) s = s.replaceAll("six", "6"); // six -> 6
			if (s.matches(".*seven.*")) s = s.replaceAll("seven", "7"); // seven -> 7
			if (s.matches(".*eight.*")) s = s.replaceAll("eight", "8"); // eight -> 8
			if (s.matches(".*nine.*")) s = s.replaceAll("nine", "9"); // nine -> 9
			
			answer = Integer.parseInt(s);
			
			return answer;
		
	}

}
