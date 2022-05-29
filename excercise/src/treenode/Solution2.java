package treenode;

import java.util.*;

public class Solution2 {

	public static void main(String[] args) {
//		System.out.println(solution(8, new int[] { 3, 2, 1, 1, 5, 8, 10 }));
		System.out.println("@@@@@@@@@@@@@@@@@@@@@");
		System.out.println(solution(3, new int[] { 1,2,3,1}));
		System.out.println(solution(5, new int[] { 1,2,3,1}));
	}

	public static int solution(int num, int[] mark) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // key : 지목당한 사람, value : 지목하는 순서
		
		int answer = 0;
		
		for (int i = 0; i < num; i++) { // 지목하는 사람들을 차례로 탐색
			if (map.containsKey(answer)) { //  지목당하는 사람이 이전에 지목했다면..(무한루프)
				System.out.println(i + 1 + "번째 지목할 사람인 " + answer + "번 사람이 현재 지목당한 사람");
				System.out.println(map.get(answer) + "번째 지목 당했었음");
				
				return mark[map.get(num % (i + 1))];
			} else { // 없으면
				map.put(answer, i + 1);
			}
			answer = mark[answer]; // answer : 현재 지목당한 사람
		}
		
		return answer;
	}
}
