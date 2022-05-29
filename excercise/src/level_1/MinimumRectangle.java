package level_1;

public class MinimumRectangle {

	public static void main(String[] args) {
		
		System.out.println(solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}}));
		
	}
	
	 public static int solution(int[][] sizes) {
	        int wid = 0;
	        int ver = 0;
	        
	        for (int i = 0; i < sizes.length; i++) {
	        	int max = Math.max(sizes[i][0], sizes[i][1]);
	        	int min = Math.min(sizes[i][0], sizes[i][1]);
	        	wid = wid < max ? max : wid;
	        	ver = ver < min ? min : ver;
	        }
	        
	        return wid * ver;
	    }

}
