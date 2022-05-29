package level_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPrimeNum_Time {

	public static void main(String[] mita) {
		System.out.println(solution("011"));
	}

	public static int solution(String numbers) {
		int answer = 0;

		Set<Integer> numSet = new HashSet<>();

		String[] strs = numbers.split("");

		for (int i = 0; i < strs.length; i++) {
			numSet.add(Integer.parseInt(strs[i]));
			String str = strs[i];
			for (int j = 0; j < strs.length; j++) {
				if (strs[i] != strs[j]) {
					str += strs[j];
					numSet.add(Integer.parseInt(str));
				}
			}
		}

		for (int a = 0; a < strs.length; a++) {
			String[] strsss = Arrays.copyOfRange(strs, 0, strs.length);
			String sk = strsss[0];
			strsss[0] = strsss[a];
			strsss[a] = sk;
			for (int k = 0; k < strs.length; k++) {
				for (int l = k + 1; l + k < strs.length; l++) {
					String[] strss = Arrays.copyOfRange(strsss, 0, strsss.length);

					String st = strss[k];
					strss[k] = strss[k + l];
					strss[k + l] = st;

					for (int i = 0; i < strss.length; i++) {
						numSet.add(Integer.parseInt(strss[i]));
						String str = strss[i];
						for (int j = 0; j < strss.length; j++) {
							if (strss[i] != strss[j]) {
								str += strss[j];
								numSet.add(Integer.parseInt(str));
							}
						}
					}
				}
			}
		}

		int[] nums = Arrays.stream(numSet.toArray(new Integer[0])).mapToInt(i -> i).toArray();

		System.out.println(Arrays.toString(nums));

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 2) {
				answer++;
			} else if (nums[i] > 2 && nums[i] % 2 == 1) {
				boolean b = true;
				for (int j = 3; j <= Math.sqrt(nums[i]); j += 2) {
					if (nums[i] % j != 0) {
						continue;
					} else if (nums[i] % j == 0) {
						b = false;
						break;
					}
				}
				if (b == true) {
					answer++;
				}
			}
		}
		return answer;
	}

}
