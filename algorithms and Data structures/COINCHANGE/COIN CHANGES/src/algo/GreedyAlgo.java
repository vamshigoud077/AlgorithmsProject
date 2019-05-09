package algo;

import java.util.HashMap;
import java.util.Map;

public class GreedyAlgo {

	public void minimumCoins(int[] coins_ar, int l, int amount) 
	{
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();

		int i = l - 1;
		boolean fl = true;
		
		if(amount == 0) {
			fl = false;
		}
		
		while (i >= 0) {
			while (amount >= coins_ar[i]) {
				amount = amount - coins_ar[i];
				if (result.get(coins_ar[i]) == null) {
					result.put(coins_ar[i], 1);
				} else {
					int temp = result.get(coins_ar[i]);
					result.put(coins_ar[i], temp + 1);
				}
			}
			i = i - 1;
		}
		
		if(fl && amount != 0) {
			fl = false;
		}
		
		
		if (fl) {
			System.out.println("Coins used are below");
			for (int k : result.keySet()) {
				System.out.println(result.get(k) + " denomination of coins " + k);
			}
			System.out.println();
		}
		else {
			System.out.println("......Invaid Input.....");
		}
	}

}
