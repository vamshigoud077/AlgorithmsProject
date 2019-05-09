package algo;

import java.util.HashMap;
import java.util.Map;

public class DynamicAlgo {

	public int count(int coins_arr[], int l, int amount) {
		int m[] = new int[amount + 1];
		int n[] = new int[amount + 1];
		m[0] = 0;
		for (int i = 1; i <= amount; i++) 
		{
			m[i] = Integer.MAX_VALUE - 1;
			n[i] = -1;
		}
		for (int j = 0; j < l; j++) {
			for (int i = 1; i <= amount; i++) {
				if (i >= coins_arr[j]) {
					if (m[i - coins_arr[j]] + 1 < m[i]) {
						m[i] = 1 + m[i - coins_arr[j]];
						n[i] = j;
					}
				}
			}
		}
		printcoindenominations(n, coins_arr);
		return m[amount];
	}

	public void printcoindenominations(int[] R, int[] coins) {
		
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();

		if (R[R.length - 1] == -1) {
			System.out.print("Invalid Input");
			return;
		}
		int start = R.length - 1;
		while (start != 0) {
			int j = R[start];
			if (result.get(coins[j]) == null) {
				result.put(coins[j], 1);
			} else {
				int temp = result.get(coins[j]);
				result.put(coins[j], temp + 1);
			}
			start = start - coins[j];
		}
		
		printFormatedMap(result);

	}
	
	public void printFormatedMap(Map<Integer, Integer> result) {
		System.out.println("Coins used are :");
		for (int k : result.keySet()) {
			System.out.println(result.get(k) + "  denomination of coins " + k);
		}
		System.out.println();
	}

}
