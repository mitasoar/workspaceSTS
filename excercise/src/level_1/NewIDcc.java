package level_1;

public class NewIDcc {

	public static void main(String[] args) {
		
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm..."));
		System.out.println(solution("abcdefghijklmn.p"));
		
	}
	
	public static String solution(String new_id) {
        String answer = "";
        
        answer = new_id.toLowerCase(); // 1단계
        
        answer = answer.replaceAll("[^a-z0-9-_.]", ""); // 2단계
        
        answer = answer.replaceAll("[.]{2,}", "."); // 3단계
        
        answer = answer.replaceAll("^[.]|[.]$", ""); // 4단계
        
        if (answer.isEmpty()) { // 5단계
        	answer = "a"; 
        }
        
        if (answer.length() > 15) { // 6단계
        	answer = answer.substring(0, 15);
        	answer = answer.replaceAll("[.]$", "");
        }
        
        while (answer.length() < 3) { // 7단계
        	answer += answer.substring(answer.length() - 1);
        }
        
        return answer;
    }

}
