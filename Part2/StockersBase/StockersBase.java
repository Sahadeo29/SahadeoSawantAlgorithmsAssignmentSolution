package com.GL.GradedAssignment2.Part2.StockersBase;

//Number of companies whose stock price rose or declined today
public class StockersBase {
	public int count(boolean profit[]) {
		int count = 0;
		for (int i = 0; i < profit.length; i++) {
			if (profit[i] == true)
				count++;
		}
		return count;
	}
}