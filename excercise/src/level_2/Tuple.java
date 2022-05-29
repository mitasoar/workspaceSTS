package level_2;

import java.util.Arrays;
import java.util.Comparator;

public class Tuple {
	
	public static void main(String[] args) {
		System.out.println(s("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
	}

	public static int[] s(String s) {
		int[] answer = {};
		
		String[] strs = s.substring(2, s.length() - 2).split("\\},\\{");
		
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		for (int i = 0; i < strs.length; i++) {
			String str = strs[i].replace(",", "");
			
			for (int a : answer) {
				str = str.replace(a + "", "");
			}
			
			answer = Arrays.copyOfRange(answer, 0, answer.length + 1);
			answer[i] = Integer.parseInt(str);
		}
		
		return answer;
	}
	
}
