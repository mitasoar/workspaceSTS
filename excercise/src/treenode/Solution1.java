package treenode;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{2, 5}, {3, 7}, {10, 11}}));
	}
	
	 public static int solution(int[][] flowers) {
	        Set<Integer> days = new HashSet<Integer>();
	        
	        for (int i = 0; i < flowers.length; i++) {
	        	for (int j = flowers[i][0]; j < flowers[i][flowers[i].length - 1]; j++) {
	        		days.add(j);
	        	}
	        }
	        
	        return days.size();
	    }
}
