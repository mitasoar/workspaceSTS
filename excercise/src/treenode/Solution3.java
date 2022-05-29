package treenode;

import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(solution(5, new int[][] {{1, 2, 1000}, {1, 5, 2000}, {2, 3, 3000}, {2, 4, 1500}, {3, 4, 1000}, {4, 5, 2000}} , 3));
	}
	
	public static int solution(int N, int[][] fees, int dest) {
        int answer = 0;
        int bank = 1;
        
        Arrays.sort(fees, (o1, o2) -> {
        	return o2[2] - o1[2];
        });
        
        for (int k = 0; k < 3; k++) {
        	System.out.println("@@@@@@@@@@@@@@@@@");
        	System.out.println("현재 은행 -> " + bank);
        	System.out.println("현재 수수료 -> " + answer);
            for (int i = 0; i < fees.length; i++) {
            	if ((fees[i][0] == bank && fees[i][1] == dest) || (fees[i][1] == bank && fees[i][2] == dest)) { // 마지막 송금
            		answer += fees[i][2];
            		return answer;
            	}
            	if (fees[i][0] == bank || fees[i][1] == bank) {
            		System.out.println(Arrays.toString(fees[i]));
            		if (fees[i][0] == bank) {
            			bank = fees[i][1];
            			answer += fees[i][2];
            		} else {
            			bank = fees[i][0];
            			answer += fees[i][2];
            		}
            	}
            }
        }
		return answer;
        
    }
}
