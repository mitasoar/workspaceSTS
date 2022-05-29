package level_1;

import java.util.*;

public class GetReportResults {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "muzi", "frodo", "apeach", "neo" },
				new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" }, 2)));
	}

	public static int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];

		Set<String> delRep = new HashSet<>(); // 신고 중복 제거리스트
		
		Map <String, String> repMap = new HashMap<>(); // 신고자 리스트 (key값 : 신고당한 유저, value값 : 신고한 유저들)

		Map<String, Integer> numRep = new HashMap<>(); // 신고횟수 저장 리스트 (key값 : 신고당한 유저, value값 : 신고 횟수)

		Map<String, Integer> idxMap = new HashMap<>(); // 신고자 index 저장 리스트 (key값 : 신고한 유저, value값 : 신고한 유저의 index)

		for (int i = 0; i < id_list.length; i++) { // 유저 index 등록
			idxMap.put(id_list[i], i);
		}

		for (String user : report) { // 중복 제거
			if (!delRep.contains(user)) { // 신고 중복 제거 리스트에 없을 때
				String[] users = user.split(" ");
				if (repMap.containsKey(users[1])) { // 신고자 리스트에 저장값이 있을 때
					repMap.put(users[1], users[0] + " " + repMap.get(users[1]));
				} else { // 없을 때
					repMap.put(users[1], users[0]);
				}
				
				if (!numRep.containsKey(users[1])) { // 신고가 없을 때
					numRep.put(users[1], 1); // 신고 횟수 저장
				} else if (numRep.containsKey(users[1]) && numRep.get(users[1]) < k) { // 신고가 중복으로 있을 때
					numRep.put(users[1], numRep.get(users[1]) + 1); // 신고 횟수 저장
				}
				
				delRep.add(user);
			}
		}
		
		for (String key : numRep.keySet()) {
			if (numRep.get(key)== k) { // 정지 일 때
				String[] reps = repMap.get(key).split(" "); // 신고자 목록을 배열로 정렬
				for (String rep : reps) {
					answer[idxMap.get(rep)]++; // 메일 횟수 증가
				}
			}
		}

		return answer;
		
//		 int[] answer = new int[id_list.length];
//
//			Set<String> delRep = new HashSet<>(); // 신고 중복 제거리스트
//
//			Map<String, Integer> numRep = new HashMap<>(); // 신고횟수 저장 리스트 (key값 : 신고당한 유저, value값 : 신고 횟수)
//
//			Map<String, Integer> idxMap = new HashMap<>(); // 신고횟수 저장 리스트 (key값 : 신고한 유저, value값 : 신고한 유저의 index)
//
//			for (String user : report) { // 중복 제거
//				delRep.add(user);
//			}
//
//			for (int i = 0; i < id_list.length; i++) { // 유저 index 등록
//				idxMap.put(id_list[i], i);
//			}
//
//			for (String users : delRep) { // 신고 리스트 탐색
//				String key = users.split(" ")[1];
//				if (!numRep.containsKey(key)) { // 신고가 없을 때
//					numRep.put(key, 1); // 신고 횟수 저장
//				} else if (numRep.containsKey(key) && numRep.get(key) < k) { // 신고가 중복으로 있을 때
//					numRep.put(key, numRep.get(key) + 1); // 신고 횟수 저장
//				}
//				
//				if (numRep.get(key) == k) {
//					for (String user : delRep) { // 신고 리스트 재탐색
//						if (key.equals(user.split(" ")[1])) { // 정지 유저를 찾았을 때
//							answer[idxMap.get(user.split(" ")[0])]++;
//						}
//					}
//					numRep.put(key, numRep.get(key) + 1); // 신고 횟수 저장
//				}
//			}
//
//			return answer;
	}
}
