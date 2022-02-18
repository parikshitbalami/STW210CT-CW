package week2;

public class GoldProfit {
	
	

	public int checkProfit(int[] price, int start, int end)
	{
	 
	    // If the stocks can't be bought
	    if (end <= start)
	        return 0;
	 
	    // Initialise the profit
	    int profit = 0;
	 
	    // The day at which the stock
	    // must be bought
	    for (int i = start; i < end; i++)
	    {
	 
	        // The day at which the
	        // stock must be sold
	        for (int j = i + 1; j <= end; j++)
	        {
	 
	            // If buying the stock at ith day and
	            // selling it at jth day is profitable
	            if (price[j] > price[i])
	            {
	 
	                // Update the current profit
	                int curr_profit = price[j] - price[i]
	                                + checkProfit(price, start, i - 1)
	                                + checkProfit(price, j + 1, end);
	 
	                // Update the maximum profit so far
	                profit = Math.max(profit, curr_profit);
	            }
	        }
	    }
	    return profit;
	}
	

}
